package cn.kgc.test;

import cn.kgc.dao.UserMapper;
import cn.kgc.entity.Page;
import cn.kgc.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


/**
 * Created by helloworld on 2020/9/14.
 */
public class TestPersonMapper {

    public static void main(String[] args) {

        String resource = "mybatis-config.xml";
        SqlSession sqlSession = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User person = new User(null,"ceshi0916","111","13914333319",1,1);

            Page<User> userPage = new Page<>();
            userPage.setIndex(0);
            userPage.setPageSize(2);

            List<User> userByPage = mapper.getUserByPage(userPage);
            System.out.println(userByPage);
            //增
            //mapper.saveUser(person);

            //删
            //mapper.delPersonById(2);
            //改
            /*person.setAge(99);
            person.setId(2);
            mapper.updatePerson(person);*/

            sqlSession.commit();
            /*当我们操作增删改的时候，在最后需要提交*/

            //查一个
            /*List<User> all = mapper.getAll();
            for (User user : all) {
                System.out.println(user);
            }*/
            //查所有
            /*List<Person> person1 = mapper.getPerson();


            System.out.println("----------------");
            for (Person p : person1) {
                System.out.println(p);
            }*/





        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();

        }

    }
}
