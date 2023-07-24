package kr.or.ddit.service;

import kr.or.ddit.dao.ProductDAO;
import kr.or.ddit.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductDAO dao;

    @Override
    public int addProduct(ProductVO vo) {
        return dao.addProduct(vo);
    }

    @Override
    public List<ProductVO> products() {
        return dao.products();
    }

    @Override
    public ProductVO product(String productId) {
        return dao.product(productId);
    }
}
