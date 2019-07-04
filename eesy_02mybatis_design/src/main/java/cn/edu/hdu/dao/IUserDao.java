package cn.edu.hdu.dao;

import cn.edu.hdu.domain.User;
import cn.edu.hdu.ibatis.annotations.Select;


import java.util.List;

public interface IUserDao {

    /*
    查询所有操作
     */
    @Select("select * from user")
    List<User> findAll();
}
