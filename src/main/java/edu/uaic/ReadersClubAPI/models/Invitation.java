package edu.uaic.ReadersClubAPI.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="invitations")
public class Invitation {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    @OneToOne
    private UserModel sender;
    @OneToOne
    private UserModel receiver;
    private Date dateSent;
    private Date scheduledDate;
    @OneToOne
    private Location location;
    private String message;
    @OneToOne
    @JoinColumn(name="book")
    private BookModel book;

    private Boolean hasBeenAccepted;

    public Invitation() {}

    public UserModel getSender() {
        return sender;
    }

    public void setSender(UserModel sender) {
        this.sender = sender;
    }

    public UserModel getReceiver() {
        return receiver;
    }

    public void setReceiver(UserModel receiver) {
        this.receiver = receiver;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BookModel getBook() {
        return book;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }

    public Boolean getHasBeenAccepted() {
        return hasBeenAccepted;
    }

    public void setHasBeenAccepted(Boolean hasBeenAccepted) {
        this.hasBeenAccepted = hasBeenAccepted;
    }
}
