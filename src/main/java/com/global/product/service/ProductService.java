package com.global.product.service;

import com.global.product.repo.ProductRepository;

import com.global.product.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ProductService {

	 private  ProductRepository productRepository ;

	    public Mono<Product> findById(Long id){
	        return productRepository.findById(id);
	    }

	    public Flux<Product> findAll(){
	        return productRepository.findAll();
	    }

	    public Flux<Product> findByName(String name){
	        return productRepository.findByName(name);
	    }

	    public Mono<Product> insert(Product product){
	        return productRepository.insert(product);
	    }

	    public Mono<Product> update(Product product){
	        return productRepository.save(product);
	    }


	    public Mono<Void> delete(Long id){
	        return productRepository.deleteById(id);
	    }

}
