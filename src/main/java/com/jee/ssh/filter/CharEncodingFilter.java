package com.jee.ssh.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by ZSt on 2016/2/27.
 */
public class CharEncodingFilter implements Filter {

    private String encoding = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String e = filterConfig.getInitParameter("encoding");
        if(e == null || "".equals(e.trim())){

        }else{
            encoding = e;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
