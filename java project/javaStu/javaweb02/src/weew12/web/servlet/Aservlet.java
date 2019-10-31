package weew12.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @Classname Aservlet
 * @Description
 *              配置servlet 两种方式：
 *              方式1、在web.xml 中配置
                *     <servlet>
                *         <servlet-name>Aservlet</servlet-name>
                *         <servlet-class>weew12.web.servlet.Aservlet</servlet-class>
                *     </servlet>
                *     <servlet-mapping>
                *         <servlet-name>Aservlet</servlet-name>
                *         <url-pattern>/ServletA</url-pattern>
                *     </servlet-mapping>
 *              方式2、直接使用注解
*                @WebServlet(name = "Aservlet", urlPatterns = {"/ServletA"})
 * @Date 2019-10-30
 * @Created by 枫weew12
 */
@WebServlet(name = "Aservlet", urlPatterns = {"/ServletA"})
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
        System.out.println("serviceA()");
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
