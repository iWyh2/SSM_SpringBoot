package com.wyh.controller;

import com.wyh.controller.result.Result;
import com.wyh.controller.code.Code;
import com.wyh.domain.Book;
import com.wyh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Result addNew(@RequestBody Book book) {
        boolean save = bookService.addNew(book);
        return new Result(save? Code.SAVE_OK:Code.SAVE_ERR,save);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean delete = bookService.deleteById(id);
        return new Result(delete?Code.DELETE_OK:Code.DELETE_ERR,delete);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean update = bookService.update(book);
        return new Result(update?Code.UPDATE_OK:Code.UPDATE_ERR,update);
    }

    @GetMapping
    public Result selectAll() {
        List<Book> bookList = bookService.selectAll();
        return new Result(bookList!=null?Code.SELECT_OK:Code.SELECT_ERR,bookList,bookList!=null?"":"查询失败，暂无数据");
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        Book book = bookService.selectById(id);
        return new Result(book!=null?Code.SELECT_OK:Code.SELECT_ERR,book,book!=null?"":"查询失败，暂无此条数据");
    }
}
