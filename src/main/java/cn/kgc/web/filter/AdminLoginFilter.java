package cn.kgc.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/management/*")
public class AdminLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //0. 强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //1. 获取资源请求路径
        String uri = request.getRequestURI();
        //2. 判断是否包含登录相关资源路径，要注意排除掉 css/js/图片/验证码等资源
        if (uri.contains("/loginadmin.jsp")|| uri.contains("/index.jsp") || uri.contains("/AdminLoginServlet") || uri.contains("/js/") || uri.contains("/css/") || uri.contains("/img/") || uri.contains("/fonts/")){
            //包含，用户就是想登录，放行
            chain.doFilter(req,resp);
        }else{
            //不包含，需要验证用户是否登录
            //3.从获取Session中获取User
            Object admin = request.getSession().getAttribute("admin");
            if (admin != null){
                //登录了，放行
                chain.doFilter(req,resp);
            }else{
                //没有登录，跳转登陆页面
                PrintWriter out = resp.getWriter();
                out.print("<script language='javascript'>alert('您尚未登录，请登录！');window.location.href='/loginadmin.jsp';</script>");
                out.flush();
                out.close();
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
