package com.andy.tomcat;

import lombok.Data;

/**
 * Created by admin on 2019-01-28.
 */
@Data
public class ServletMapping {
    private String url;
    private String servletName;
    private String clazz;
    public ServletMapping(String servletName,String url,String clazz){
        this.url = url;
        this.servletName = servletName;
        this.clazz = clazz;
    }
}
