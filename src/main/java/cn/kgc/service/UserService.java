package cn.kgc.service;

import cn.kgc.entity.Page;
import cn.kgc.entity.User;

import java.util.List;

public interface UserService {
    //登录方法
    User getUserByNameAndPassword(User user);
    //增加用户方法
    void saveUser(User user);
    //删除用户
    void delUser(String uid);
    //修改用户
    void updateUser(User user);
    //根据id查询一个用户
    User getUserByUid(String uid);
    //查询所有用户
    List<User> getAll();
    //使用分页查询当前页面的用户信息
    Page<User> getUserByPage(String pageNum, int pageSize);
    //根据uname查用户
    User getUserByUname(String uname);
}
