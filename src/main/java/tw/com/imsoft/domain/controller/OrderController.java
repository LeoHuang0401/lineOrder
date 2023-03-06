package tw.com.imsoft.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
	
	@RequestMapping("/order")
	public ModelAndView order() {
		return new ModelAndView("/order");
	}

}
