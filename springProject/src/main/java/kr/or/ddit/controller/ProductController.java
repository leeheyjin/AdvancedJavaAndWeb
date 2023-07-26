package kr.or.ddit.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import kr.or.ddit.service.ProductService;
import kr.or.ddit.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Slf4j
@Controller
public class ProductController {
    @Autowired
    ProductService service;

    @RequestMapping(value = "/shopping/welcome", method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView mav) {
        mav.setViewName("shopping/welcome");
        return mav;
    }

    @RequestMapping(value = "shopping/addProduct", method = RequestMethod.GET)
    public ModelAndView addProduct(ModelAndView mav) {
        mav.setViewName("shopping/addProduct");
        return mav;
    }

    @RequestMapping(value = "/shopping/products", method = RequestMethod.GET)
    public ModelAndView products(ModelAndView mav) {
        List<ProductVO> list = service.products();
        mav.addObject("listOfProducts", list);
        mav.setViewName("shopping/products");
        return mav;
    }

    @RequestMapping(value = "/shopping/processAddProduct", method = RequestMethod.POST)
    public ModelAndView processAddProduct(ModelAndView mav, ProductVO vo) {
        log.info("vo: " + vo);
        String uploadFolder = "/Users/leehyejin/Project/ddit/ddit/springProject/src/main/webapp/resources/images";
        MultipartFile multipartFile = vo.getFileImage();
        String filename = multipartFile.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        filename = uuid.toString() + "_" + filename;
        log.info("filename : " + filename);

        File saveFile = new File(uploadFolder, filename);
        try {
            multipartFile.transferTo(saveFile);
            mav.setViewName("redirect:/shopping/products");
        } catch (IOException e) {
            e.printStackTrace();
            mav.setViewName("redirect:/shopping/addProduct");
        }
        return mav;
    }

    @RequestMapping(value = "/shopping/product", method = RequestMethod.GET)
    public ModelAndView product(ModelAndView mav, String productId) {
        ProductVO vo = service.product(productId);
        mav.addObject("product", vo);
        mav.setViewName("shopping/product");
        return mav;
    }

    @RequestMapping(value = "/shopping/addCart", method = RequestMethod.POST)
    public ModelAndView addCart(@RequestParam String productId, ModelAndView mav, HttpServletRequest request) {
        if (productId == null || productId.trim().equals("")) {
            mav.setViewName("redirect:/shopping/products");
            return mav;
        }

        ProductVO vo = service.product(productId);
        if (vo == null) {
            mav.setViewName("redirect:/shopping/exceptionNoProductId");
            return mav;
        }

        HttpSession session = request.getSession();
        ArrayList<ProductVO> list = (ArrayList<ProductVO>) session.getAttribute("cartlist");
        if (list == null) {
            list = new ArrayList<ProductVO>();
            session.setAttribute("cartlist", list);
        }

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductId().equals(productId)) {
                count++;
                list.get(i).setQuantity(list.get(i).getQuantity() + 1);
            }
        }

        if (count == 0) {
            vo.setQuantity(1);
            list.add(vo);
        }

        for (ProductVO product : list) {
            log.info("vo: " + list);
        }

        mav.setViewName("redirect:/shopping/product?productId=" + productId);
        return mav;
    }

    @RequestMapping(value = "/shopping/cart", method = RequestMethod.GET)
    public ModelAndView cart(HttpServletRequest request, ModelAndView mav) {
        HttpSession session = request.getSession();
        String cartId = session.getId();
        log.info("cartId: " + cartId);
        List<ProductVO> cartList = (List<ProductVO>) session.getAttribute("cartlist");
        log.info("cartList: " + cartList);
        mav.addObject("cartId", cartId);
        mav.addObject("cartList", cartList);
        mav.setViewName("shopping/cart");
        return mav;
    }

    @RequestMapping(value = "/shopping/removeCart")
    public ModelAndView removeCart(@RequestParam String productId, ModelAndView mav, HttpServletRequest request) {
        log.info("productId: " + productId);
        if (productId == null || productId.trim().equals("")) {
            mav.setViewName("redirect:/shopping/products");
        }
        ProductVO vo = service.product(productId);
        if (vo == null) {
            mav.setViewName("shopping/exceptionNoProductId");
        } else {
            HttpSession session = request.getSession();
            List<ProductVO> cartlist = (List<ProductVO>) session.getAttribute("cartlist");
            for (int i = 0; i < cartlist.size(); i++) {
                if (cartlist.get(i).getProductId().equals(productId)) {
                    cartlist.remove(cartlist.get(i));
                }
            }
            mav.setViewName("redirect:/shopping/cart");
        }
        return mav;

    }

    @RequestMapping("/shopping/deleteCart")
    public ModelAndView deleteCart(ModelAndView mav, @RequestParam(value = "cartId") String cartId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        cartId = (String) session.getAttribute("cartId");
        if (cartId != null && !cartId.trim().equals("")) {
            session.removeAttribute("cartlist");
            mav.setViewName("shopping/cart");
        } else {
            mav.setViewName("redirect:/shopping/cart");
        }
        return mav;
    }

    @RequestMapping(value = "/shopping/shippingInfo", method = RequestMethod.GET)
    public ModelAndView shippingInfo(@RequestParam String cartId, ModelAndView mav, HttpServletRequest request) {
        HttpSession session = request.getSession();
        cartId = (String) session.getAttribute("cartId");
        if (cartId == null || cartId.trim().equals("")) {
            mav.setViewName("redirect:/shopping/cart");
        }
        mav.setViewName("shipping/processShippingInfo");
        return mav;
    }

    @RequestMapping(value = "/shopping/processShippingInfo", method = RequestMethod.POST)
    public ModelAndView processShippingInfo(@RequestParam Map<String, Object> param, ModelAndView mav) {
        mav.addObject("map", param);
        mav.setViewName("shopping/orderConfirmation");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value = "/shopping/thankCustomer", method = RequestMethod.POST)
    public String thankCustomer(ModelAndView mav, HttpSession session, @RequestParam Map<String, Object> param) {
        Map<String, String> shippingDateMap = new HashMap<String, String>();
        shippingDateMap.put("shippingDate", param.get("shippingDate").toString());
        Map<String, String> cartIdMap = new HashMap<String, String>();
        cartIdMap.put("cartId", param.get("cartId").toString());

        session.setAttribute("shippingDateMap", shippingDateMap);
        session.setAttribute("cartIdMap", cartIdMap);
        session.removeAttribute("cartlist");
        mav.setViewName("shopping/thankCustomer");
        return "sucess";
    }

    @RequestMapping(value = "/shopping/thankCustomer", method = RequestMethod.GET)
    public ModelAndView thankCustomerGet(ModelAndView mav) {
        mav.setViewName("shopping/thankCustomer");
        return mav;
    }

}
