package swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import swd20.bookstore.domain.User;
import swd20.bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository urepo;
	
	@Test
	public void findByUsernameShouldReturnRole() {
		User user = urepo.findByUsername("admin");
		assertThat(user.getRole()).isEqualTo("ADMIN");
	}
	@Test
	public void deleteIdShouldReturnNull() {
		User user = urepo.findByUsername("admin");
		urepo.delete(user);
		User user2 = urepo.findByUsername("admin");
		assertThat(user2).isNull();
	}
	
	@Test
	public void createUserShouldReturnRole() {
		User user = new User("user1", "$2a$10$j/K5V5/EDEsYa3uU29XN4.FVZU/d3/K3Z8FWf5C0waluHKjWgwGeu","NeaT@gmail.com", "USER");
		urepo.save(user);
		assertThat(user.getRole()).isNotNull();
	}
}
