package com.gec.bookinfo.app;

import com.gec.bookinfo.dao.IBookDao;
import com.gec.bookinfo.dao.impl.BookDaoImpl;
import com.gec.bookinfo.entity.Book;

import java.util.List;
import java.util.Scanner;

public class MainTest {

    private static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {

        new MainTest().toSysMenu();


    }

    public void toSysMenu(){

        System.out.println("1、录入数据");
        System.out.println("2、查看数据");

        String inputNum=sc.nextLine();

        switch (inputNum){
            case "1":
                addBook();
                toSysMenu();
                break;
            case "2":
                list();
                break;
        }
    }

    public void addBook(){

        IBookDao bookDao=new BookDaoImpl();

        System.out.println("请输入标题：");
        String title = sc.nextLine();
        System.out.println("请输入作者");
        String author = sc.nextLine();
        System.out.println("请输入价格");
        Double price=null;
        while (true){
            String strPrice = sc.nextLine();
            try {
                price = Double.parseDouble(strPrice);
                break;
            }catch (NumberFormatException e){
                System.out.println("输入格式有误！");
            }
        }

        Book book=new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(price);

        int flag = bookDao.save(book);

        if(flag>0){
            System.out.println("添加书籍成功");
        }else{
            System.out.println("添加书籍失败");
        }


    }

    public void list(){
        IBookDao bookDao=new BookDaoImpl();
        List<Book> list = bookDao.list();

        for (Book book : list) {
            System.out.println("书籍id="+book.getId()+"  书籍标题="+book.getTitle()+"  书籍作者="+book.getAuthor()+"  书籍价格="+book.getPrice());
        }

    }
}
