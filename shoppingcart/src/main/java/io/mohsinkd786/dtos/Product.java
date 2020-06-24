package io.mohsinkd786.dtos;

public class Product {
	
	private int id;

    private int quantity;

    private double price;

    private String name;
    
   public Product(int id,int quantity,double price,String name) {
	   this.id=id;
	   this.name=name;
	   this.price=price;
	   this.quantity=quantity;
   }
   public Product() {

   }
    
    public int getId() {
        return id;
    }


    public int getQuantity() {
        return quantity;
    }


    public double getPrice() {
        return price;
    }

    
    public String getName() {
        return name;
    }
    
    
}
