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
    public double payment(ProductRequest productRequest) { // remain in parent
        double totalPayment = items
                .stream()
                .filter(item ->
                        productRequest.getPurchasedItems()
                                .stream()
                                .anyMatch(purchasedItem -> purchasedItem == item.getId()))
                .collect(Collectors.toList())
                .stream()
                .mapToDouble(Item::getPrice).sum();

        return productRequest.getAmountPaid() - totalPayment; // access the variable directly - inline temp variable
    }

    @Override
    public void processCheckout(ProductRequest productRequest) { // child
        // step 1
        List<Integer> itemsPurchased = productRequest.getPurchasedItems();

        int count = getItemCount(itemsPurchased);
        // step 3
        double sum = calculateSum(itemsPurchased);
    }


    //TODO: refactor this method , if need be move to a concrete class
    private int getItemCount(List<Integer> itemsPurchased) {
        int count = 0;
        // step 2
        if (!itemsPurchased.isEmpty()) {
            for (Integer _in : itemsPurchased) {
                count += _in;
            }
        }
        return count;
    }

    //TODO: refactor this method  , if need be move to a concrete class
    private void getItemCountVoid(List<Integer> itemsPurchased, int count) {
        // step 2
        if (itemsExist(itemsPurchased) && count == 0) { // inline method
            for (Integer _in : itemsPurchased) {
                count += _in;
            }
        }
    }

    private boolean itemsExist(List<Integer> items) {
        return (!items.isEmpty() && items.get(0) != -1) ? true : false;
    }

    private double calculateSum(List<Integer> itemsPurchased) {
        return itemsPurchased
                .stream()
                .mapToDouble(Integer::intValue)
                .sum();
    }

    private void compute(int productsSold) {
        int products = ProductsGenerator.items().size();
        //int productsSold = 2;

        //int availableProducts = products - productsSold;
        int availableProducts = ProductsGenerator.items().size() - productsSold;

    }
}
