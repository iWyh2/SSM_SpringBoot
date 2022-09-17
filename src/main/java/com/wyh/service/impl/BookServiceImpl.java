package com.wyh.service.impl;

import com.wyh.controller.code.Code;
import com.wyh.controller.exception.BusinessException;
import com.wyh.controller.exception.SystemException;
import com.wyh.dao.BookDao;

import com.wyh.domain.Book;
import com.wyh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    @Override
    public Book selectById(Integer id) {
        //模拟出现异常
        if (id < 0) {
            throw new BusinessException(Code.BUSINESS_ERR,"操作错误");
        }
        /*
将可能出现的异常进行包装，转换为自定义异常
        try{
            int i = 1/0;
        }catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR,"服务器异常",e);
        }
*/
        return bookDao.selectById(id);
    }

    @Override
    public boolean addNew(Book book) {
        return bookDao.addNew(book) > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }
}
