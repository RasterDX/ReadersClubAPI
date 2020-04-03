package edu.uaic.ReadersClubAPI.repository;

import edu.uaic.ReadersClubAPI.models.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation, Long> {

    @Query("SELECT i FROM Invitation i WHERE i.receiver.email = :email")
    public List<Invitation> getInvitationByEmail(@Param("email") String email);

}
