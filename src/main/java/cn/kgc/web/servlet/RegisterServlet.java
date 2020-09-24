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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //1：接收用户提交表单的时候输入的值
        String uname = req.getParameter("uname");
        String upassword = req.getParameter("upassword");
        String upasswords = req.getParameter("upasswords");
        String uemail = req.getParameter("uemail");
        String uphone = req.getParameter("uphone");
        String yzm = req.getParameter("yzm");
        HttpSession session = req.getSession();
        String sms = (String) session.getAttribute("sms");
        //System.out.println(sms);
        //System.out.println(uname+upassword+upasswords+uemail+uphone+yzm);
        User user = new User();
        user.setUname(uname);
        user.setUpassword(upassword);
        user.setUphone(uphone);
        UserService userService = new UserServiceImpl();
        PrintWriter out = resp.getWriter();
        if(upasswords.equals(upassword)){
            if (yzm.equals(sms)){
                userService.saveUser(user);
                /*无返回值*/
                if(1==1){
                    out.print("<script language='javascript'>alert('注册成功！');window.location.href='login.jsp';</script>");
                    //req.getRequestDispatcher("login.jsp").forward(req,resp);
                }else{
                    //out.print("<script language='javascript'>alert('您输入的用户名已存在！');</script>");
                    req.setAttribute("msg","您输入的用户名已存在！");
                    req.getRequestDispatcher("register.jsp").forward(req,resp);
                }
            }else{
                //out.print("<script language='javascript'>alert('验证码输入有误！');</script>");
                req.setAttribute("msg","验证码输入有误！");
                req.getRequestDispatcher("register.jsp").forward(req,resp);
            }
        }else{
            //out.print("<script language='javascript'>alert('您输入的密码不匹配');");
            req.setAttribute("msg","您输入的密码不匹配！");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }
        out.flush();
        out.close();

    }
}
