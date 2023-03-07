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
@Table(name = "author")
public class AuthorEntity implements Serializable {
    private static final long serialVersionUID = -7259437152583654745L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", nullable = false)
    private Integer authorId;

    @Column(name = "author_name", nullable = false, length = 50)
    private String authorName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private CityEntity city;

}