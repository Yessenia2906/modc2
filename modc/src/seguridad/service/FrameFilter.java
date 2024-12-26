package seguridad.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrameFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        //Allows the page from the same website to be displayed in Frame, which is forbidden to display pages from other websites.
        res.setHeader("x-frame-options", "SAMEORIGIN");
        //This file is not allowed if the MIME type of the file read from Script or Stylesheet does not match the specified MIME type. Used to prevent cross-station scripting attacks such as XSS.
        res.setHeader("X-Content-Type-Options", "nosniff");
        //Used to enable the XSS filtering function of the browser to prevent the XSS cross-station script attack. 0 Disable XSS filtering function 1 Enable XSS filtering
        res.setHeader("X-XSS-Protection", "1; mode=block");
        //res.setHeader("Content-Security-Policy", "script-src 'self' http://localhost:8050/ayggfwpt-home-web/");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 
        
    }
    
}