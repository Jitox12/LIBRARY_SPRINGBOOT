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
@Table(name = "book_library")
public class BookLibraryEntity implements Serializable {
    private static final long serialVersionUID = -6961761447662376254L;
    @Id
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "library_id")
    private Integer libraryId;
}