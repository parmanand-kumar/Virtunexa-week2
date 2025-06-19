package in.lilac.libraryManagement;

import java.util.*;

class Book {
    String title;
    boolean isBorrowed;

    Book(String title) {
        this.title = title;
        this.isBorrowed = false;
    }
}

public class libraryManagement {
    static List<Book> library = new ArrayList<>();
    static List<Book> borrowedBooks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Available Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Borrowed Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewAvailableBooks();
                case 3 -> borrowBook();
                case 4 -> returnBook();
                case 5 -> viewBorrowedBooks();
                case 6 -> System.out.println("Thank you for using the Library System!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    static void addBook() {
        System.out.print("Enter book title to add: ");
        String title = scanner.nextLine();
        library.add(new Book(title));
        System.out.println("Book \"" + title + "\" added to the library.");
    }

    static void viewAvailableBooks() {
        System.out.println("\nAvailable Books:");
        boolean found = false;
        for (Book book : library) {
            if (!book.isBorrowed) {
                System.out.println("- " + book.title);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books are currently available.");
        }
    }

    static void borrowBook() {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine();
        for (Book book : library) {
            if (book.title.equalsIgnoreCase(title) && !book.isBorrowed) {
                book.isBorrowed = true;
                borrowedBooks.add(book);
                System.out.println("You have borrowed \"" + book.title + "\".");
                return;
            }
        }
        System.out.println("Book not available or already borrowed.");
    }

    static void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine();
        for (Book book : borrowedBooks) {
            if (book.title.equalsIgnoreCase(title)) {
                book.isBorrowed = false;
                borrowedBooks.remove(book);
                System.out.println("You have returned \"" + book.title + "\".");
                return;
            }
        }
        System.out.println("Book not found in your borrowed list.");
    }

    static void viewBorrowedBooks() {
        System.out.println("\nBorrowed Books:");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books currently borrowed.");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println("- " + book.title);
            }
        }
    }
}