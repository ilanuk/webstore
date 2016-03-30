package com.packt.webstore.domain;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartTest {

	private Cart cart;

	@Before
	public void setup() {
		cart = new Cart();
	}

	@Test
	public void testGetGrandTotal_addCartItem() {
		// Arrange
		CartItem cartItem1 = new CartItem();
	    Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
	    cartItem1.setProduct(iphone);
	    cart.addCartItem(cartItem1);
		CartItem cartItem2 = new CartItem();
	    Product ipad = new Product("P1235","iPad 2", new BigDecimal(300));
	    cartItem2.setProduct(ipad);
	    cart.addCartItem(cartItem2);
	    
	    //Act
	    BigDecimal grandTotal = cart.getGrandTotal();
	    
	    //Assert
	    Assert.assertEquals(grandTotal, cartItem1.getTotalPrice().add(cartItem2.getTotalPrice()));
	    
	}

	@Test
	public void testGetGrandTotal_removeCartItem() {
		// Arrange
		CartItem cartItem1 = new CartItem();
	    Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
	    cartItem1.setProduct(iphone);
	    cart.addCartItem(cartItem1);
		CartItem cartItem2 = new CartItem();
	    Product iphone1 = new Product("P1234","iPhone 5s", new BigDecimal(500));
	    cartItem2.setProduct(iphone);
	    cart.removeCartItem(cartItem2);
	    
	    //Act
	    BigDecimal grandTotal = cart.getGrandTotal();
	    
	    //Assert
	    Assert.assertEquals(grandTotal, cartItem1.getTotalPrice().subtract(cartItem2.getTotalPrice()));
	    
	}
}
