package io.mohsinkd786.services.impl;

import io.mohsinkd786.dtos.Item;
import io.mohsinkd786.dtos.ProductRequest;
import io.mohsinkd786.services.ProductService;
import io.mohsinkd786.services.utils.ProductsGenerator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService {

    private final List<Item> items = ProductsGenerator.items();

    @Override
    public double payment(ProductRequest productRequest) {
        double totalPayment = items
                .stream()
                .filter(item ->
                        productRequest.getPurchasedItems()
                        .stream()
                                .anyMatch(purchasedItem-> purchasedItem == item.getId()))
                .collect(Collectors.toList())
                .stream()
                .mapToDouble(Item::getPrice).sum();
        double changeReturned = productRequest.getAmountPaid() - totalPayment;
        return changeReturned;
    }
}
