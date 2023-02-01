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
@Table(name = "editorial")
@Embeddable
public class EditorialEntity implements Serializable {
    private static final long serialVersionUID = 1645180097063090517L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editorial_id", nullable = false)
    private Integer editorialId;

    @Column(name = "editorial_name", nullable = false, length = 100)
    private String editorialName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private CityEntity city;

}