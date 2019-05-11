package com.hqz.demo.dao;

import com.hqz.demo.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDAO {
    @Insert({"insert into rW(userName,Content) values(#{userName},#{Content})"})
    @Options(
            useGeneratedKeys = true,
            keyColumn = "id",
            keyProperty = "id"
    )
    void insert(User user);

    @Update({"update user set usrname=#{usrname} where id=#{id}"})
    Long update(User user);

    @Delete({"delete from user where id=#{id}"})
    Long delete(@Param("id") Long id);

    @Select({"select * from rW"})
    List<User> selectAll();

    @Select({"select * from user where id=#{id}"})
    User selectById(@Param("id") Long id);
}
