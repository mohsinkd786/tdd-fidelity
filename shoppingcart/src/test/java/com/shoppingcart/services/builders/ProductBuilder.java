package com.shoppingcart.services.builders;

import com.shoppingcart.dtos.Product;

public final class ProductBuilder {

    private int id;
    private String name;
    private double price;
    private int quantity;

    public ProductBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Product build() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        return product;
    }
}
