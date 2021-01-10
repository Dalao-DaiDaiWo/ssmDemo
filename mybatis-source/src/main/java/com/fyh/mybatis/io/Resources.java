package com.fyh.mybatis.io;

import java.io.InputStream;

public class Resources {
    public static InputStream getResourceAsStream(String filePath){
        //1.获取当前类的字节码 2.获取当前类加载器 3.使用类加载器读取文件
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
