package tw.com.imsoft.domain.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tw.com.imsoft.domain.service.OrderCheckService;

/*
 * 確認明細
 */
@Controller
public class OrderCheckController {

    @Autowired
    OrderCheckService orderCheckService;
    
    @RequestMapping("/orderCheck")
    public ModelAndView orderCheck(HttpServletRequest req,HttpServletResponse res) {
        ModelAndView mv = new ModelAndView("/checkOutOrder");
        Map<String,Object> totalMap = orderCheckService.showOrderCheck(req);
        if(totalMap.get("totalNum") == null || totalMap.get("totalPrice") == null) {
            try {
                res.sendRedirect("order");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            mv.addObject("pickUpTime", LocalTime.now().plusMinutes(15));
            mv.addObject("dataList", req.getSession().getAttribute("productData"));
            mv.addObject("total", totalMap);
        }
        if(req.getSession().getAttribute("takeTime") != null) {
            String takeTime = req.getSession().getAttribute("takeTime").toString();
            mv.addObject("takeTime",takeTime);
        }
        return mv;
    }
}
