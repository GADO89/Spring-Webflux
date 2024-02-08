package com.global.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {
    public Product(Object object, String string, double d, String string2) {
		// TODO Auto-generated constructor stub
	}

	@Id
    private String id;

    private String name;

    private double price;

    private String category;

}
