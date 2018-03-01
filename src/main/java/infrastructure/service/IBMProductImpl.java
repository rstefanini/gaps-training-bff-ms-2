package infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import application.model.IBMProduct;
import application.model.Product;


@Configuration
public class IBMProductImpl implements IBMProduct {    
    
    private String ibmEndpoint = "https://93fbc6fb-4202-4913-8666-fb7fed1ab335-bluemix.cloudant.com/product/1";

    public Product getProduct(Long productID) {
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(ibmEndpoint, Product.class);
        return product;
    }
}
