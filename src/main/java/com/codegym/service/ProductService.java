package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService extends GeneralService<Product> {
    Page<Product> findAllByTitleContaining(String name, Pageable pageable);
    List<Integer> getNumberPage(Page<Product> products);
    Iterable<Product> findAllByProductType(ProductType productType);
}
