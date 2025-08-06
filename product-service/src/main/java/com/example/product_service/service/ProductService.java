package com.example.product_service.service;

import com.example.product_service.dto.ProductRequest;
import com.example.product_service.dto.ProductResponse;
import com.example.product_service.entity.Product;
import com.example.product_service.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepo productRepo;

    public Product createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepo.save(product);
        log.info("Product {} is saved",product.getId());
        return product;
    }

    public List<ProductResponse> getAllProducts(){
        List<ProductResponse> products = productRepo.findAll().stream().map(product->
                new ProductResponse(product.getName(), product.getDescription(), product.getPrice()))
                .toList();
        log.info("Products are fetched successfully");
        return products;
    }
}
