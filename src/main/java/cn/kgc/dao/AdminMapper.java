package cn.kgc.dao;

import cn.kgc.entity.Admin;
import cn.kgc.entity.Page;

import java.util.List;

public interface AdminMapper {
     Admin getAdminByAnameAndApassword(Admin admin);

     void saveAdmin(Admin admin);

     void updateAdmin(Admin admin);

     void delAdmin(String aid);

     //根据id查询一个管理员
     Admin getAdminByAid(String aid);
     //查询所有管理员
     List<Admin> getAll();
     //使用分页查询当前页面的管理员信息
     List<Admin> getAdminByPage(Page<Admin> page);
}
