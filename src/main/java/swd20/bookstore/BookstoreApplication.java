package swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd20.bookstore.domain.Book;
import swd20.bookstore.domain.BookRepository;
import swd20.bookstore.domain.Category;
import swd20.bookstore.domain.CategoryRepository;
import swd20.bookstore.domain.User;
import swd20.bookstore.domain.UserRepository;
@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("Saving a test book");
			crepository.save(new Category("Fantasia"));
			crepository.save(new Category("Kauhu"));
			crepository.save(new Category("Sci-fi"));
			crepository.save(new Category("Ruoka"));
			
			repository.save(new Book("Lentävä Kalakukko", "Jakeman ", 2001, "01-10-20", 20.00, crepository.findByName("Fantasia").get(0)));
			repository.save(new Book("Kokkauskirja", "Make Makettaja", 2009, "42-12-33", 25.00, crepository.findByName("Ruoka").get(0)));
			
			User user1 = new User("user", "$2a$10$j/K5V5/EDEsYa3uU29XN4.FVZU/d3/K3Z8FWf5C0waluHKjWgwGeu","jaakkoM@gmail.com", "USER");
			User user2 = new User("admin", "$2a$10$81ysHz8H2m/rsf0XwvNg9uLfEq1YS2VV.YZbCyOA/CridxiJgYBua","makemakettaja@gmail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("Get all categories");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
			log.info("Get all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
