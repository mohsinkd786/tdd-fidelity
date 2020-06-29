package io.mohsinkd786.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductRequest implements Serializable {
    List<Integer> purchasedItems;
    double amountPaid;
}
