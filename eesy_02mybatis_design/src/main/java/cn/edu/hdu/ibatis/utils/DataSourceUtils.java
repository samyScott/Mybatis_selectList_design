package cn.edu.hdu.ibatis.utils;

import cn.edu.hdu.ibatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceUtils {

    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
