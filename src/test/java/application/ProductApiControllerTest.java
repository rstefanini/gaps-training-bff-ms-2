package application;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes=io.swagger.Swagger2SpringBoot.class)
public class ProductApiControllerTest {
	
    @Autowired
	private ProductApiController controller;
	
	@Test
	public void getProductShouldNotBeNull() throws Exception
	{
		assertNotNull(controller.get(12312L, "\"application/json\""));
	}
}
