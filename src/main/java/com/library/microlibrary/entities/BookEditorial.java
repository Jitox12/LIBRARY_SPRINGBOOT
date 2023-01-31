package com.library.microlibrary.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book_editorial")
public class BookEditorial implements Serializable {
    private static final long serialVersionUID = -6961761447662376254L;

    @EmbeddedId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @EmbeddedId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "editorial_id", nullable = false)
    private Editorial editorial;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

}