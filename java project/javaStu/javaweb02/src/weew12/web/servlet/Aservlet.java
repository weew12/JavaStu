package weew12.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Classname Aservlet
 * @Description
 * @Date 2019-10-30
 * @Created by ·ãweew12
 */
public class Aservlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init()");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig()");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service()");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo()");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy()");
    }
}
