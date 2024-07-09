import java.util.ArrayList;

class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void borrowBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("You have borrowed: " + book.getTitle());
                    return;
                } else {
                    System.out.println("Sorry, the book is already borrowed.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("You have returned: " + book.getTitle());
                    return;
                } else {
                    System.out.println("This book was not borrowed.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }
}
