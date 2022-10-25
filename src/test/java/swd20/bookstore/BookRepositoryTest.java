package swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import swd20.bookstore.domain.Book;
import swd20.bookstore.domain.BookRepository;
import swd20.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository repository;
	@Autowired CategoryRepository crepo;
	
	@Test
	public void findByTitleShouldReturnAuthor() {
		List<Book> books = repository.findByTitle("Kokkauskirja");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Make Makettaja");
	}
	@Test
	public void deleteIdShouldReturnNull() {
		List<Book> books = repository.findByTitle("Kokkauskirja");
		assertThat(books).hasSize(1);
		Long testId = books.get(0).getId();
		repository.deleteById(testId);
		List<Book> tbooks = repository.findByTitle("Kokkauskirja");
		assertThat(tbooks).hasSize(0);
	}
	
	@Test
	public void createBookShouldReturnId() {
		Book book = new Book("Lentävä Kalakukko", "Jakeman ", 2001, "01-10-20", 20.00, crepo.findByName("Fantasia").get(0));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
}
