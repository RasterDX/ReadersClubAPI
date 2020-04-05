package edu.uaic.ReadersClubAPI.models;

import java.util.Date;

public class InviteRequest {

    public String authToken;
    public String receiverEmail;
    public Long locationId;
    public Date date;
    public Long bookId;
    public String message;

    public InviteRequest(String authToken, String reveiverEmail, Long locationId, Date date, Long bookId, String message) {
        this.authToken = authToken;
        this.receiverEmail = reveiverEmail;
        this.locationId = locationId;
        this.date = date;
        this.bookId = bookId;
        this.message = message;
    }
}
