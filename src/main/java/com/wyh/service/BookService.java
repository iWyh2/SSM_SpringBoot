package com.wyh.service;

import com.wyh.domain.Book;

import java.util.List;

public interface BookService {
    boolean addNew(Book book);
    boolean deleteById(Integer id);
    boolean update(Book book);
    Book selectById(Integer id);
    List<Book> selectAll();
}
