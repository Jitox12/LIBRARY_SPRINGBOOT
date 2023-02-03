package com.library.microlibrary.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
@Embeddable
public class BookEntity implements Serializable {
    private static final long serialVersionUID = -6961761447662376254L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer bookId;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "author_id")})
    private List<AuthorEntity> authors;
}