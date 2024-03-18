package weew12.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Classname Aservlet
 * @Description
 *              ����servlet ���ַ�ʽ��
 *              ��ʽ1����web.xml ������
                *     <servlet>
                *         <servlet-name>Aservlet</servlet-name>
                *         <servlet-class>weew12.web.servlet.Aservlet</servlet-class>
                *     </servlet>
                *     <servlet-mapping>
                *         <servlet-name>Aservlet</servlet-name>
                *         <url-pattern>/ServletA</url-pattern>
                *     </servlet-mapping>
 *              ��ʽ2��ֱ��ʹ��ע��
 *              @WebServlet(name = "Aservlet", urlPatterns = {"/ServletA"})
 * @Date 2019-10-30
 * @Created by ��weew12
 */
@WebServlet(name = "Aservlet", urlPatterns = {"/ServletA"})
public class Aservlet implements Servlet {

    private transient ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        System.out.println("init()");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig()");
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        System.out.println("serviceA()");
        String servletName = servletConfig.getServletName();
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("<html><head></head>"
                + "<body><h1>Hello from " + servletName
                + "</h1></body></html>");
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
