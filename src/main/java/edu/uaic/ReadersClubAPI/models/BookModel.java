package edu.uaic.ReadersClubAPI.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class BookModel {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    private String title;
    private String author;
    private String coverUrl;

    public BookModel(String title, String author, String coverUrl) {
        this.title = title;
        this.author = author;
        this.coverUrl = coverUrl;
    }

    public BookModel() {}
}
