package com.curso.java.completo.workshop_mongo.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class CommentDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String text;
    private Date date;
    private AuthorDto author;


    public CommentDto() {}

    public CommentDto(String text, Date date, AuthorDto author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }


    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public AuthorDto getAuthor() {
        return author;
    }
}
