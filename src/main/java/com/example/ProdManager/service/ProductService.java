package com.example.ProdManager.service;

import com.example.ProdManager.entity.Product;
import com.example.ProdManager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product removed : "+id;
    }

    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }

    public Product findProductByNameAndPrice(double price, String name){
        return repository.findProductByNameAndPrice(price,name);
    }
    public List<Product> getPriceBasedProduct(){
        return repository.findAllUserWithPrice();
    }

}
