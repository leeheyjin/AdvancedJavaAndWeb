package kr.or.ddit.dao;

import kr.or.ddit.vo.ProductVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    public int addProduct(ProductVO vo) {
        return sqlSessionTemplate.insert("product.addProduct", vo);
    }
    public List<ProductVO> products() {
        return sqlSessionTemplate.selectList("product.products");
    }

    public ProductVO product(String productId) {
        return sqlSessionTemplate.selectOne("product.product", productId);
    }
}
