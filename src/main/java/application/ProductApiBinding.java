package application;

//this is the class that binds to selected services
import application.model.Product;
import src.main.java.infrastructure.service.IBMProductImpl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ProductApiBinding {

    public ApiResponseMessage<Product> delete(Long productID) {
        return new ApiResponseMessage<>(HttpStatus.INTERNAL_SERVER_ERROR, "not yet implemented", null);
    }

    public ApiResponseMessage<Product> get(Long productID) {

        IBMProductImpl p = new IBMProductImpl();
        Product result = p.getProduct(productID);

        if (result == null)
            return new ApiResponseMessage<>(HttpStatus.NOT_FOUND, "Product Not Found", null);

        return new ApiResponseMessage<>(HttpStatus.OK, result.getName(), result);
    }

    public ApiResponseMessage<Product> update(Long productID, String productName) {
        return new ApiResponseMessage<>(HttpStatus.NOT_FOUND, "", null);
    }
}
