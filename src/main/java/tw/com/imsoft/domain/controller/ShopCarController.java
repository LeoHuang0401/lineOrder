package tw.com.imsoft.domain.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 *  購物車頁面
 */
public class ShopCarController {

    @RequestMapping("/shopCar")
    public ModelAndView shopCar() {
        return new ModelAndView("/shopCar");
    }
    
	@RequestMapping("/productDetail")
	public ModelAndView showProductDetail() {
		return new ModelAndView("/productDetail");
	}
}
