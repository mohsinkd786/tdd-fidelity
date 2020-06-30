package io.mohsinkd786.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private int id;
    private String name;
    private static double price;

    public Item(int i, String iPhone, int i1) {
    }

    public Integer getId() {
        return id;
    }


    public static double getPrice(Item item) {
        return price;
    }
}
