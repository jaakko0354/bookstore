package swd20.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import swd20.bookstore.web.BookstoreController;
import swd20.bookstore.web.UserController;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookstoreControllerTest {
	@Autowired
	private BookstoreController bcontroller;
	
	@Autowired 
	private UserController ucontroller;
	
	@Test
	public void contextLoads()throws Exception {
		assertThat(bcontroller).isNotNull();
	}
	
	
	
}
