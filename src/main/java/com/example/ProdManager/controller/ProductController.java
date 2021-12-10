package com.example.ProdManager.controller;

import com.example.ProdManager.entity.Product;
import com.example.ProdManager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/productBased/{price}/{name}")
    public Product findProductByNameAndPrice(@PathVariable double price,@PathVariable String name){
        return productService.findProductByNameAndPrice(price,name);
    }

    @GetMapping("/priceBasedProducts")
    public List<Product> findAllProductsPricesBased(){
        return productService.getPriceBasedProduct();
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @GetMapping("/productByName/{name}")
    public Product findProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }
}
