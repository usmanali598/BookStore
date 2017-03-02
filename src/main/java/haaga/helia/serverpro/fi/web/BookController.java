package haaga.helia.serverpro.fi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	// RESTful service to get all books   ,  it will show all students in JSON form
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();	
    }    

	// RESTful service to get book by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findOne(bookId);	
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
	

