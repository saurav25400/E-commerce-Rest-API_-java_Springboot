package JPA_TUTORIAL_WEEK3.demo.repositories;

import JPA_TUTORIAL_WEEK3.demo.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {


}
