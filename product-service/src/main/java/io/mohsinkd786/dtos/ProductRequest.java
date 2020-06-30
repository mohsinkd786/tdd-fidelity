package io.mohsinkd786.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductRequest implements Serializable {
    List<Integer> purchasedItems;
    double amountPaid;

    public double getAmountPaid() {
        return amountPaid;
    }

    public List<Integer> getPurchasedItems() {
        return purchasedItems;
    }

    public void setAmountPaid(int i) {
    }

    public void setPurchasedItems(List<Integer> asList) {
    }
}
