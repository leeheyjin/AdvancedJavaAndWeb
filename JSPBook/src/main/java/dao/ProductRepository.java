package dao;

import java.util.ArrayList;
import java.util.List;

import vo.ProductVO;

public class ProductRepository {
	private List<ProductVO> listOfProducts = new ArrayList<>();
	private static ProductRepository instance;

	public static ProductRepository getInstance() {
		if (instance == null) {
			instance = new ProductRepository();
		}
		return instance;
	}

	public ProductRepository() {
		ProductVO phone = new ProductVO("P1234", "iPhone 6s", 800000);
		phone.setDescription("4.7-inch, 1334x750 Renina HD display. 8-megapixel iSight Camera");
		phone.setCategory("Smart Phone");
		phone.setManufacturer("Apple");
		phone.setUnitsInStock(1000);
		phone.setCondition("NEW");
		phone.setFilename("P1234.jpeg");

		ProductVO notebook = new ProductVO("P1235", "LG PC그램", 1500000);
		notebook.setDescription("13.3-inch, IPS LED display, 5rd Generation Intel Core processors");
		notebook.setCategory("Notebook");
		notebook.setManufacturer("LG");
		notebook.setUnitsInStock(1000);
		notebook.setCondition("Refurbished");
		notebook.setFilename("P1235.jpeg");

		ProductVO tablet = new ProductVO("P1236", "Galaxy Tab S", 900000);
		tablet.setDescription("212.8*125.6*6.6m, Super AMOLED display, Octa-Core processor");
		tablet.setCategory("Tablet");
		tablet.setManufacturer("Samsung");
		tablet.setUnitsInStock(1000);
		tablet.setCondition("Old");
		tablet.setFilename("P1236.jpeg");

		listOfProducts.add(phone);
		listOfProducts.add(notebook);
		listOfProducts.add(tablet);
	}
	
	// select * from product
	public List<ProductVO> getAllProducts() {
		return listOfProducts;
	}

	// select * from product where product_id = ?
	public ProductVO getProductById(String productId) {
		ProductVO productById = null;
		for (ProductVO productVO : listOfProducts) {
			if (productVO.getProductId().equals(productId)) {
				productById = productVO;
				break;
			}
		}
		return productById;
	}
	
	// insert into product
	public void addProduct(ProductVO productVO) {
		listOfProducts.add(productVO);
	}
}
