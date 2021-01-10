package com.fyh.mybatis.sqlsession;

import com.fyh.cfg.Configuration;
import com.fyh.mybatis.sqlsession.impl.DefaultSqlSessionFactory;
import com.fyh.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class sqlSessionFactoryBuilder {
    public sqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
