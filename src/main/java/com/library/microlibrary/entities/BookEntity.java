package com.library.microlibrary.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "book")
public class BookEntity implements Serializable {
    private static final long serialVersionUID = -6961761447662376254L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer bookId;

    @Column(name = "book_name", nullable = false, length = 100)
    private String bookName;

    @Column(name = "book_description", nullable = false)
    private String bookDescription;

    @Column(name = "book_isbn", nullable = false, length = 50)
    private String bookIsbn;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "author_id")})
    private List<AuthorEntity> authors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_library",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "library_id", referencedColumnName = "library_id")})
    private List<LibraryEntity> libraries;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_editorial",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "editorial_id", referencedColumnName = "editorial_id")})
    private List<EditorialEntity> editorials;
}