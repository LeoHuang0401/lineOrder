package tw.com.imsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
	
	@RequestMapping("/order")
	public ModelAndView order() {
		ModelAndView mv = new ModelAndView("/order");
		return mv;
	}

}
