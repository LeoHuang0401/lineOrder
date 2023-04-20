package tw.com.imsoft.domain.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/*
 *  LINE PAY 付款成功頁面
 */
@Controller
public class SucessPayController {

    @RequestMapping("/sucessPay")
    public ModelAndView sucessPay(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView mv = null;
        if(req.getSession().getAttribute("takeTime") != null) {
            mv = new ModelAndView("/sucessPay");
            String takeTime = req.getSession().getAttribute("takeTime").toString();
            mv.addObject("takeTime", LocalDate.now() + " " + takeTime);
            mv.addObject("orderNo", req.getSession().getAttribute("orderNo").toString());
            mv.addObject("totalPrice", req.getSession().getAttribute("totalPrice").toString());
            mv.addObject("uLineName", req.getSession().getAttribute("uLineName").toString());
        }else {
            try {
                res.sendRedirect("order");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mv;
    }
}
