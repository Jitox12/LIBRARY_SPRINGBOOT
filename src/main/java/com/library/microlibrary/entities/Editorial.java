package com.library.microlibrary.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "editorial")
@Embeddable
public class Editorial implements Serializable {
    private static final long serialVersionUID = 1645180097063090517L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editorial_id", nullable = false)
    private Integer id;

    @Column(name = "editorial_name", nullable = false, length = 100)
    private String editorialName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEditorialName() {
        return editorialName;
    }

    public void setEditorialName(String editorialName) {
        this.editorialName = editorialName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}