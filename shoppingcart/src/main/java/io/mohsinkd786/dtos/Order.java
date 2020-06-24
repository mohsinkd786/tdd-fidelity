package io.mohsinkd786.dtos;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<Item> items;

    private int id;

    private boolean status;

    private int quantity;

    private double totalPrice;

    private String paymentMode;

    public Order(){
        items= new ArrayList<Item>();
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        if (items.contains(item)){
            items.remove(item);
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
