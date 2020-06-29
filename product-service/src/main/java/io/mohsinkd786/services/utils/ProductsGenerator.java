package io.mohsinkd786.services.utils;

import io.mohsinkd786.dtos.Item;

import java.util.Arrays;
import java.util.List;

public final class ProductsGenerator {

    public final static List<Item> items(){
        return Arrays.asList(new Item[]{
                new Item(1,"iPhone",49530),
                new Item(4,"iPhone",49530),
                new Item(5,"iPhone",49530),
                new Item(2,"Jacket",3000),
                new Item(3,"Fleece",4000) });
    }
}
