package cn.edu.hdu.ibatis.SqlSession.defaults;

import cn.edu.hdu.ibatis.SqlSession.SqlSession;
import cn.edu.hdu.ibatis.cfg.Configuration;
import cn.edu.hdu.ibatis.SqlSession.proxy.MapperProxy;
import cn.edu.hdu.ibatis.utils.DataSourceUtils;

import java.lang.reflect.Proxy;
import java.sql.Connection;

public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection conn;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        conn = DataSourceUtils.getConnection(cfg);
    }

    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),conn));

    }

    public void close() {
        if(conn != null){
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
