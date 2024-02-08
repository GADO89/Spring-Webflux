package com.global.product.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto implements Serializable {

    private static final  long serialVersionUID=-973790642300432737L;

    private Long id;

    private String tile;

    private String body;

    private Long userId;

}
