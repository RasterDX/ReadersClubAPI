package edu.uaic.ReadersClubAPI.models;

import java.util.Date;

public class InviteRequest {

    public String authToken;
    public Long senderId;
    public Long receiverId;
    public Long locationId;
    public Date date;
    public Long bookId;
    public String message;

    public InviteRequest(String authToken, Long senderId, Long receiverId, Long locationId, Date date, Long bookId, String message) {
        this.authToken = authToken;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.locationId = locationId;
        this.date = date;
        this.bookId = bookId;
        this.message = message;
    }
}
