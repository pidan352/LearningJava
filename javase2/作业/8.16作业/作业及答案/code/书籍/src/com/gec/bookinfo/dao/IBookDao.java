package com.gec.bookinfo.dao;

import com.gec.bookinfo.entity.Book;

import java.util.List;

public interface IBookDao {

    public int save(Book book);

    public List<Book> list();

}
