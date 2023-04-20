package tw.com.imsoft.domain.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import tw.com.imsoft.domain.vo.order.OrderToShopCar;

@Service
public class OrderCheckService {

    /*
     * 確認明細
     */
    public Map<String,Object> showOrderCheck(HttpServletRequest req) {
        Map<String,Object> totalMap = new HashMap<>();
            totalMap.put("totalNum", req.getSession().getAttribute("totalNum"));
            totalMap.put("totalPrice", req.getSession().getAttribute("totalPrice"));
        return totalMap;
    }
}
