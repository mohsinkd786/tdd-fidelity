package io.mohskinkd786.products;

import io.mohsinkd786.dtos.Product;

public interface ProductSerivce {
	
	/**
	 * @param product
	 * @return product
	 */
    Product addproduct(Product product);
    
    /**
	 * @param product
	 * @return product
	 */
    Product removeproduct(Product product);
    

}
