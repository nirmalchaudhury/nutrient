//package com.nirmalsprojects.nutrient.test.shoppingcart;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.nirmalsprojects.nutrient.dataaccess.shoppingcart.IShoppingCartDataAccess;
//import com.nirmalsprojects.nutrient.dataaccess.shoppingcart.ShoppingCartDataAccess;
//import com.nirmalsprojects.nutrient.module.shoppingcart.types.ShoppingCartItem;
//
//public class ShoppingCartDataAccessGivenNewInstance {
//	
//	IShoppingCartDataAccess shoppingCartDataAccess;
//	
//	@Before
//	public void onStart() {
//		shoppingCartDataAccess = new ShoppingCartDataAccess();
//	}
//	
//	@Test
//	public void AddNewItemGivenNewItem() {
//		ShoppingCartItem item = new ShoppingCartItem(1, Apple, 2);
//		shoppingCartDataAccess.addItem(item);
//		
//	}
//
//}
