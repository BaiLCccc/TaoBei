package cn.kgc.web.servlet;

import cn.kgc.entity.Page;
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
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //在service中调用查询所有数据的方法
        UserService userService = new UserServiceImpl();
        /**
         * 通过分页查询所有
         */

        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");
        if (pageSize==null||pageSize==""){
            pageSize = "9";
        }
        int ps = Integer.parseInt(pageSize);

        //查询到所有当前分页的所有用户信息
        Page<User> userByPage = userService.getUserByPage(pageNum, ps);
        //将查询到的信息存放到域中
        HttpSession session = req.getSession();
        session.setAttribute("page",userByPage);
        /*List<User> all = userService.getAll();
        HttpSession session = req.getSession();
        session.setAttribute("all",all);*/

        //resp.sendRedirect("management/index.html");
        resp.sendRedirect("manage/member-list.jsp");
        //req.getRequestDispatcher(req.getContextPath()+"manage/member-list.jsp").forward(req,resp);
    }
}
