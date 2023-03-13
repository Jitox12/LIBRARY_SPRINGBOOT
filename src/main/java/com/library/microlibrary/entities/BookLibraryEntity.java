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
@IdClass(BookLibraryEntity.class)
@Table(name = "book_library")
public class BookLibraryEntity implements Serializable {
    private static final long serialVersionUID = -6961761447662376254L;
    @Id
    @Column(name = "book_id")
    private Integer bookId;
    @Id
    @Column(name = "library_id")
    private Integer libraryId;
}