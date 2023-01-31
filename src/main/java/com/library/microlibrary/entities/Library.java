package com.library.microlibrary.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "library")
@Embeddable
public class Library implements Serializable {
    private static final long serialVersionUID = 1645180097063090517L;

    @Id
    @Column(name = "library_id", nullable = false)
    private Integer id;

    @Column(name = "library_name", nullable = false, length = 100)
    private String libraryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

}