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
@Table(name = "country")
public class CountryEntity implements Serializable {
    private static final long serialVersionUID = 1645180097063090517L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Integer countryId;

    @Column(name = "country_name", nullable = false, length = 100)
    private String countryName;

    @OneToMany(mappedBy ="country")
    private List<CityEntity> cities;

}