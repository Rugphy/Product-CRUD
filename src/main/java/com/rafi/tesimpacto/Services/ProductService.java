package com.rafi.tesimpacto.Services;



import com.rafi.tesimpacto.Entity.Category;
import com.rafi.tesimpacto.Entity.Product;
import com.rafi.tesimpacto.Models.EditProductDTO;
import com.rafi.tesimpacto.Models.ProductDTO;

import com.rafi.tesimpacto.Models.ProductResponse;
import com.rafi.tesimpacto.Repositories.ProductRepository;
import com.rafi.tesimpacto.Utils.MessageModel;
import com.rafi.tesimpacto.Utils.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public List<ProductResponse> listAllProducts() {
        return productRepository.findAllProductsWithCategory();
    }

    public ProductResponse getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new RecordNotFoundException("Product not found for ID: " + id);
        }else{
            return productRepository.findByIdProductsWithCategory(id);
        }
    }


    public ResponseEntity saveProduct(ProductDTO productDTO) {
        MessageModel message = new MessageModel();
        Category category = categoryService.getCategoryById(productDTO.getCategoryId());
        if (category == null) {
            throw new RecordNotFoundException("Category not found for ID: " + productDTO.getCategoryId());
        }

        Product product = new Product();
        product.setCode(productDTO.getCode());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        boolean existingProduct  = productRepository.existsByCode(product.getCode());
        if (product.getCode() == null || product.getCode().isEmpty() || existingProduct) {
            product.setCode(generateProductCode());
        }
        productRepository.save(product);

        message.setMessage("Product saved successfully");
        message.setStatus(true);
        message.setData(getProductById(product.getId()));
        return ResponseEntity.ok().body(message);
    }

    private String generateProductCode() {
        Long maxId = productRepository.getMaxId();
        return String.format("PRD%03d", maxId + 1);
    }

    public ResponseEntity updateProduct(Long id, EditProductDTO productDTO) {
        MessageModel message = new MessageModel();
        Optional<Product> product = productRepository.findById(id);
        Category category = categoryService.getCategoryById(productDTO.getCategoryId());
        if (category == null) {
            throw new RecordNotFoundException("Category not found for ID: " + productDTO.getCategoryId());
        }
        if (product.isEmpty()) {
            throw new RecordNotFoundException("Product not found for ID: " + id);
        }else{
            Product productToUpdate = product.get();
            productToUpdate.setId(id);
            productToUpdate.setCode(productDTO.getCode());
            productToUpdate.setName(productDTO.getName());
            productToUpdate.setPrice(productDTO.getPrice());
            productToUpdate.setCategory(category);
            productRepository.save(productToUpdate);
        }
        message.setMessage("Product updated successfully");
        message.setStatus(true);
        message.setData(getProductById(id));
        return ResponseEntity.ok().body(message);
    }

    public ResponseEntity deleteProduct(Long id) {
        MessageModel message = new MessageModel();
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new RecordNotFoundException("Product not found for ID: " + id);
        }else{
            productRepository.deleteById(id);
        }
        message.setMessage("Product deleted successfully");
        message.setStatus(true);
        return ResponseEntity.ok().body(message);
    }
}