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
	
    /*
     *  菜單menu
     */
	@RequestMapping("/order")
	public ModelAndView order() {
		return new ModelAndView("/order");
	}
	
	/*
	 *  商品資訊
	 */
	@RequestMapping("/order/orderData")
	public ModelAndView orderData() {
	    return new ModelAndView("/order/orderData");
	}

}
