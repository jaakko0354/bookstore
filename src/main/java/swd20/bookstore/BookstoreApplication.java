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
@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Saving a test book");
			crepository.save(new Category("Fantasia"));
			crepository.save(new Category("Kauhu"));
			crepository.save(new Category("Sci-fi"));
			crepository.save(new Category("Ruoka"));
			repository.save(new Book("Lentävä Kalakukko", "Jakeman ", 2001, "01-10-20", 20.00, crepository.findByName("Fantasia").get(0)));
			repository.save(new Book("Kokkauskirja", "Make Makettaja", 2009, "42-12-33", 25.00, crepository.findByName("Ruoka").get(0)));
			
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
