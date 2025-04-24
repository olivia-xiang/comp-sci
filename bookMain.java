import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bookMain {
    public static void main (String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(300, 10, 250));
        books.add(new Book(400, 12, 300));
        books.add(new Book(500, 15, 350));
      
        books.add(new Book(900, 35, 550));
        books.add(new Book(1000, 40, 600));     
        books.add(new Book(1100, 45, 650));
        books.add(new Book(1200, 50, 700));
        books.add(new Book(1300, 55, 750));
        books.add(new Book(1400, 60, 800)); 
        books.add(new Book(600, 20, 400));          
        books.add(new Book(700, 25, 450));
        books.add(new Book(800, 30, 500));

        Collections.sort(books);
        for (Book book : books) {
            System.out.println("Pages: " + book.getPages() + ", Chapters: " + book.getChapters() + ", Words per Page: " + book.getWordsPerPage());
        }
    }
}
