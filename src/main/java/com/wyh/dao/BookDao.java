package com.wyh.dao;

import com.wyh.domain.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookDao {
    @Insert("insert into tb_books (id, name, type, description) VALUES (null,#{name},#{type},#{description})")
    int addNew(Book book);

    @Delete("delete from tb_books where id = #{id}")
    int deleteById(Integer id);

    @Update("update tb_books set name = #{name}, type = #{type}, description = #{description} where id = #{id}")
    int update(Book book);

    @Select("select * from tb_books where id = #{id}")
    Book selectById(Integer id);

    @Select("select * from tb_books")
    List<Book> selectAll();
}
