package haaga.helia.serverpro.fi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import haaga.helia.serverpro.fi.domain.Book;
import haaga.helia.serverpro.fi.domain.BookRepository;
import haaga.helia.serverpro.fi.domain.Category;
import haaga.helia.serverpro.fi.domain.CategoryRepository;
import haaga.helia.serverpro.fi.domain.User;
import haaga.helia.serverpro.fi.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookStore(BookRepository brepository, CategoryRepository crepository, UserRepository urepository){
		return (args) -> {
			log.info("save some book");
			crepository.save(new Category("Science"));
			crepository.save(new Category("IT"));
			crepository.save(new Category("Pyscology"));
			crepository.save(new Category("Business"));
			
			brepository.save(new Book("java", "jari", 2010, 150554-15, 100, crepository.findByName("IT").get(0)));
			brepository.save(new Book("web", "ali", 2015, 1321554-15, 150, crepository.findByName("Business").get(0)));
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch books");
			for (Book book: brepository.findAll()){
				log.info(book.toString());
			}
			};
		}
		}
	

