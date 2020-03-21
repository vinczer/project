package com.bookshop.admin.api;

import com.bookshop.admin.domain.Author;
import com.bookshop.admin.exception.RecordNotFoundException;
import com.bookshop.admin.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ModelAndView getAllAuthor(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return new ModelAndView("showAuthors");
    }

    @PostMapping("/add")
    public String createOrUpdateAuthor(Author author) {
        authorService.createOrUpdateAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id) throws RecordNotFoundException {
        authorService.deleteAuthorById(id);
        return "redirect:/authors";
    }
}
