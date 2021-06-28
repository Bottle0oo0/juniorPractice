//test
package com.hust.edu.dao;

import com.hust.edu.entity.Page;
import com.hust.edu.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 数据访问层
 */
@Mapper
public interface UserDao {
    @Insert("insert into tb_user (login_name,username,password,db_source) values " +
            "(#{loginName},#{uname},#{pwd},#{dbSource})")
    public int add(User user);

    @Delete("delete from tb_user where id=#{id}")
    public int del(int id);

    @Select("select id,login_name,username,db_source from tb_user where id=#{id}")
    @Results(id = "userMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "login_name",property = "loginName"),
            @Result(column = "username",property = "uname"),
            @Result(column = "password",property = "pwd"),
            @Result(column = "db_source",property = "dbSource"),
    })
    public User selectById(int id);

    @Select("select id,login_name,username,db_source from tb_user")
    @ResultMap(value = "userMap")
    public List<User> selectAll();

    @Select("select id,login_name,username,db_source from tb_user" +
            " where login_name = #{loginName} and password=#{pwd}")
    @ResultMap(value = "userMap")
    public User selectByLogNameAndPwd(String loginName,String pwd);

    @Select("<script>" +
            " select id,login_name,username,db_source from tb_user " +
            "<if test=\"key!= null\"> " +
            "<where> " +
            " username LIKE CONCAT('%',#{key},'%') or login_name LIKE CONCAT('%',#{key},'%')" +
            "</where> " +
            "</if>" +
            "</script>")
    @ResultMap(value = "userMap")
    public List<User> selectByPage(Page<User> page);
}















