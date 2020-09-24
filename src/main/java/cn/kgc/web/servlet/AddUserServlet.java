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

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //调用service中增加的方法
        UserService userService = new UserServiceImpl();
        String uname = req.getParameter("uname");
        String upassword = req.getParameter("upassword");
        String uphone = req.getParameter("uphone");
        String uvalid = req.getParameter("uvalid");
        int uv = 0;
        if ("1".equals(uvalid)){
            uv = 1;
        }
        //接收数据测试
        //System.out.println(uname+upassword+uemail+uphone);
        User user = new User(null,uname,upassword,uphone,uv,1);
        userService.saveUser(user);
        HttpSession session = req.getSession();

            /*resp.sendRedirect("management/member-add3.jsp");*/
            session.setAttribute("msg","增加成功!");
            resp.sendRedirect("/UserListServlet");



    }
}
