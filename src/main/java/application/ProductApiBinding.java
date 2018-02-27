package application;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

//this is the class that binds to selected services
import application.model.Product;


@Component
public class ProductApiBinding  {

  public ApiResponseMessage<Product> delete(Long productID) {
      return new ApiResponseMessage<>(HttpStatus.INTERNAL_SERVER_ERROR, "not yet implemented", null);
  }
  public ApiResponseMessage<Product> get(Long productID) {
	  
	  Product product =null;

	  if(productID==1)
	  {
		  product = new Product();
		  product.setIdentifier(productID);
		  product.setName("Load Factor Based Upgrades");
	  }
      return new ApiResponseMessage<>(HttpStatus.OK, "ok", product);
  }
  public ApiResponseMessage<Product> update(Long productID, String productName) {
      return new ApiResponseMessage<>(HttpStatus.NOT_FOUND, "", null);
  }
}

