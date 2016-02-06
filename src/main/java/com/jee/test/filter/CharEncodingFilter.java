package com.jee.test.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by ZSt on 2016/2/5.
 */
public class CharEncodingFilter implements Filter {

    private String encoding;

    public void init(FilterConfig filterConfig) throws ServletException {
        String e = filterConfig.getInitParameter("encoding");
        if(e==null||"".equals(e.trim())){
            encoding = "UTF-8";
        }else {
            encoding = e;
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("encoding : "+encoding);
        servletRequest.setCharacterEncoding(encoding); //解决POST请求的乱码
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
