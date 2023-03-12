package com.library.microlibrary.entities;

import lombok.*;
import org.apache.tomcat.jni.Library;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city")
public class CityEntity implements Serializable {
    private static final long serialVersionUID = 1645180097063090517L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private Integer cityId;

    @Column(name = "city_name", nullable = false, length = 100)
    private String cityName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private CountryEntity country;
    @OneToMany(mappedBy ="city")
    private List<AuthorEntity> authors;
    @OneToMany(mappedBy ="city")
    private List<LibraryEntity> libraries;
    @OneToMany(mappedBy ="city")
    private List<EditorialEntity> editorials;


}