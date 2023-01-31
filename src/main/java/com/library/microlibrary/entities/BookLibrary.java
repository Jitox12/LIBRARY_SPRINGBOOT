package com.library.microlibrary.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book_library")
public class BookLibrary implements Serializable {
    private static final long serialVersionUID = -6961761447662376254L;

    @EmbeddedId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @EmbeddedId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "library_id", nullable = false)
    private Library library;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

}