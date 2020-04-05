package edu.uaic.ReadersClubAPI.controllers;

import edu.uaic.ReadersClubAPI.models.BookModel;
import edu.uaic.ReadersClubAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("books/mock")
    public void mockBooks() {
        List<BookModel> mockData = new ArrayList<>();
        mockData.add(new BookModel("Amintiri din copilarie", "Ion creanga", "https://www.libris.ro/img/pozeprod/59/1002/96/628336.jpg"));
        mockData.add(new BookModel("Morometii", "Marin Preda", "https://upload.wikimedia.org/wikipedia/ro/7/7c/Morometii_afis.jpg"));
        mockData.add(new BookModel("Ion", "Liviu Rebreanu", "https://www.libris.ro/img/pozeprod/59/1002/C0/1163390.jpg"));
        mockData.add(new BookModel("Maitreyi", "Mircea Eliade", "https://upload.wikimedia.org/wikipedia/ro/thumb/4/45/Maitreyi.jpg/200px-Maitreyi.jpg"));
        mockData.add(new BookModel("La medeleni", "Ionel Teodoreanu", "https://www.anticariat-logos.ro/wp-content/uploads/2016/07/La-Medeleni-Ionel-Teodoreanu-Editura-Eminescu-1984-vol-1.jpg"));
        mockData.add(new BookModel("Amintiri din copilarie", "Ion creanga", "https://www.libris.ro/img/pozeprod/59/1002/96/628336.jpg"));
        mockData.add(new BookModel("Amintiri din copilarie", "Ion creanga", "https://www.libris.ro/img/pozeprod/59/1002/96/628336.jpg"));
        bookRepository.saveAll(mockData);
    }

    @PostMapping("books/add")
    public BookModel addBook(@RequestBody BookModel book) {
        return this.bookRepository.save(book);
    }

    @GetMapping("books/featured")
    public List<BookModel> getFeaturedBooks() {
        return bookRepository.findFirstById(5);
    }


    @GetMapping("books/all")
    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

}
