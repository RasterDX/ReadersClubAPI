package edu.uaic.ReadersClubAPI.repository;

import edu.uaic.ReadersClubAPI.models.Authorization;
import edu.uaic.ReadersClubAPI.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

    @Query("SELECT p FROM Authorization p where p.user.email = :email")
    public Optional<Authorization> getAuthForEmail(@Param("email") String email);
}
