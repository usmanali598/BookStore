package haaga.helia.serverpro.fi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import haaga.helia.serverpro.fi.domain.Book;
import haaga.helia.serverpro.fi.domain.BookRepository;


@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value="/booklist")
    public String bookStore(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
			
		@RequestMapping (value = "/add")
		public String addBook(Model model){
			model.addAttribute("book", new Book());
			return "addbook";
		}
		
		@RequestMapping (value = "/save", method=RequestMethod.POST)
		public String Savebook(Book book){
			repository.save(book);
			return "redirect:booklist";
		}
		@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteBook(@PathVariable("id") Long bookid, Model model ){
			repository.delete(bookid);
			return "redirect:../booklist";
		}
	}
	

