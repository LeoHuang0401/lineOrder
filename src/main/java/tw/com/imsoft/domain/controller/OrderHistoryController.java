package tw.com.imsoft.domain.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tw.com.imsoft.domain.service.OrderHistoryService;
import tw.com.imsoft.domain.vo.orderHistory.OrderHistoryData;
import tw.com.imsoft.domain.vo.orderHistory.OrderHistoryDetailData;

/*
 *  過去訂單紀錄
 */
@Controller
public class OrderHistoryController {

    @Autowired
    OrderHistoryService orderHistoryService;
    
    @RequestMapping("/orderHistory")
    public ModelAndView getOrderHistory(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("/orderHistory");
        if(req.getSession().getAttribute("uLineId") != null) {
            String memId = req.getSession().getAttribute("uLineId").toString();
            List<OrderHistoryData> orderHistoryList = orderHistoryService.getOrderHistoryData(memId);
            mv.addObject("dataList", orderHistoryList);
        }
        return mv;
    }
    
    @PostMapping("/orderHistoryDetail")
    public ModelAndView getOrderHistoryDetail(HttpServletRequest req,String orderN,String totalPrice,String orderTime) {
        ModelAndView mv = new ModelAndView("/orderHistoryDetail");
        if(orderN != null && !"".equals(orderN)) {
            List<OrderHistoryDetailData> detailDataList = orderHistoryService.getOrderHistoryDetailData(orderN);
            mv.addObject("orderNo",orderN);
            mv.addObject("totalPrice",totalPrice);
            mv.addObject("orderTime",orderTime);
            mv.addObject("detailList",detailDataList);
        }
        return mv;
    }
    
}
