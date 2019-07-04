package cn.edu.hdu.ibatis.SqlSession.proxy;

import cn.edu.hdu.ibatis.cfg.Configuration;
import cn.edu.hdu.ibatis.cfg.Mapper;
import cn.edu.hdu.ibatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String key = className + "." + methodName;

        Mapper mapper = mappers.get(key);

        if (mapper == null){
            throw new IllegalArgumentException("传入的参数有误");
        }

        return new Executor().selectList(mapper,conn);
    }
}
