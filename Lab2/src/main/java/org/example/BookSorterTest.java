package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class BookSorterTest {
    private List<Book> books;
    private BookSorter sorter;

    @Before
    public void setUp() {
        books = new ArrayList<>();
        books.add(new Book("Title1", "Author1", 2000, 20.0));
        books.add(new Book("Effective Java", "Joshua Bloch", 2008, 30.0));

        sorter = new BookSorter();
    }

    @Test
    public void testSortByTitleWithEmptyList() {
        books.clear();
        List<Book> sortedBooks = sorter.sortByTitle(books);
        assertTrue(sortedBooks.isEmpty());
    }

    @Test
    public void testSortByTitleWithSingleBook() {
        List<Book> sortedBooks = sorter.sortByTitle(books);
        assertEquals("Effective Java", sortedBooks.get(0).getTitle());
    }

    @Test
    public void testSortByTitleWithMultipleBooks() {
        books.add(new Book("Java Concurrency in Practice", "Brian Goetz", 2006, 40.0));
        books.add(new Book("Design Patterns", "Erich Gamma", 1994, 45.0));
        books.add(new Book("Refactoring", "Martin Fowler", 1999, 50.0));
        books.add(new Book("Head First Design Patterns", "Eric Freeman", 2004, 35.0));

        List<Book> sortedBooks = sorter.sortByTitle(books);
        assertEquals("Design Patterns", sortedBooks.get(0).getTitle());
        assertEquals("Effective Java", sortedBooks.get(1).getTitle());
        assertEquals("Head First Design Patterns", sortedBooks.get(2).getTitle());
        assertEquals("Java Concurrency in Practice", sortedBooks.get(3).getTitle());
        assertEquals("Refactoring", sortedBooks.get(4).getTitle());
    }

    @Test
    public void testSortByAuthorWithMultipleBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Effective Java", "Joshua Bloch", 2008, 30.0));
        books.add(new Book("Java Concurrency in Practice", "Brian Goetz", 2006, 40.0));
        books.add(new Book("Design Patterns", "Erich Gamma", 1994, 45.0));
        books.add(new Book("Refactoring", "Martin Fowler", 1999, 50.0));
        books.add(new Book("Head First Design Patterns", "Eric Freeman", 2004, 35.0));

        List<Book> sortedBooks = sorter.sortByAuthor(books);
        assertEquals("Brian Goetz", sortedBooks.get(0).getAuthor());
        assertEquals("Eric Freeman", sortedBooks.get(1).getAuthor());
        assertEquals("Erich Gamma", sortedBooks.get(2).getAuthor());
        assertEquals("Joshua Bloch", sortedBooks.get(3).getAuthor());
        assertEquals("Martin Fowler", sortedBooks.get(4).getAuthor());
    }





    @Test
    public void testSortByYearWithMultipleBooks() {
        books = new ArrayList<>();
        books.add(new Book("Java Concurrency in Practice", "Brian Goetz", 2006, 40.0));
        books.add(new Book("Effective Java", "Joshua Bloch", 2008, 30.0));
        books.add(new Book("Design Patterns", "Erich Gamma", 1994, 45.0));
        books.add(new Book("Refactoring", "Martin Fowler", 1999, 50.0));
        books.add(new Book("Head First Design Patterns", "Eric Freeman", 2004, 35.0));

        List<Book> sortedBooks = sorter.sortByYear(books);
        assertEquals(1994, sortedBooks.get(0).getYear());
        assertEquals(1999, sortedBooks.get(1).getYear());
        assertEquals(2004, sortedBooks.get(2).getYear());
        assertEquals(2006, sortedBooks.get(3).getYear());
        assertEquals(2008, sortedBooks.get(4).getYear());
    }

    @Test
    public void testSortByPriceWithMultipleBooks() {
        books = new ArrayList<>();
        books.add(new Book("Java Concurrency in Practice", "Brian Goetz", 2006, 40.0));
        books.add(new Book("Effective Java", "Joshua Bloch", 2008, 30.0));
        books.add(new Book("Design Patterns", "Erich Gamma", 1994, 45.0));
        books.add(new Book("Refactoring", "Martin Fowler", 1999, 50.0));
        books.add(new Book("Head First Design Patterns", "Eric Freeman", 2004, 35.0));

        List<Book> sortedBooks = sorter.sortByPrice(books);
        assertEquals(30.0, sortedBooks.get(0).getPrice(), 0.01);
        assertEquals(35.0, sortedBooks.get(1).getPrice(), 0.01);
        assertEquals(40.0, sortedBooks.get(2).getPrice(), 0.01);
        assertEquals(45.0, sortedBooks.get(3).getPrice(), 0.01);
        assertEquals(50.0, sortedBooks.get(4).getPrice(), 0.01);
    }
}
