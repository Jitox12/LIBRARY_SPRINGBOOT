package com.library.microlibrary.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BookEditorialEntity.class)
@Entity
@Table(name = "book_editorial")
public class BookEditorialEntity implements Serializable {
    private static final long serialVersionUID = -6961761447662376254L;

    @Id
    @Column(name = "book_id",unique = false)
    private Integer bookId;
    @Id
    @Column(name = "editorial_id", unique = false)
    private Integer editorialId;

}