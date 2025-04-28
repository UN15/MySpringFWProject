package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	@Autowired
	private ShoppingCart cart;
	
	@Autowired
	private OrderService service;
	
	@Test
	void testShoppingCart() {
		assertNotNull(cart);
		System.out.println("testShoppingCart Test");
		assertEquals(2, cart.getProducts().size());
		/*
		 * cart.getProducts() =>List<Product>
		 * cart.getProducts().get(0) => Product
		 * cart.getProducts().get(0).getName() => String
		 */
		assertEquals(8000, cart.getTotalPrice());
		assertEquals("Apple",cart.getProducts().get(0).getName());
		System.out.println(cart.toString());
	}
	
	@Test
	void testOrderService() {
		assertNotNull(service);
		//service.getShoppingCart() => ShoppingCart
		System.out.println("testOrderService Test");
		assertEquals(8000, service.calculateOrderTotal());
		System.out.println(service.toString());
		for(Product product: service.getShoppingCart().getProducts()) {
			System.out.println(product);
		}
	}
}
