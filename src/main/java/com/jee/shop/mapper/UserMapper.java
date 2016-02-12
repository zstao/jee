package com.jee.shop.mapper;

import com.jee.shop.model.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ZSt on 2016/2/12.
 */
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    public User load(int id);
}
