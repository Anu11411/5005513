import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(Book book) {
        books.add(book);
    }

    // Linear search to find books by title
    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search to find books by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title) {
        Collections.sort(books, Comparator.comparing(Book::getTitle));
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);

            int comparison = midBook.getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return midBook;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Method to display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        Book book1 = new Book(1, "Making Inida Awesome", "Chetan Bhagat");
        Book book2 = new Book(2, "Revolution 2020", "Chetan Bhagat");
        Book book3 = new Book(3, "I too had a Love Story", "Ravinder Singh");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Displaying all books
        System.out.println("Library books:");
        library.displayBooks();

        // Linear search for a book by title
        String titleToSearch = "Revolution 2020";
        Book foundBook = library.linearSearchByTitle(titleToSearch);
        System.out.println("\nLinear search result for title '" + titleToSearch + "':");
        System.out.println(foundBook != null ? foundBook : "Book not found.");

        // Binary search for a book by title
        titleToSearch = "i too had a love story";
        foundBook = library.binarySearchByTitle(titleToSearch);
        System.out.println("\nBinary search result for title '" + titleToSearch + "':");
        System.out.println(foundBook != null ? foundBook : "Book not found.");
    }
}
