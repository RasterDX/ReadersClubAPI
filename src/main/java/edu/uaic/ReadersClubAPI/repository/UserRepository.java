package edu.uaic.ReadersClubAPI.repository;

import edu.uaic.ReadersClubAPI.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("SELECT u FROM  UserModel u WHERE u.email = :email")
    public UserModel findUserByEmail(@Param("email") String email);


}
