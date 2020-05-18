package edu.uaic.ReadersClubAPI.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name="texts")

public class TextModel {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Column(columnDefinition="TEXT")
    private String text;

    @OneToOne
    private BookModel book;

    public TextModel() {

    }

    public TextModel(String text, BookModel book) {
        this.text = text;
        this.book = book;
    }

    public TextModel(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }
}
