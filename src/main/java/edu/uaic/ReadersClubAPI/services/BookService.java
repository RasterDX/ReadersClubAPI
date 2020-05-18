package edu.uaic.ReadersClubAPI.services;

import edu.uaic.ReadersClubAPI.models.BookModel;
import edu.uaic.ReadersClubAPI.models.TextModel;
import edu.uaic.ReadersClubAPI.repository.BookRepository;
import edu.uaic.ReadersClubAPI.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LocationRepository locationRepository;

    public BookModel getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow();
    }

    public BookModel addBook(BookModel bookModel) {
        for (var loc : bookModel.getLocations()) {
            loc.setBook(bookModel);
        }
        return bookRepository.save(bookModel);
    }
}
