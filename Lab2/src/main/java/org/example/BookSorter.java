package org.example;

import org.example.Book;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookSorter {
    public List<Book> sortByTitle(List<Book> books) {
        Collections.sort(books, Comparator.comparing(Book::getTitle));
        return books;
    }

    public List<Book> sortByAuthor(List<Book> books) {
        Collections.sort(books, Comparator.comparing(Book::getAuthor));
        return books;
    }

    public List<Book> sortByYear(List<Book> books) {
        Collections.sort(books, Comparator.comparingInt(Book::getYear));
        return books;
    }

    public List<Book> sortByPrice(List<Book> books) {
        Collections.sort(books, Comparator.comparingDouble(Book::getPrice));
        return books;
    }
}
