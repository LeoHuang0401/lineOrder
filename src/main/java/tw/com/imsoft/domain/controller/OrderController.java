package tw.com.imsoft.domain.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tw.com.imsoft.domain.service.OrderService;
import tw.com.imsoft.domain.vo.order.OrderProductDetail;
import tw.com.imsoft.domain.vo.order.OrderToShopCar;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	private static List<OrderToShopCar> detailList = new ArrayList<>();
	
    /*
     *  菜單menu
     */
	@RequestMapping("/order")
	public ModelAndView order(HttpServletRequest req) {
	    ModelAndView mv = new ModelAndView("/order");
	    System.out.println("req => " + req.getSession().getAttribute("productId" + req.getSession().getAttribute("productId")));
	    mv.addObject("data",orderService.getProductData());
		return mv;
	}
	/*
	 *  商品資訊
	 */
	@RequestMapping("/orderData")
	public ModelAndView orderData(String id) {
	    long start = System.currentTimeMillis();
	    System.out.println("開始:" + start);
	    ModelAndView mv = new ModelAndView("/productDetail");
	    System.out.println("id=> " + id);
	    if(id != null && !"".equals(id)) {
	        OrderProductDetail detail = orderService.getProductDetail(id);
	        mv.addObject("detail", detail);
	        String[] sizeData = detail.getProductSizeName().split(",");
	        String[] priceData = detail.getPrice().toString().split(",");
	        mv.addObject("sizeM", sizeData[0]);
	        if(sizeData.length > 1) {
	            mv.addObject("sizeL", sizeData[1]);
	        }
	        mv.addObject("priceM", priceData[0]);
            if(sizeData.length > 1) {
                mv.addObject("priceL", priceData[1]);
            }
	    }
	    long end = System.currentTimeMillis();
	    System.out.println("結束:" + (end - start));
	    return mv;
	}

	@PostMapping("/checkToShopCar")
	public void checkToShopCar(HttpServletRequest req,HttpServletResponse res) {
	    String productId = req.getParameter("productId");
	    String size = req.getParameter("finalSize");
	    String ice = req.getParameter("finalIce");
	    String sweet = req.getParameter("finalSweet");
	    
	    OrderToShopCar order = new OrderToShopCar();
	    order.setProductId(productId);
	    order.setSize(size);
	    order.setIce(ice);
	    order.setSweet(sweet);
	    detailList.add(order);
	    System.out.println("訂單資訊 => \n" + productId + "\n" + size + "\n" + ice + "\n" + sweet);
	    req.getSession().setAttribute("productId", productId);
	    req.getSession().setAttribute("productId"+productId, detailList);
	    try {
            res.sendRedirect("order");
        } catch (IOException e) {
            e.printStackTrace();
        }
	    
	}
}
