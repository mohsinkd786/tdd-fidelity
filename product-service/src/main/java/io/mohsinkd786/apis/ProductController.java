package io.mohsinkd786.apis;

import io.mohsinkd786.dtos.ProductRequest;
import io.mohsinkd786.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/pay")
    public double makePayment(@RequestBody ProductRequest productRequest) {
        return productService.payment(productRequest);
    }
}
