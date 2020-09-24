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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/manage/findUserServlet")
public class FindUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //调用service中增加的方法
        UserService userService = new UserServiceImpl();
        String uname = req.getParameter("uname");

        User userByUname = userService.getUserByUname(uname);
        //接收数据测试
        //System.out.println(uname);

        resp.setContentType("application/json;charset=utf-8");
        Map<String,Object> map = new HashMap<String,Object>();
        if (userByUname!=null){
            //存在
            map.put("userExsit",true);
            map.put("msg","此用户名已注册,请更换一个!");
        }else{
            //不存在
            map.put("userExsit",false);
            map.put("msg","用户名可用");
        }
        //将map转为json，并且传递给客户端
        //将map转为json
        ObjectMapper mapper = new ObjectMapper();
        //并且传递给客户端
        mapper.writeValue(resp.getWriter(),map);
    }


}

