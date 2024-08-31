package com.rafi.tesimpacto.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ProductDTO {
    private String code;
    private String name;
    private Double price;
    private Long categoryId;
}
