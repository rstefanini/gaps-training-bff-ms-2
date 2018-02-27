package application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import application.model.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes=io.swagger.Swagger2SpringBoot.class)
public class ProductApiControllerTest {

    @Autowired
    private ProductApiController apiController;

    @Test
    public void getProductNotNull() {
        try {
            ResponseEntity<Product> result = apiController.get(1L, "application/json");
            assertNotNull(result.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Result should not be null!");
        }
    }

}
