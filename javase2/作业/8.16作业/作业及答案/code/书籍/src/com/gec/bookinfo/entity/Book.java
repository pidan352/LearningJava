package com.gec.bookinfo.entity;

/*
CREATE TABLE `books` (
        `id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
        `title` VARCHAR(100) NOT NULL,
        `author` VARCHAR(100) NOT NULL,
        `price` DOUBLE(11,2) NOT NULL
        ) ;
*/

public class Book {

    private Integer id;
    private String title;
    private String author;
    private Double price;

    public Book() {
    }

    public Book(Integer id, String title, String author, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
