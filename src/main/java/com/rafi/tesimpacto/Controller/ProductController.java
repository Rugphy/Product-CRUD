package com.rafi.tesimpacto.Controller;


import com.rafi.tesimpacto.Entity.Category;
import com.rafi.tesimpacto.Entity.Product;
import com.rafi.tesimpacto.Models.EditProductDTO;
import com.rafi.tesimpacto.Models.ProductDTO;
import com.rafi.tesimpacto.Models.ProductResponse;
import com.rafi.tesimpacto.Services.CategoryService;
import com.rafi.tesimpacto.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<ProductResponse> listProducts() {
        return productService.listAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditProductDTO> updateProduct(@PathVariable Long id, @RequestBody EditProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
