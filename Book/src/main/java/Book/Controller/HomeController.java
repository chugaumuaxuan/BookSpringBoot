package Book.Controller;

import Book.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    @GetMapping("/home")
    public String Home(Model model) {
        model.addAttribute("book", bookService.getAllBook());
        return "home";
    }
}
