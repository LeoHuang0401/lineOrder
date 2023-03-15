package tw.com.imsoft.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;


/*
 *  LINE PAY 付款成功頁面
 */
@Controller
public class SucessPayController {

    @RequestMapping("/sucessPay")
    public ModelAndView sucessPay() {
        return new ModelAndView("sucessPay");
    }
}
