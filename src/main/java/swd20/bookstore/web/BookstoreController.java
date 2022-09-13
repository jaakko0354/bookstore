package swd20.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookstoreController {
	
	@RequestMapping("/index")
	public String index() {
		return "hello";
	}
}
