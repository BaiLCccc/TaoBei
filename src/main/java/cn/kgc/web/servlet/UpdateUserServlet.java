package cn.kgc.web.servlet;

import cn.kgc.entity.User;
import cn.kgc.service.UserService;
import cn.kgc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //调用service中删除的方法
        UserService userService = new UserServiceImpl();
        String uid = req.getParameter("edituid");
        String uname = req.getParameter("edituname");
        String upassword = req.getParameter("editupassword");
        String uphone = req.getParameter("edituphone");
        String uvalid = req.getParameter("edituvalid");
        System.out.println(uvalid);
        int uv = 0;
        if ("1".equals(uvalid)){
            uv = 1;
        }
        int i1 = Integer.parseInt(uid);

        User user = new User(i1,uname,upassword,uphone,uv,1);
        userService.updateUser(user);

        resp.sendRedirect("/UserListServlet");

    }
}
