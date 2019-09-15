package p.hh.trymvc.tma.controller.pre;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @ModelAttribute
    public Book retrieveBook() {
        System.out.println("retrieve book and put it in model");
        return new Book();
    }

    @GetMapping("/book")
    public Book getBook(@ModelAttribute Book book) {
        System.out.println("execute handler");
        return book;
    }
}
