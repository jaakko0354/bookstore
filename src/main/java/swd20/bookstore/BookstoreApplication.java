package swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd20.bookstore.domain.Book;
import swd20.bookstore.domain.BookRepository;
@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("Saving a test book");
			repository.save(new Book("Makkarat", "Jakepake", 2001, "0110", 20.00));
			
			
			log.info("Get all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
