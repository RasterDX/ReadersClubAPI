package edu.uaic.ReadersClubAPI.repository;

import edu.uaic.ReadersClubAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
