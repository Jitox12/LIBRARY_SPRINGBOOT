package com.library.microlibrary.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_author")
public class BookAuthorEntity implements Serializable {
    private static final long serialVersionUID = -6961761447662376254L;

    @Column(name = "book_id")
    private Integer bookId;
    @Id
    @Column(name="author_id")
    private Integer authorId;
}