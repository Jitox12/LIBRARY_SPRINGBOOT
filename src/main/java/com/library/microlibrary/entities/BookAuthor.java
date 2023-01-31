package com.library.microlibrary.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book_author")
public class BookAuthor implements Serializable {
    private static final long serialVersionUID = -6961761447662376254L;

    @EmbeddedId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @EmbeddedId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}