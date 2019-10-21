package com.codegym.formatter;

import com.codegym.model.ProductType;
import com.codegym.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ProductTypeFormatter implements Formatter<ProductType> {
    private ProductTypeService productTypeService;
    @Autowired
    public ProductTypeFormatter(ProductTypeService productTypeService){
        this.productTypeService=productTypeService;
    }
    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        return productTypeService.findById(Long.parseLong(text));
    }

    @Override
    public String print(ProductType object, Locale locale) {
        return "[" + object.getId() + ", " +object.getTypeName() + "]";
    }
}
