package org.example;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.example.Book;
import org.example.BookSorter;
import org.junit.Before;
import org.junit.Test;

public class BookSorterTest {
    private List<Book> books;
    private BookSorter sorter;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        // Додайте кілька тестових книг для тестування
        books.add(new Book("Title1", "Author1", 2000, 20.0));
        books.add(new Book("Title2", "Author2", 1990, 15.0));
        books.add(new Book("Title3", "Author3", 2010, 25.0));
        sorter = new BookSorter();
    }

    @Test
    public void testSortByTitle() {
        List<Book> sortedBooks = sorter.sortByTitle(books);
        assertEquals("Title1", sortedBooks.get(0).getTitle());
        assertEquals("Title2", sortedBooks.get(1).getTitle());
        assertEquals("Title3", sortedBooks.get(2).getTitle());
    }

    @Test
    public void testSortByAuthor() {
        List<Book> sortedBooks = sorter.sortByAuthor(books);
        assertEquals("Author1", sortedBooks.get(0).getAuthor());
        assertEquals("Author2", sortedBooks.get(1).getAuthor());
        assertEquals("Author3", sortedBooks.get(2).getAuthor());
    }

    @Test
    public void testSortByYear() {
        List<Book> sortedBooks = sorter.sortByYear(books);
        assertEquals(1990, sortedBooks.get(0).getYear());
        assertEquals(2000, sortedBooks.get(1).getYear());
        assertEquals(2010, sortedBooks.get(2).getYear());
    }

    @Test
    public void testSortByPrice() {
        List<Book> sortedBooks = sorter.sortByPrice(books);
        assertEquals(15.0, sortedBooks.get(0).getPrice(), 0.01);
        assertEquals(20.0, sortedBooks.get(1).getPrice(), 0.01);
        assertEquals(25.0, sortedBooks.get(2).getPrice(), 0.01);
    }

    @Test
    public void testEmptyList() {
        List<Book> emptyList = new ArrayList<>();
        List<Book> sortedBooks = sorter.sortByTitle(emptyList);
        assertTrue(sortedBooks.isEmpty());
    }

    @Test
    public void testSingleBook() {
        List<Book> singleBookList = new ArrayList<>();
        singleBookList.add(new Book("Title", "Author", 2000, 20.0));
        List<Book> sortedBooks = sorter.sortByTitle(singleBookList);
        assertEquals("Title", sortedBooks.get(0).getTitle());
    }
}
