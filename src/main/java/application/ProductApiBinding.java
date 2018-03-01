package application;

//this is the class that binds to selected services
import application.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductApiBinding {

    @Autowired
    private PropertiesConfig propertiesConfig;

    public ApiResponseMessage<Product> delete(Long productID) {
        return new ApiResponseMessage<>(HttpStatus.INTERNAL_SERVER_ERROR, "not yet implemented", null);
    }

    public ApiResponseMessage<Product> get(Long productID) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> churro = restTemplate.getForEntity((propertiesConfig.getProductUrl() + productID), Product.class);
        Product p = churro.getBody();
        if (productID == p.getIdentifier()) {
            return new ApiResponseMessage<>(HttpStatus.OK, "OK", p);
        } else {
            return new ApiResponseMessage<>(HttpStatus.NOT_FOUND, "", null);
        }
    }

    public ApiResponseMessage<Product> update(Long productID, String productName) {
        return new ApiResponseMessage<>(HttpStatus.NOT_FOUND, "", null);
    }
}
