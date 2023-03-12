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
@Table(name = "book_editorial")
public class BookEditorialEntity implements Serializable {
    private static final long serialVersionUID = -6961761447662376254L;

    @Id
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "editorial_id")
    private Integer editorialId;

}