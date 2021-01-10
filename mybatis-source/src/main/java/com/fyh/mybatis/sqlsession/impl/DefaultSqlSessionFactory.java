package com.fyh.mybatis.sqlsession.impl;

import com.fyh.cfg.Configuration;
import com.fyh.mybatis.sqlsession.sqlSession;
import com.fyh.mybatis.sqlsession.sqlSessionFactory;

public class DefaultSqlSessionFactory implements sqlSessionFactory {
    private Configuration cfg;


    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    public sqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
