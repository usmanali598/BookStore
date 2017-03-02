package haaga.helia.serverpro.fi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import haaga.helia.serverpro.fi.domain.Book;
import haaga.helia.serverpro.fi.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookStore(BookRepository brepository){
		return (args) -> {
			log.info("save some book");
			brepository.save(new Book("java", "jari", 2010, 150554-15, 100));
			brepository.save(new Book("web", "ali", 2015, 1321554-15, 150));
			
			log.info("fetch books");
			for (Book book: brepository.findAll()){
				log.info(book.toString());
			}
			};
		}
		}
	

