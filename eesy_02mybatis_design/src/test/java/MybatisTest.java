import cn.edu.hdu.dao.IUserDao;
import cn.edu.hdu.domain.User;
import cn.edu.hdu.ibatis.SqlSession.SqlSession;
import cn.edu.hdu.ibatis.SqlSession.SqlSessionFactory;
import cn.edu.hdu.ibatis.SqlSession.SqlSessionFactoryBuilder;
import cn.edu.hdu.ibatis.io.Resources;


import java.io.InputStream;
import java.util.List;


public class MybatisTest {
    public static void main(String[] args) throws Exception{
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession session = ssf.openSession();
        //创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //执行sql语句
        List<User> userLsit = userDao.findAll();
        for (User user:userLsit) {
            System.out.println(user);
        }

        //关闭流
        in.close();
        session.close();
    }
}
