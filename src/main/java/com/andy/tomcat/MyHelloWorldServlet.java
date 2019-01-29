package com.andy.tomcat;

/**
 * Created by admin on 2019-01-28.
 */
public class MyHelloWorldServlet extends MyServlet{
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try{
            myResponse.write("this hello world Get");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try{
            myResponse.write("this hello world Post");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
