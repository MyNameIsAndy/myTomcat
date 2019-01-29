package com.andy.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2019-01-29.
 */
public class MyTomcat {
    private int port;
    private Map<String,String> urlServletMap = new HashMap<>();
    private MyTomcat(int port){
        this.port = port;
    }

    //初始化映射
    private void initServletMapping(){
        for(ServletMapping servletMapping : ServletMappingConfig.servletMappingList ){
            urlServletMap.put(servletMapping.getUrl(),servletMapping.getClazz());
        }
    }

    /**
     * 路由分发
     * @param myRequest
     * @param myResponse
     */
    private void dispatch(MyRequest myRequest , MyResponse myResponse){
        String clazz = urlServletMap.get(myRequest.getUrl());
        try{
            Class<MyServlet> forName = (Class<MyServlet>)Class.forName(clazz);
            MyServlet myServlet = forName.newInstance();
            myServlet.service(myRequest,myResponse);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void start(){
        //初始化，使路径和类名进行匹配
        initServletMapping();
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            while(true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);
                dispatch(myRequest,myResponse);
                socket.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new MyTomcat(9090).start();
    }
}
