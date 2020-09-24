package cn.kgc.web.servlet;

import cn.kgc.entity.User;
import cn.kgc.service.UserService;
import cn.kgc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 当我们的类继承HttpServlet的时候，里面的方法可以写
 * 方式一：
 *      service()
 * 方式二：
 *      doPost() 当表单提交方式是post的时候执行
 *      doGet()  当表单提交方式是get的时候执行
 *
 *  所有的Servlet都是在控制层(controller)
 *  所有的关于业务内容都是在业务(service)
 *  所有的jdbc内容所在都是持久化层(dao)
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //1：接收用户提交表单的时候输入的值
        String name = req.getParameter("uname");
        String password = req.getParameter("upassword");
        //2：根本用户输入的用户名和密码查找数据库是否有这个人（为了解耦，此步骤放在JDBC中，或者是放在dao层）
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setUname(name);
        user.setUpassword(password);

        User user1 = userService.getUserByNameAndPassword(user);
        if (user1 != null){
            //表示登录成功  转发
            HttpSession session = req.getSession();
            session.setAttribute("user",user1);
            //req.getRequestDispatcher("index.jsp").forward(req,resp);
            resp.sendRedirect("index.jsp");
        }else{
            //表示登录失败  重定向
            PrintWriter out = resp.getWriter();
            out.print("<script language='javascript'>alert('用户名或密码错误！');window.location.href='login.jsp';</script>");
            out.flush();
            out.close();
        }
    }
}
