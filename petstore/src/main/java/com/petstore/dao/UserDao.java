package com.petstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petstore.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao extends BaseMapper<User> {
    @Select("select * from user where phone=#{account}")
    public User getUserByAccount(String account);
    @Select("update user set password=#{password} where id=#{userid}")
    void updatePasswordById(Integer userid,String password);

}
