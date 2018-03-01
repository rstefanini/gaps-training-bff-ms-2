package application;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import application.model.Product;

public class ProductApiBindingTest {

    private ProductApiBinding productBinding = new ProductApiBinding();;
@Ignore
    @Test
    public void testGetProductFound() {
        ApiResponseMessage<Product> response = productBinding.get(1L);
        assertEquals(HttpStatus.OK, response.getCode());
    }
@Ignore
    @Test
    public void testGetProductNotFound() {
        ApiResponseMessage<Product> response = productBinding.get(2L);
        assertEquals(HttpStatus.NOT_FOUND, response.getCode());
    }

}
