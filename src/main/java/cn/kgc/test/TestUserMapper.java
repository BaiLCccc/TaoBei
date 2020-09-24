package cn.kgc.test;

import cn.kgc.dao.UserMapper;
import cn.kgc.entity.Page;
import cn.kgc.entity.User;
import cn.kgc.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * Created by helloworld on 2020/9/14.
 */
public class TestUserMapper {


    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        for (int i = 6;i<30;i++){
            user.setUname("ceshi"+i);
            user.setUpassword("123");
            mapper.saveUser(user);
            sqlSession.commit();
        }



        /*Page<User> page = new Page<>();
        String sinlvalue = mapper.getSinlvalue();
        int tc =0;
        if (sinlvalue!=null){
            tc = Integer.parseInt(sinlvalue);
        }
        page.setTotalCount(tc);
        page.setPageSize(5);
        page.setPageNum(1);
        System.out.println(mapper.getSinlvalue());
        System.out.println(mapper.getUserByPage(page));*/


        sqlSession.close();
    }
}
