package io.mohsinkd786.products;

import io.mohsinkd786.dtos.Product;

public interface ProductSerivce {
	
	/**
	 * @param product
	 * @return product
	 */
    boolean addproduct(Product product);
    
    /**
	 * @param product
	 * @return product
	 */
    boolean removeproduct(Product product);


    

}
