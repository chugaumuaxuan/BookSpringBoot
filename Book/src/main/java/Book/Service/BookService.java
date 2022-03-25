package Book.Service;

import Book.Entity.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    public List<Book> listBook = new ArrayList<>(Arrays.asList(
            new Book(1, "Cuoc san cuu hoang", 200000),
            new Book(2, "Rung Nauy", 100000),
            new Book(3, "Lang nghe gio hat", 300000),
            new Book(4, "1Q84", 250000),
            new Book(5, "Xu so tan bao dieu ki va chon tan cung the gioi", 400000)
    ));

    public List<Book> getAllBook(){
        listBook.forEach(n -> n.toString());
        return listBook;
    }

    public List<Book> getBookById(long id){
        List<Book> list2 = listBook.stream().filter(book -> book.getBookId() == id).collect(Collectors.toList());
        return list2;
    }

    public List<Book> addBook(Book b) {
            long newId = listBook.get(listBook.size() -1).getBookId();
            newId++;
             if ( b.getBookName() != null)
                    b.setBookId(newId);
                    listBook.add(b);
        return listBook;
    }

    public List<Book> updateBook(Book b){
        return listBook;
    }

    public List<Book> deleteBook(long id){
        listBook.removeIf(t -> id == t.getBookId());
        return listBook;
    }
}
