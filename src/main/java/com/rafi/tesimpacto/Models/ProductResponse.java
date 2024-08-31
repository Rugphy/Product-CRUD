package com.rafi.tesimpacto.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String code;
    private String name;
    private Double price;
    private Long categoryId;
    private String categoryDesc;

    public ProductResponse(Long id, String code, String name, Double price, Long categoryId, String categoryDesc) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.categoryDesc = categoryDesc;
    }
}