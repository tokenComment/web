package com.hqz.demo.dao;

import com.hqz.demo.model.UserComment;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDAOComment {
    @Insert({"insert into cmtall(cmid,cmusername,comment,username) values(#{cmid},#{cmusername},#{comment},#{busername})"})
    void insert(UserComment userComment);

    @Delete({"delete from user where id=#{id}"})
    Long delete(@Param("id") Long id);

    @Select({"select * from cmtall"})
    List<UserComment> selectCmId();
}