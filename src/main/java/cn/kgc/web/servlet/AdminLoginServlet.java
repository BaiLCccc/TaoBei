package cn.kgc.web.servlet;

import cn.kgc.entity.Admin;
import cn.kgc.entity.Page;
import cn.kgc.entity.User;
import cn.kgc.service.AdminService;
import cn.kgc.service.UserService;
import cn.kgc.service.impl.AdminServiceImpl;
import cn.kgc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //接收用户从键盘输入的值
        String aname = req.getParameter("aname");
        String apassword = req.getParameter("apassword");
        UserService userService = new UserServiceImpl();
        Admin admin = new Admin();
        admin.setAname(aname);
        admin.setApassword(apassword);
        AdminService adminService = new AdminServiceImpl();

        Admin selectAdmin = adminService.getAdminByAnameAndApassword(admin);
        if(selectAdmin!=null){
            String pageNum = req.getParameter("pageNum");
            int pageSize = 9;
            //查询到所有当前分页的所有用户信息
            Page<User> userByPage = userService.getUserByPage(pageNum, pageSize);
            //将查询到的信息存放到域中
            HttpSession session = req.getSession();
            session.setAttribute("page",userByPage);
            session.setAttribute("admin",selectAdmin);

            //System.out.println(userByPage.getData());

            //resp.sendRedirect("/UserListServlet");
            //req.getRequestDispatcher("http://localhost:8080/admin/index.html").forward(req,resp);
            //resp.sendRedirect("http://localhost:8080/admin/index.html");
            resp.sendRedirect("manage/index.jsp");

        }else{
            //表示登录失败  重定向
            PrintWriter out = resp.getWriter();
            out.print("<script language='javascript'>alert('管理员名或密码错误！');window.location.href='manage/loginadmin.jsp';</script>");
            out.flush();
            out.close();
        }


    }
}
