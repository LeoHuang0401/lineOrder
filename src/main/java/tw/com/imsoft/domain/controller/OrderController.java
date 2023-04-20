package tw.com.imsoft.domain.controller;

import java.io.IOException;
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

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
    /*
     *  菜單menu
     */
	@RequestMapping("/order")
	public ModelAndView order(HttpServletRequest req,String id) {
	    ModelAndView mv = new ModelAndView("/order");
	    // 付款畫面回首頁後清除session 資訊
	    if(req.getSession().getAttribute("takeTime") != null) {
	        req.getSession().removeAttribute("takeTime");
	        req.getSession().removeAttribute("orderNo");
	        req.getSession().removeAttribute("totalPrice");
	    }
	    if(req.getSession().getAttribute("test") == null) {
	        req.getSession().setAttribute("test", "1");
	    }
	    if(req.getSession().getAttribute("uLineId") == null) {
	        req.getSession().setAttribute("uLineId", id);
	    }
	    mv.addObject("data",orderService.getProductData());
	    // 購物車商品數呈現於首頁
	    List listSize = (List) req.getSession().getAttribute("productData");
	    if(listSize != null) {
	        mv.addObject("shopCarNum",listSize.size());
	    }
		return mv;
	}
	
	@RequestMapping("/order/Line")
    public void orderLineId(HttpServletRequest req,String id, String name,HttpServletResponse res) {
        if(!"".equals(id) && req.getSession().getAttribute("uLineId") == null) {
            req.getSession().setAttribute("uLineId", id);
            req.getSession().setAttribute("uLineName", name);
        }
        res.setStatus(res.SC_OK);
    }
	/*
	 *  商品資訊
	 */
	@RequestMapping("/order/orderData")
	public ModelAndView orderData(HttpServletRequest req,String id) {
	    ModelAndView mv = new ModelAndView("/productDetail");
	    if(id != null && !"".equals(id)) {
	        OrderProductDetail detail = orderService.getProductDetail(id);
	        mv.addObject("detail", detail);
	        String[] sizeIdData = detail.getProductSizeId().split(",");
	        String[] sizeData = detail.getProductSizeName().split(",");
	        String[] priceData = detail.getPrice().split(",");
	        mv.addObject("noM", sizeIdData[0]);
            if(sizeIdData.length > 1) {
                mv.addObject("noL", sizeIdData[1]);
            }
	        mv.addObject("sizeM", sizeData[0]);
	        if(sizeData.length > 1) {
	            mv.addObject("sizeL", sizeData[1]);
	        }
	        mv.addObject("priceM", priceData[0]);
            if(sizeData.length > 1) {
                mv.addObject("priceL", priceData[1]);
            }
	    }
	    List listSize = (List) req.getSession().getAttribute("productData");
        if(listSize != null) {
            mv.addObject("shopCarNum",listSize.size());
        }
	    return mv;
	}

	/*
	 *  商品加入購物車 加(session)
	 */
	@PostMapping("/order/checkToShopCar")
	public void checkToShopCar(HttpServletRequest req,HttpServletResponse res) {
	    orderService.checkToShopCar(req);
	    try {
            res.sendRedirect("../order");
        } catch (IOException e) {
            e.printStackTrace();
        }
	    
	}
}
