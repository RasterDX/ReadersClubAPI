package edu.uaic.ReadersClubAPI.repository;

import edu.uaic.ReadersClubAPI.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {

    @Query("SELECT b from BookModel b where b.id <= :id")
    List<BookModel> findFirstById(long id);



}
