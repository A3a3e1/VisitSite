package com.a3a3el.site.mvc;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by paulvoropaiev on 11/25/15.
 */
public class ErrorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception ex) {
            servletRequest.setAttribute("errorMessage: ", ex);
            servletRequest.getRequestDispatcher("");
        }
    }

    @Override
    public void destroy() {

    }
}
