package application;

//this is the class that binds to selected services
import application.model.Product;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ProductApiBinding {

    public ApiResponseMessage<Product> delete(Long productID) {
        return new ApiResponseMessage<>(HttpStatus.INTERNAL_SERVER_ERROR, "not yet implemented", null);
    }

    public ApiResponseMessage<Product> get(Long productID) {
        Product p = new Product();
        p.setIdentifier(1L);
        p.setName("First Product");
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
