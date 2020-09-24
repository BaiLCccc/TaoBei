package cn.kgc.service;

import cn.kgc.entity.Admin;

public interface AdminService {
     Admin getAdminByAnameAndApassword(Admin admin);
     void saveAdmin(Admin admin);
}
