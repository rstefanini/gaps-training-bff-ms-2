package application;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import application.model.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes=io.swagger.Swagger2SpringBoot.class)
public class ProductApiControllerTest {

    @Autowired
    private ProductApiController apiController;

    private ProductApiBinding productApiBinding = mock(ProductApiBinding.class);

    @Test
    public void getProductNotNull() {
        Product p = new Product().identifier(1L).name("churro");
        ApiResponseMessage<Product> apiResponseMessage = new ApiResponseMessage<>(HttpStatus.OK, "OK", p);
        try {
            when(productApiBinding.get(1L)).thenReturn(apiResponseMessage);
            ResponseEntity<Product> result = apiController.get(1L, "application/json");
            assertNotNull(result.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Result should not be null!");
        }
    }

}
