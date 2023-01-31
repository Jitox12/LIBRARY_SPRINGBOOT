package com.library.microlibrary.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book")
@Embeddable
public class Book implements Serializable {
    private static final long serialVersionUID = -6961761447662376254L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer id;

    @Column(name = "book_name", nullable = false, length = 100)
    private String bookName;

    @Column(name = "book_description", nullable = false)
    private byte[] bookDescription;

    @Column(name = "book_isbn", nullable = false, length = 50)
    private String bookIsbn;

    @Column(name = "book_stock", nullable = false)
    private Integer bookStock;

    @Column(name = "book_img", nullable = false)
    private byte[] bookImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public byte[] getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(byte[] bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public Integer getBookStock() {
        return bookStock;
    }

    public void setBookStock(Integer bookStock) {
        this.bookStock = bookStock;
    }

    public byte[] getBookImg() {
        return bookImg;
    }

    public void setBookImg(byte[] bookImg) {
        this.bookImg = bookImg;
    }

}