package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="types")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String typeName;
    @OneToMany(mappedBy = "productType")
    private Set<Product> products;

    public ProductType() {
    }

    public ProductType(String typeName, Set<Product> products) {
        this.typeName = typeName;
        this.products = products;
    }
    public ProductType(Long id, String typeName, Set<Product> products) {
        this.id = id;
        this.typeName = typeName;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
