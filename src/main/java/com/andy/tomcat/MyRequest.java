package com.andy.tomcat;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by admin on 2019-01-28.
 */
@Data
public class MyRequest {
    private String url;
    private String method;
    public MyRequest(InputStream inputStream)throws IOException{
        String httpRequeset = "";
        byte[] httpRequesetBytes = new byte[1024];
        int length = 0;
        if((length = inputStream.read(httpRequesetBytes))>0){
            httpRequeset = new String(httpRequesetBytes,0,length);
        }
        String httpHead = httpRequeset.split("\n")[0];
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];
        System.out.println(this);
    }
}
