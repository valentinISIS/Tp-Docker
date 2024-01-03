package com.isis.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class Api {

    @Value("${app.title}")
    private String title;

    List<Book> liste = List.of(new Book("Candide", "Voltaire", "is123"),
            new Book("Les Misérables", "Victor Hugo", "is741"),
            new Book("Au bonheur des dames", "Zola", "is498"),
            new Book("La condition humaine", "Balzac", "is987"));

    @GetMapping("/title")
    public String getTitle() {
        return title;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return liste;
    }

    @GetMapping("/book/{isbn}")
    public Book getBookByISBN(@PathVariable String isbn) {
        return liste.stream().filter(book -> book.isbn.equals(isbn)).findAny().orElse(new Book("Aucun livre avec cet isbn", "", ""));
    }

}
