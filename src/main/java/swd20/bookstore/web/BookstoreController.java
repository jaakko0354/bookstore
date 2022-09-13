package swd20.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class BookstoreController {
	@GetMapping("/index")
	public String index() {
		return "Hello";
	}
}
