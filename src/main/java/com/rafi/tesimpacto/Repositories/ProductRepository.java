package com.rafi.tesimpacto.Repositories;


import com.rafi.tesimpacto.Entity.Product;
import com.rafi.tesimpacto.Models.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByCode(String code);

    @Query("SELECT MAX(id) FROM Product")
    Long getMaxId();


    @Query("SELECT new com.rafi.tesimpacto.Models.ProductResponse(" +
            "p.id, " +
            "p.code, " +
            "p.name, " +
            "p.price, " +
            "c.id, " +
            "c.name) " +
            "FROM Product p " +
            "LEFT JOIN p.category c")
    List<ProductResponse> findAllProductsWithCategory();

    @Query("SELECT new com.rafi.tesimpacto.Models.ProductResponse(" +
            "p.id, " +
            "p.code, " +
            "p.name, " +
            "p.price, " +
            "c.id, " +
            "c.name) " +
            "FROM Product p " +
            "LEFT JOIN p.category c" +
            " WHERE p.id = :id")
    ProductResponse findByIdProductsWithCategory(@RequestParam("id") Long id);
}
