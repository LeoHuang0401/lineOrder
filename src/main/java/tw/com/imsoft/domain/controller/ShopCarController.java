package tw.com.imsoft.domain.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import tw.com.imsoft.domain.service.ShopCarService;

/*
 *  購物車頁面
 */
@Controller
public class ShopCarController {

    @Autowired
    ShopCarService shopCarService;
    
    /*
     * 取得session裡購物車資訊
     */
    @RequestMapping("/shopCar")
    public ModelAndView shopCar(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("/shopCar");
        Map<String,Object> totalMap = shopCarService.showShopCar(req);
        mv.addObject("dataList", req.getSession().getAttribute("productData"));
        mv.addObject("total", totalMap);
        return mv;
    }
    
    /*
     * 移除選擇的購物車商品
     */
    @PostMapping("/shopCar/remove")
    public @ResponseBody void removeProduct(HttpServletRequest req,String index) {
        shopCarService.removeProduct(req,index);
    }
    
    /*
     * 調整商品數量
     */
    @PostMapping("/shopCar/edit")
    public @ResponseBody void editProduct(HttpServletRequest req,String index,int num,String mt) {
        shopCarService.editProduct(req, index, num, mt);
    }
}
