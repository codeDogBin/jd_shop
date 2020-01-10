package com.bin.controller;

import com.bin.bean.JdCartItem;
import com.bin.bean.JdProduct;
import com.bin.service.JdProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JdCartController {
    @Autowired
    private JdProductService jdProductService;

    //这是购买请求
    @RequestMapping("/initCart")
    public String initCart(int productId,HttpServletRequest request){
        //从session中获取购物车
        List<JdCartItem> cart =(List<JdCartItem>) (request.getSession().getAttribute("cart"));
        if (cart == null){
            cart = new ArrayList();
            request.getSession().setAttribute("cart",cart);
        }
        //现在需要根据商品ID 封装一个购物车条目对象
        JdProduct product = jdProductService.productByID(productId);
        JdCartItem item = product.converToCartIter();
        if(cart.contains(item)){
            for (JdCartItem temp : cart) {
                if(temp.equals(item)){
                    temp.setProductCount(temp.getProductCount()+1);
                    break;
                }
            }
        }else {
            cart.add(item);
        }
        //计算总数量和总价格
        int sumCount = 0;
        double sumPrice = 0;
        for (JdCartItem temp : cart) {
            sumCount += temp.getProductCount();
            sumPrice += temp.getProductCount()*temp.getLowerPrice();
        }
        request.setAttribute("sumCount",sumCount);
        request.setAttribute("sumPrice",sumPrice);
        return "initCart";
    }

    /*
     * 功能描述 进入到购物车页面
     * @Author bin
     * @param request 
     * @return java.lang.String        
     */
    @RequestMapping("/myCart")
    public String myCart(HttpServletRequest request){
        double sumPrice = 0;
        List<JdCartItem> cart =(List<JdCartItem>) (request.getSession().getAttribute("cart"));
        for (JdCartItem temp : cart) {
            sumPrice += temp.getProductCount()*temp.getLowerPrice();
        }
        request.setAttribute("sumPrice",sumPrice);
        return "myCart";
    }
    
    @RequestMapping("/updateCartItemCountAJAX.do")
    @ResponseBody
    public Map<String,Object> updateCartItemCount(int productId, String type,HttpServletRequest request){
        Map<String,Object> res = new HashMap<>();
        List<JdCartItem> cart = (List<JdCartItem>) request.getSession().getAttribute("cart");
        for (JdCartItem cartItem : cart) {
            if(cartItem.getProductId() == productId){
                if(type.equals("add")){
                    cartItem.setProductCount(cartItem.getProductCount()+1);
                    res.put("count",cartItem.getProductCount());
                }else {
                    cartItem.setProductCount(cartItem.getProductCount()-1);
                    res.put("count", cartItem.getProductCount());
                }
                break;
            }
        }
        double sumPrice = 0;
        for (JdCartItem temp : cart) {
            sumPrice += temp.getProductCount()*temp.getLowerPrice();
        }
        res.put("sumPrice",sumPrice);
        return res;
    }
    @ResponseBody
    @RequestMapping("deleteCartItemAjax.do")
    public Map<String,Object> deleteCartItemAjax(int productId,HttpServletRequest request){
        Map<String,Object> res = new HashMap<>();
        List<JdCartItem> cart = (List<JdCartItem>) request.getSession().getAttribute("cart");
        for (JdCartItem cartItem : cart) {
            if(cartItem.getProductId() == productId){
                cart.remove(cartItem);
                res.put("status",true);
                break;
            }
        }
        //计算购物车总价格
        double sumPrice = 0;
        for (JdCartItem temp : cart) {
            sumPrice += temp.getProductCount()*temp.getLowerPrice();
        }
        res.put("sumPrice",sumPrice);
        return res;
    }

}
