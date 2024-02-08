package com.global.product.config;

import com.global.product.service.ProductService;

import com.global.product.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class StartUpApp  implements CommandLineRunner {


    private  ProductService productService;


    @Override
    public void run(String... args) {


            productService.update(new Product(null, "product 1" , 333.5, "category 1"));
            productService.update(new Product(null, "product 2" , 333.5, "category 1"));
            productService.update(new Product(null, "product 3" , 333.5, "category 2"));
            productService.update(new Product(null, "product 4" , 333.5, "category 2"));

    }
}
