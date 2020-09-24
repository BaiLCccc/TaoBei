package cn.kgc.service.impl;

import cn.kgc.dao.UserMapper;
import cn.kgc.entity.Page;
import cn.kgc.entity.User;
import cn.kgc.service.UserService;
import cn.kgc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {


    @Override
    public User getUserByNameAndPassword(User user) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.saveUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delUser(String uid) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.delUser(uid);

        sqlSession.commit();
        sqlSession.close();

    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User getUserByUid(String uid) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userByUid = mapper.getUserByUid(uid);

        sqlSession.commit();
        sqlSession.close();

        return userByUid;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Page<User> getUserByPage(String pageNum, int pageSize) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


//默认当前页在第一页
        int pn = 1;
        try{
            pn = Integer.parseInt(pageNum);
        }catch (Exception e){}
        Page<User> page = new Page<>();
        String sinlvalue = mapper.getSinlvalue();
        int tc =0;
        if (sinlvalue!=null){
            tc = Integer.parseInt(sinlvalue);
        }
        page.setTotalCount(tc);
        page.setPageSize(pageSize);
        page.setPageNum(pn);
        page.setData(mapper.getUserByPage(page));

        sqlSession.commit();
        sqlSession.close();

        return page;

    }

    @Override
    public User getUserByUname(String uname) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userByUname = mapper.getUserByUname(uname);

        sqlSession.commit();
        sqlSession.close();

        return userByUname;
    }


}
