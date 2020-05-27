package edu.uaic.ReadersClubAPI.controllers;

import edu.uaic.ReadersClubAPI.models.BookModel;
import edu.uaic.ReadersClubAPI.repository.BookRepository;
import edu.uaic.ReadersClubAPI.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

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
        return this.bookService.addBook(book);
    }

    @GetMapping("books/featured")
    public List<BookModel> getFeaturedBooks() {
        return bookRepository.findFirstById(5);
    }


    @GetMapping("books/all")
    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("books/text/{id}")
    public String getBookText(@PathVariable(name = "id") Long id) {
        try {
            var book = this.bookRepository.findById(id).orElseThrow();
            StringBuilder locations = new StringBuilder();
            for (var loc : book.getLocations()) {
                locations.append("\"" + loc.getName() + "\", ");
            }
            return "<html><head> <style>body{display: flex; justify-content: center; align-items: center; font-size: 20px;}textarea{width: 300px; height: 800px; border: none; margin: none; resize: none; font-size: 20px; overflow: auto;}@media only screen and (max-width: 1000px){textarea{width: 300px; height: 1400px;}}.hwt-container{display: inline-block; position: relative; overflow: hidden !important;}.hwt-backdrop{position: absolute !important; top: 0 !important; right: -99px !important; bottom: 0 !important; left: 0 !important; padding-right: 99px !important; overflow-x: hidden !important; overflow-y: auto !important;}.hwt-highlights{width: auto !important; height: auto !important; border-color: transparent !important; white-space: pre-wrap !important; word-wrap: break-word !important; color: transparent !important; overflow: hidden !important;}.hwt-input{display: block !important; position: relative !important; margin: 0; padding: 0; border-radius: 0; font: inherit; overflow-x: hidden !important; overflow-y: auto !important;}.hwt-content{background: none transparent !important;}.hwt-content mark{padding: 0 !important; color: inherit;}</style></head></html><body> <textarea id=\"textbox\">" + book.getTextModel().getText() + "</textarea> <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script> <script src=\"https://rawgit.com/lonekorean/highlight-within-textarea/master/jquery.highlight-within-textarea.js\"></script> <script>let locations=[" + locations + "]; $('#textbox').highlightWithinTextarea({highlight: locations}); </script></body></html>";
        } catch (Exception e) {
            return " ";
        }
    }
}
