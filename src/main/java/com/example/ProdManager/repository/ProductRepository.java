package com.example.ProdManager.repository;

import com.example.ProdManager.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);

    @Query("SELECT u FROM Product u WHERE u.price = 10")
    List<Product> findAllUserWithPrice();

    @Query("SELECT u FROM Product u WHERE u.price = :price and u.name = :name")
    Product findProductByNameAndPrice(@Param("price") double price,
                                         @Param("name") String name);
}
