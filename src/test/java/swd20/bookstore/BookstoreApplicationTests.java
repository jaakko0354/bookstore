package swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import swd20.bookstore.web.UserController;

@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired 
	private UserController ucontroller;
	@Test
	void contextLoads()throws Exception {
		assertThat(ucontroller).isNotNull();
	}

}
