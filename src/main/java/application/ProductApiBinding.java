package application;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

//this is the class that binds to selected services
import application.model.Product;

@Component
public class ProductApiBinding {

	public ApiResponseMessage<Product> delete(Long productID) {
		return new ApiResponseMessage<>(HttpStatus.INTERNAL_SERVER_ERROR, "not yet implemented", null);
	}

	public ApiResponseMessage<Product> get(Long productID) {
		Product product = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			product = restTemplate.getForObject(
					"https://93fbc6fb-4202-4913-8666-fb7fed1ab335-bluemix.cloudant.com/product/{productID}",
					Product.class, productID);
			return new ApiResponseMessage<>(HttpStatus.OK, "", product);
		} catch (RestClientException e) {
			return new ApiResponseMessage<>(HttpStatus.NOT_FOUND, "", null);
		}
	}

	public ApiResponseMessage<Product> update(Long productID, String productName) {
		return new ApiResponseMessage<>(HttpStatus.NOT_FOUND, "", null);
	}
}
