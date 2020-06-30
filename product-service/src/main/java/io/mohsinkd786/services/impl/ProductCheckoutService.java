package io.mohsinkd786.services.impl;

import io.mohsinkd786.dtos.ProductRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductCheckoutService extends ProductServiceImpl{

    @Override
    public void processCheckout(ProductRequest productRequest) { // child
        // step 1
        List<Integer> itemsPurchased = productRequest.getPurchasedItems();
        // step 2
        int count = getItemCount(itemsPurchased);
        // step 3
        double sum = calculateSum(itemsPurchased);
    }

    //TODO: refactor this method , if need be move to a concrete class
    private int getItemCount(List<Integer> itemsPurchased) {
        int count = 0;
        // step 2
        if (!itemsPurchased.isEmpty()) {
            count = countItemsPurchased(itemsPurchased, count);
        }
        return count;
    }

    //TODO: refactor this method  , if need be move to a concrete class
    private void getItemCountVoid(List<Integer> itemsPurchased, int count) {
        // step 2
        if (itemsExist(itemsPurchased) && count == 0) { // inline method
            count = countItemsPurchased(itemsPurchased, count);
        }
    }

    private int countItemsPurchased(List<Integer> itemsPurchased, int count) {
        for (Integer _in : itemsPurchased) {
            count += _in;
        }
        return count;
    }

    private boolean itemsExist(List<Integer> items) {
        return !items.isEmpty() && items.get(0) != -1;
    }

    private double calculateSum(List<Integer> itemsPurchased) {
        return itemsPurchased
                .stream()
                .mapToDouble(Integer::intValue)
                .sum();
    }

}
