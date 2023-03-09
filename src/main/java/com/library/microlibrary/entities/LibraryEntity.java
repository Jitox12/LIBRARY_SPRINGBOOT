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
@Table(name = "library")
@Embeddable
public class LibraryEntity implements Serializable {
    private static final long serialVersionUID = 1645180097063090517L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library_id", nullable = false)
    private Integer libraryId;

    @Column(name = "library_name", nullable = false, length = 100)
    private String libraryName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private CityEntity city;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_library",
            joinColumns = {@JoinColumn(name = "library_id", referencedColumnName = "library_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "book_id")})
    private List<AuthorEntity> authors;
}