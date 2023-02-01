package com.library.microlibrary.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
}