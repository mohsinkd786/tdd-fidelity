package io.mohsinkd786.checkout.builders;

import io.mohsinkd786.dtos.Order;
import io.mohsinkd786.dtos.Product;

public class ProductBuilder {

    private int id;
    private int quantity;
    private double price;
    private String name;


    public static Product withSeed(int seed) {
        return new ProductBuilder()
                .withId(seed)
                .withQuantity(seed)
                .withPrice(seed)
                .withName(true)
                .build();
    }

    public ProductBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public Product build() {
        Product product = new Product(id,quantity,price,name);
        return product;
    }
}
