package swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd20.bookstore.domain.Book;
import swd20.bookstore.domain.Category;
import swd20.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/categorylist")
    public String categoryList(Model model) {	
        model.addAttribute("categories", crepository.findAll());
        return "categorylist";
    }
	@RequestMapping(value = "/addcategory")
    public String addBook(Model model){
    	model.addAttribute("category", new Category());
    	model.addAttribute("categories", crepository.findAll());
        return "addcategory";
	}
	
	@RequestMapping(value = "/savec", method = RequestMethod.POST)
    public String save(Category category){
        crepository.save(category);
        return "redirect:categorylist";
	}
}
