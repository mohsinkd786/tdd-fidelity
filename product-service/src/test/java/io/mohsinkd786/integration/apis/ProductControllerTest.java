package io.mohsinkd786.integration.apis;

import io.mohsinkd786.dtos.ProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.Arrays;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class ProductControllerTest extends IntegrationTestBase {

    @Test
    public void testMakePayment() throws Exception {

        ProductRequest request = new ProductRequest();
        request.setAmountPaid(7100);
        request.setPurchasedItems(Arrays.asList(2, 3));

         mockMvc.perform(post("/products/pay")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(request)))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$", ))
                .andDo(document("product_make_payment"))
                .andReturn();
    }
}
