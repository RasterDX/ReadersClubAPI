package edu.uaic.ReadersClubAPI.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")

public class BookModel {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    private String title;
    private String author;
    private String coverUrl;

    @OneToMany(cascade=CascadeType.ALL)
    List<Location> locations;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private Set<UserModel> readers;

    public BookModel(String title, String author, String coverUrl, List<Location> locations) {
        this.title = title;
        this.author = author;
        this.coverUrl = coverUrl;
        this.locations = locations;
    }

    public BookModel(String title, String author, String coverUrl) {
        this.title = title;
        this.author = author;
        this.coverUrl = coverUrl;
    }

    public BookModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Set<UserModel> getReaders() {
        return readers;
    }

    public void setReaders(Set<UserModel> readers) {
        this.readers = readers;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
