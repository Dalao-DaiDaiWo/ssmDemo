package com.fyh.proxy;

import com.fyh.cfg.Mapper;
import com.fyh.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    /**
     * 用于对方法进行增强的，我们的增强其实就是调用selecList方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    private Map<String, Mapper> mappers;
    private Connection connection;
    public MapperProxy(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法名
        String methodName = method.getName();
        //获取方法所在类的全限定类名
        String className = method.getDeclaringClass().getName();
        //组合key
        String key = className + "." + methodName;
        //获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        //判断是否有mapper
        if(mapper == null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //调用工具类进行查询

        return new Executor().selectList(mapper,connection);
    }
}
