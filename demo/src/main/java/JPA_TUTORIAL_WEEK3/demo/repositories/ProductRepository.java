package JPA_TUTORIAL_WEEK3.demo.repositories;

import JPA_TUTORIAL_WEEK3.demo.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findByTitle(String title);


    ProductEntity findByPriceAndQuantity( BigDecimal price,Integer quantity);
}
