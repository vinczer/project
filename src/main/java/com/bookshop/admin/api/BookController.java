package com.bookshop.admin.api;

import com.bookshop.admin.domain.Book;
import com.bookshop.admin.exception.RecordNotFoundException;
import com.bookshop.admin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ModelAndView getAllBook(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("books", bookService.getAllBooks());
        return new ModelAndView("showBooks");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) throws RecordNotFoundException {
        Book book = bookService.getBookById(id);

        return new ResponseEntity<>(book, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createOrUpdateBook(Book book) {
        Book bookEntity = bookService.createOrUpdateBook(book);

        return new ResponseEntity<>(bookEntity, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping
    public HttpStatus deleteBookById(@PathVariable("id") Long id) throws RecordNotFoundException {
        bookService.deleteBookById(id);

        return HttpStatus.FORBIDDEN;
    }
}
