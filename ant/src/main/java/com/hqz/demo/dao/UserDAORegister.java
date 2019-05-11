package com.hqz.demo.dao;

import com.hqz.demo.model.UserRegister;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDAORegister {
    @Insert({"insert into registry(nickName,sex,phoneNumber,email,passwd,age,dream) values(#{nickName},#{sex},#{phoneNumber},#{email},#{passwd},#{age},#{dream})"})
    @Options(
            useGeneratedKeys = true,
            keyColumn = "ID",
            keyProperty = "id"
    )
    void insert2(UserRegister userRegister);

    @Update({"update user set usrname=#{usrname} where id=#{id}"})
    Long update(UserRegister userRegister);

    @Delete({"delete from user where id=#{id}"})
    Long delete(@Param("id") Long id);

    @Select({"select * from registry where nickName= #{userName} and passwd=#{password} "})
    List<UserRegister> selectAll(@Param("userName") String userName, @Param("password") String password);

    @Select({"select * from registry where nickName= #{userName}"})
    List<UserRegister> selectony(@Param("userName") String userName);

    @Select({"select * from registry where ID= #{userId}"})
    UserRegister getUserInfo(@Param("userId") Integer userId);

    @Select({"select * from registry where nickName= #{username}"})
    List<UserRegister> userIf(@Param("username") String username);

    @Select({"select * from registry where id=#{id}"})
    List<UserRegister> selectById(@Param("id") Long id);
}