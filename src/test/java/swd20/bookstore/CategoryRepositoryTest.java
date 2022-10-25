package swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import swd20.bookstore.domain.Category;
import swd20.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void findByNameShouldReturnId() {
		List<Category> categories = crepository.findByName("Fantasia");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getCategoryid()).isNotNull();
	}
	
	@Test
	public void deleteIdShouldReturnNull() {
		List<Category> categories = crepository.findByName("Fantasia");
		assertThat(categories).hasSize(1);
		Long testId = categories.get(0).getCategoryid();
		crepository.deleteById(testId);
		List<Category> tcategories = crepository.findByName("Fantasia");
		assertThat(tcategories).hasSize(0);
	}
	
	@Test
	public void createCategory() {
		Category category = new Category("Maalaus");
		crepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
}
