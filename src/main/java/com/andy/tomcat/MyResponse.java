package com.andy.tomcat;

import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by admin on 2019-01-28.
 */
@Data
public class MyResponse {
    private OutputStream outputStream;
    public MyResponse(OutputStream outputStream){
        this.outputStream = outputStream;
    }
    public void write(String content)throws IOException{
        StringBuffer sb = new StringBuffer();
        sb.append("HTTP/1.1 200 OK\n")
        .append("Content-Type: text/html\n")
        .append("\r\n")
        .append("<html><body>")
        .append(content)
        .append("<body><html>");
        outputStream.write(sb.toString().getBytes());
        outputStream.close();
    }
}
