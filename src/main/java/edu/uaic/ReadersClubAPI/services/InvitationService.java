package edu.uaic.ReadersClubAPI.services;

import edu.uaic.ReadersClubAPI.models.Invitation;
import edu.uaic.ReadersClubAPI.models.UserModel;
import edu.uaic.ReadersClubAPI.repository.InvitationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class InvitationService {

    @Autowired
    InvitationRepository invitationRepository;

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    LocationService locationService;

    @Scheduled(cron = "@hourly")
    public final void pruneInvitations() {
        Date dateNow = java.sql.Date.valueOf(LocalDate.now());
        invitationRepository.findAll()
                .forEach(i -> {
                    if (dateNow.toInstant().isAfter(
                            i.getDateSent().toInstant().plus(24, ChronoUnit.HOURS)
                    )) {
                        invitationRepository.delete(i);
                    }
                });
    }

    public void createInvitation(UserModel sender, UserModel receiver, Long locationId, Long bookId, Date date, String message) {
        var book = bookService.getBookById(bookId);
        var location = locationService.getLocationById(locationId);
        var invitation = new Invitation();
        invitation.setSender(sender);
        invitation.setReceiver(receiver);
        invitation.setScheduledDate(date);
        invitation.setDateSent(java.sql.Date.valueOf(LocalDateTime.now().toLocalDate()));
        invitation.setMessage(message);
        invitation.setBook(book);
        invitation.setHasBeenAccepted(false);
        invitationRepository.save(invitation);
    }

    public String acceptInvite(Long invitationId) {
        try {
            var invitation = invitationRepository.findById(invitationId).orElseThrow();
            invitation.setHasBeenAccepted(true);
            invitationRepository.save(invitation);
            return "Accepted invitation.";
        } catch (Exception e) {
            return "Invitation doesn't exist.";
        }
    }

    public List<Invitation> getRecInvitationsByEmail(String email) {
        return this.invitationRepository.getRecInvitationsByEmail(email);
    }

    public List<Invitation> getSentInvitationsByEmail(String email) {
        return this.invitationRepository.getSentInvitationsByEmail(email);
    }
}
