package tw.com.imsoft.domain.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 *  確認付款
 */
@Controller
public class OrderCheckPayController {

    @RequestMapping("/orderCheckPay")
    public ModelAndView orderCheckPay(HttpServletRequest req,String takeTime) {
        ModelAndView mv = new ModelAndView("/orderCheckPay");
        String totalPrice = req.getSession().getAttribute("totalPrice").toString();
        req.getSession().setAttribute("takeTime", takeTime);
        mv.addObject("takeTime",takeTime);
        mv.addObject("totalPrice", totalPrice);
        return mv;
    }
}
