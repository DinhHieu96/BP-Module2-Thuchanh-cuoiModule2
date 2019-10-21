package com.codegym.service.impl;


import com.codegym.model.Product;
import com.codegym.model.ProductType;
import com.codegym.repository.ProductRepository;
import com.codegym.repository.ProductTypeRepository;
import com.codegym.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductTypeRepository productTypeRepository;

    @Override
    public Iterable<ProductType> findAll() {
        return null;
    }

    @Override
    public Page<ProductType> findAll(Pageable pageable) {
        return productTypeRepository.findAll(pageable);
    }

    @Override
    public ProductType findById(Long id) {
        return productTypeRepository.findOne(id);
    }

    @Override
    public void save(ProductType productType) {
        productTypeRepository.save(productType);

    }

    @Override
    public void remove(Long id) {
        ProductType productType = findById(id);
        List<Product> notes = (List<Product>) productRepository.findAllByProductType(productType);
        for(int i=0; i<notes.size(); i++){
            productRepository.delete(notes.get(i));
        }
        productTypeRepository.delete(id);
    }
}
