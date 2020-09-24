package cn.kgc.web.servlet;

import cn.kgc.entity.User;
import cn.kgc.service.UserService;
import cn.kgc.service.impl.UserServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/UpdateQueryOneServlet")
public class UpdateQueryOneServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        UserService userService = new UserServiceImpl();
        String id = req.getParameter("uid");
        User userByUid = userService.getUserByUid(id);
        /*HttpSession session = req.getSession();
        session.setAttribute("queryOne",userByUid);*/
        /*User user = userService.getUserById(id);
        req.setAttribute("user",user);
        req.getRequestDispatcher("admin/index.html").forward(req,resp);*/

        //数据接收测试
        //System.out.println(userByUid);
        //将User转为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(userByUid);
        //并且传递给客户端
        resp.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.write(json);
        out.close();
    }
}
