package Book.Controller;

import Book.Entity.Book;
import Book.Service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Component
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/books")
    public List<Book> all_book(){
        return bookService.getAllBook();
    }

    @GetMapping(value = {"/FindBook", "/FindBook/{id}"})
        public List<Book> findByID(@PathVariable(name = "id") long id){
        return bookService.getBookById(id);
    }

    @PostMapping("/addBook")
    public String AddBook(@Valid @RequestBody Book b, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "Them khong thanh cong";
        }else {
            bookService.addBook(b);
            return "Them thanh cong";
        }
    }

    @PostMapping("/UpdateBook/{id}")
    public List<Book> updateBook(@PathVariable(value = "id") long id, @RequestBody Book b){
        for(Book book: bookService.listBook){
            if(book.getBookId() == id){
                book.setBookName(b.getBookName());
                book.setBookPrice(b.getBookPrice());
            }
        }
        return bookService.listBook;
    }

    @RequestMapping("/DeleteBook/{id}")
    public List<Book> deleteBook(@PathVariable(name = "id") long id){
        return bookService.deleteBook(id);
    }
}
