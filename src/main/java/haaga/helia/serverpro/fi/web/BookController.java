package haaga.helia.serverpro.fi.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import haaga.helia.serverpro.fi.domain.Book;



@Controller
public class BookController {
	@RequestMapping(value="/index", method=RequestMethod.GET)
    public String bookStore(Model model) {
        model.addAttribute("book", new Book());
        return "index";
    }
}
