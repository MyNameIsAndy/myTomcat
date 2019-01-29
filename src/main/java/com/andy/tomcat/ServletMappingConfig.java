package com.andy.tomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2019-01-28.
 */
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList<>();
    static {
        servletMappingList.add(new ServletMapping("findGirl","/girl","com.andy.tomcat.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("helloWorld","/world","com.andy.tomcat.HelloWorldServlet"));
    }
}
