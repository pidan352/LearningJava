package com.gec.bookinfo.dao.impl;

import com.gec.bookinfo.dao.IBookDao;
import com.gec.bookinfo.entity.Book;
import com.gec.bookinfo.utils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements IBookDao {

    @Override
    public int save(Book book) {

        Connection connection=null;
        Statement statement=null;

        try {
            connection= DbUtils.openConn();

            String insertSql="insert into books(title,author,price) values('"+book.getTitle()+"','"+book.getAuthor()+"',"+book.getPrice()+")";

            statement = connection.createStatement();

            int i = statement.executeUpdate(insertSql);

            return i;

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.closeConn(statement,null,connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    @Override
    public List<Book> list() {

        Connection connection=null;
        Statement statement=null;
        List<Book> bookList=new ArrayList<>();

        try {
            connection= DbUtils.openConn();

            String sql="select * from books";

            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                double price = rs.getDouble("price");

                Book book=new Book(id,title,author,price);
                bookList.add(book);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.closeConn(statement,null,connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return bookList;
    }
}
