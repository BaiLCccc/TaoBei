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

@WebServlet("/DelUserServlet")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //调用service中删除的方法
        UserService userService = new UserServiceImpl();
        String id = req.getParameter("uid");
        //System.out.println(id);
        userService.delUser(id);
        User userByUid = userService.getUserByUid(id);
        if (userByUid==null){
            //req.getRequestDispatcher("/UserListServlet").forward(req,resp);
            HttpSession session = req.getSession();
            session.setAttribute("msg","删除成功！");
            resp.sendRedirect("/UserListServlet");
            //resp.getWriter().print("删除成功!");
        }else{
            System.out.println("删除失败！");
            //resp.getWriter().print("删除失败!");
        }


    }
}
