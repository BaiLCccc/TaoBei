package cn.kgc.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/*@WebFilter(urlPatterns = {"/personal/*","/order.html"})*/
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //0. 强制转换
        HttpServletRequest request = (HttpServletRequest)req;
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user != null){
            //登录了，放行
            chain.doFilter(req,resp);
        }else{
            //没有登录，跳转登陆页面
            PrintWriter out = resp.getWriter();
            out.print("<script language='javascript'>alert('您尚未登录，请登录！');window.location.href='/login.jsp';</script>");
            out.flush();
            out.close();
        }

        /*
        //1. 获取资源请求路径
        String uri = request.getRequestURI();
        //2. 判断是否包含登录相关资源路径，要注意排除掉 css/js/图片/验证码等资源
        if (uri.contains("/loginadmin.jsp")|| uri.contains("/AdminLoginServlet")|| uri.contains("/index.jsp") || uri.contains("/login.html") ||uri.contains("management/*") || uri.contains("/LoginServlet") || uri.contains("/js/") || uri.contains("/css/") || uri.contains("/img/") || uri.contains("/fonts/")){
            //包含，用户就是想登录，放行
            chain.doFilter(req,resp);
        }else{
            //不包含，需要验证用户是否登录
            //3.从获取Session中获取User
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                //登录了，放行
                chain.doFilter(req,resp);
            }else{
                //没有登录，跳转登陆页面
                PrintWriter out = resp.getWriter();
                out.print("<script language='javascript'>alert('您尚未登录，请登录！');window.location.href='/login.html';</script>");
                out.flush();
                out.close();
                //request.getRequestDispatcher("login.html").forward(request,resp);
            }
        }*/
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
