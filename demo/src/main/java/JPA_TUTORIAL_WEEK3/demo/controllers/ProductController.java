package JPA_TUTORIAL_WEEK3.demo.controllers;

import JPA_TUTORIAL_WEEK3.demo.entities.ProductEntity;
import JPA_TUTORIAL_WEEK3.demo.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping(path="/")
public class ProductController {

    private final int PAGE_SIZE=5;

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy){
      // return productRepository.findByOrderByPrice();
        return productRepository.findAll(PageRequest.of(0,PAGE_SIZE,Sort.by(sortBy))).getContent();

    }
    @GetMapping(path="product")
    public List<ProductEntity> getByTitle(@RequestParam(defaultValue = "c") String title, @RequestParam(defaultValue ="0") int pageNumber, @RequestParam String sortBy){
        //return productRepository.findByOrderByTitleDesc();
        return productRepository.findByTitleContainingIgnoreCase(title,PageRequest.of(pageNumber,PAGE_SIZE,Sort.by(sortBy)));
    }
    @GetMapping(path="product/get/sorted")
    public List<ProductEntity>GetSortedBy(@RequestParam(defaultValue = "id") String sortBY,@RequestParam(defaultValue = "id") String quantity){
//        return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBY));
        return productRepository.findBy(Sort.by(Sort.Order.asc(sortBY), Sort.Order.desc(quantity)));
    }
}
