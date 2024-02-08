package com.global.product.controller;

import com.global.product.service.ProductService;

import com.global.product.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

	private  ProductService productService;


	@GetMapping("/{id}")
	public Mono<Product> findById(@PathVariable Long id) {
		return productService.findById(id);
	}

	//@GetMapping(value = "", produces = {"text/event-stream"} )
	@GetMapping(value = "", produces = {"text/event-stream"})
	public Flux<Product> findAll() {

		return productService.findAll();
	}

	@GetMapping("/name/{name}")
	public Flux<Product> findByName(@PathVariable String name) {

		return productService.findByName(name);
	}

	@PostMapping()
	public Mono<Product> insert(@RequestBody Product product) {

		return productService.insert(product);
	}

	@PutMapping()
	public Mono<Product> update(@RequestBody Product product) {

		return productService.update(product);
	}

	@DeleteMapping()
	public Mono<Void> delete(Long id) {

		return productService.delete(id);
	}


	@GetMapping("/count")
	public Integer getProductCount () {

		return 20 ;
	}

	@GetMapping(value = "/reactive-count" , produces = {"text/event-stream"} )
	public Mono<ResponseEntity<Integer>> getProductCountReactive () {

		return Mono.just(ResponseEntity.ok(20)) ;
	}

	@GetMapping("/all")
	public List<Integer> getAll () throws InterruptedException{
		List<Integer> products = new ArrayList<Integer>();

		for (int i = 0; i < 20 ; i++) {

			products.add(i +1);

			Thread.sleep(500);

		}

		return products;
	}

	@GetMapping(value ="/all-reactive", produces = {"text/event-stream"})
	public Flux<Integer> getAllReactive () throws InterruptedException{

		return Flux.create(fluxList -> {
			for (int i = 0; i <20; i++) {
				fluxList.next(i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			fluxList.complete();
		});
	}


}
