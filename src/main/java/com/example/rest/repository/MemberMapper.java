package com.example.rest.repository;

import com.example.rest.repository.entity.MemberData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Select("SELECT * from members")
    List<MemberData> findAll();

    @Select("SELECT * FROM members where id = #{id}")
    MemberData findById(@Param("id") Integer id);

    @Insert("INSERT INTO members (name, age) VALUES (#{name}, #{age})")
    void create(@Param("name") String name, @Param("age") Integer age);

    @Update("UPDATE  members " +
            "SET id=#{id}," +
            "name =#{name}," +
            "age =#{age} " +
            "WHERE id =#{id}")
    void update(@Param("id") Integer id, @Param("name") String name, @Param("age") Integer age);

    @Delete("DELETE FROM members where id = #{id}")
    void deleteById(@Param("id") Integer id);
}
