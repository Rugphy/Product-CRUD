package com.rafi.tesimpacto.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class EditProductDTO {

//    private Long id;
    private String code;
    private String name;
    private Double price;
    private Long categoryId;
}
