package application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes=io.swagger.Swagger2SpringBoot.class)
public class ProductApiBindingTest {

	@Autowired
	ProductApiBinding productApiBinding;
	
	
	@Test
	public final void productShouldNotBeNull(){
	assertNotNull(productApiBinding.get(1L));
	}
	
	@Test
	public final void testProductsListShouldNotBeNull() {
	assertNotNull(productApiBinding.get(1L)); 
	}
	
	@Test
	public final void testProductnameShouldBeLFBU() {
	assertEquals("Load Factor Based Upgrades", productApiBinding.get(1L).getData().getName()); 
	}

	@Test
	public final void testTwoProductsNamesShouldNotMatch() {
	assertEquals("Load Factor Based Upgrades", productApiBinding.get(2L).getData().getName()); 
	}
}
