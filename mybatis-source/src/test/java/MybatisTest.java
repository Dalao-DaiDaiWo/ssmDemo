import com.fyh.Dao.IUserDao;
import com.fyh.mybatis.io.Resources;
import com.fyh.mybatis.sqlsession.sqlSession;
import com.fyh.mybatis.sqlsession.sqlSessionFactory;
import com.fyh.mybatis.sqlsession.sqlSessionFactoryBuilder;
import com.fyh.pojo.User;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws IOException {
        System.out.println("dev分支");
        /*1.读取配置文件*/
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        /*2.创建SqlSessionFactory工厂*/
        sqlSessionFactoryBuilder builder = new sqlSessionFactoryBuilder();
        sqlSessionFactory factory = builder.build(is);
        /*3.使用工厂生产SqlSession对象*/
        sqlSession sqlSession = factory.openSession();
        /*4.使用SqlSession创建Dao接口的代理对象*/
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        /*5.使用代理对象执行方法*/
        List<User> users = userDao.findAll();
        for (User u : users) {
            System.out.println(u);
        }
        /*6.释放资源*/
        sqlSession.close();
        is.close();

    }
}
