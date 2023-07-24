package kr.or.ddit.service;

import kr.or.ddit.vo.ProductVO;

import java.util.List;

public interface IProductService {
    public int addProduct(ProductVO vo);

    public List<ProductVO> products();

    public ProductVO product(String productId);
}
