package com.library.microlibrary.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "author")
public class Author implements Serializable {
    private static final long serialVersionUID = -7259437152583654745L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", nullable = false)
    private Integer id;

    @Column(name = "author_name", nullable = false, length = 50)
    private String authorName;

    @Column(name = "author_img", nullable = false)
    private byte[] authorImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public byte[] getAuthorImg() {
        return authorImg;
    }

    public void setAuthorImg(byte[] authorImg) {
        this.authorImg = authorImg;
    }

}