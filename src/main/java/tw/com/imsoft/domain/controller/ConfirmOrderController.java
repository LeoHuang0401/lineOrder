package tw.com.imsoft.domain.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tw.com.imsoft.dao.mapper.StoreAuthMapper;
import tw.com.imsoft.dao.model.StoreAuth;
import tw.com.imsoft.domain.service.ConfirmOrderService;

/*
 *  確認訂單頁面 以及 LINE PAY APIs
 */
@Controller
public class ConfirmOrderController {

    @Autowired
    StoreAuthMapper storeAuthMapper;
    
    @Autowired
    ConfirmOrderService confirmOrderService;
    
    /*
     * 消費者付款請求 Api
     */
    @PostMapping(value = "/confirmOrder/checkLinePay")
    public void pay(HttpServletRequest req,HttpServletResponse res) {
        System.out.println("取餐時間 => " + req.getParameter("pickUpTime"));
        try {
//          取得LinePay 付款頁面
            String linePayUrl = confirmOrderService.requestApi();
//          轉導至LinePay 付款頁面
            res.sendRedirect(linePayUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * 商家請款Api
     */
    @RequestMapping("/confirmOrder/checkPay")
    public void checkPay(HttpServletResponse res,String transactionId,String orderId) {
        System.out.println("ID => " + transactionId + "-" + orderId);
        try {
//          請款Api
            confirmOrderService.confirmApi(transactionId, orderId);
//          成功後轉導至成功付款頁面
            res.sendRedirect("/onlineOrder/sucessPay");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
