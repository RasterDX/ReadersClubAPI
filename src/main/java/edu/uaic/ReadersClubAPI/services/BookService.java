package edu.uaic.ReadersClubAPI.services;

import edu.uaic.ReadersClubAPI.models.BookModel;
import edu.uaic.ReadersClubAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public BookModel getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow();
    }
}
