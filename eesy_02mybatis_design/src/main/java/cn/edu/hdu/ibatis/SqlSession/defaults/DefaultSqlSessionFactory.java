package cn.edu.hdu.ibatis.SqlSession.defaults;

import cn.edu.hdu.ibatis.SqlSession.SqlSession;
import cn.edu.hdu.ibatis.SqlSession.SqlSessionFactory;

import cn.edu.hdu.ibatis.cfg.Configuration;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
