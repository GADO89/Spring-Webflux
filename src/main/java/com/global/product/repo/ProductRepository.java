package com.global.product.repo;

import com.global.product.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository <Product, Long>{


    Flux<Product> findByName(String name);
}
