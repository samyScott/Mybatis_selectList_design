package cn.edu.hdu.ibatis.io;

import java.io.InputStream;

/**
 * 读取xml主配置文件
 */
public class Resources {
    public static InputStream getResourceAsStream(String config){
        return  Resources.class.getClassLoader().getResourceAsStream(config);
    }
}
