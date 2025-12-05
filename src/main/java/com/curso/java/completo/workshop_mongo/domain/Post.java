package com.curso.java.completo.workshop_mongo.domain;

import com.curso.java.completo.workshop_mongo.dto.AuthorDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Document
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date date;
    private String title;
    private String content;
    private AuthorDto author;


    public Post() {
    }

    public Post(String id, Date date, String title, String content, AuthorDto author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.author = author;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AuthorDto getAuthor() {
        return author;
    }
    public void setAuthor(AuthorDto author) {
        this.author = author;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;
        return id.equals(post.id);
    }
}
