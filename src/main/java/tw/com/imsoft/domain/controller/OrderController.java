package tw.com.imsoft.domain.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tw.com.imsoft.dao.mapper.StoreMapper;

@Controller
public class OrderController {
	
	@Autowired
	StoreMapper storeMapper;
	
	@RequestMapping("/order")
	public ModelAndView order() {
		return new ModelAndView("/order");
	}
	
	@RequestMapping("/checkOut")
	public ModelAndView checkOut() {
		System.out.println(storeMapper.selectByPrimaryKey(new BigDecimal(1)));
		return new ModelAndView("checkOutOrder");
	}

}
