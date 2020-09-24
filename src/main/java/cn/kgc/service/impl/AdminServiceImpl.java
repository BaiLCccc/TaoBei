package cn.kgc.service.impl;

import cn.kgc.dao.AdminMapper;
import cn.kgc.entity.Admin;
import cn.kgc.service.AdminService;
import cn.kgc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class AdminServiceImpl implements AdminService {


    @Override
    public Admin getAdminByAnameAndApassword(Admin admin) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Admin adminByAnameAndApassword = mapper.getAdminByAnameAndApassword(admin);
        sqlSession.commit();
        sqlSession.close();

        return adminByAnameAndApassword;
    }

    @Override
    public void saveAdmin(Admin admin) {

    }
}
