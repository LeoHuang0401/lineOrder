package tw.com.imsoft.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * 確認訂單
 */
@Controller
public class OrderCheckController {

    @RequestMapping("/orderCheck")
    public ModelAndView orderCheck() {
        return new ModelAndView("/orderCheck");
    }
}
