package cn.edu.hdu.ibatis.SqlSession;

import cn.edu.hdu.ibatis.SqlSession.defaults.DefaultSqlSessionFactory;
import cn.edu.hdu.ibatis.cfg.Configuration;
import cn.edu.hdu.ibatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * SqlSession构建者
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in){
        //将字节流转化为配置文件对象
        Configuration cfg = XMLConfigBuilder.loadConfiguration(in);
        //将配置文件对象交给工厂生产
        return new DefaultSqlSessionFactory(cfg);
    }
}
