package com.fyh.mybatis.sqlsession.impl;

import com.fyh.cfg.Configuration;
import com.fyh.mybatis.sqlsession.sqlSession;
import com.fyh.mybatis.utils.DataSourceUtil;
import com.fyh.proxy.MapperProxy;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlSession implements sqlSession {
    private Configuration cfg;
    private Connection connection;
    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},
                new MapperProxy(cfg.getMappers(),connection));
    }

    public void close() {
        if(connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
