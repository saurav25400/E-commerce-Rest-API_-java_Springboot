package JPA_TUTORIAL_WEEK3.demo;

import JPA_TUTORIAL_WEEK3.demo.entities.ProductEntity;
import JPA_TUTORIAL_WEEK3.demo.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;


@SpringBootTest
class DemoApplicationTests {
	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void addProduct(){
		ProductEntity productEntity=ProductEntity.builder().sku("nestle23").title("chocolate").price(BigDecimal.valueOf(125.78)).quantity(4).build();
		ProductEntity savedEntity=productRepository.save(productEntity);
		System.out.println(savedEntity);

	}

	@Test
	void getRepository(){
		List<ProductEntity> productEntity=productRepository.findByTitle("chocolate");
		System.out.println(productEntity);

	}

	@Test
	void getDataByPriceAndQuantity(){
		ProductEntity allData=productRepository.findByPriceAndQuantity(BigDecimal.valueOf(23.45),4);
		System.out.println(allData);

	}



}
