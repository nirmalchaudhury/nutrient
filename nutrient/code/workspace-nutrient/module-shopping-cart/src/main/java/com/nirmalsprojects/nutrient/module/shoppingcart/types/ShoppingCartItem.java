package com.nirmalsprojects.nutrient.module.shoppingcart.types;

public class ShoppingCartItem {
	
	public int userId;
	
	public String itemName;
	
	public int quantity;

	public ShoppingCartItem(int userId, String itemName, int quantity) {
		this.userId = userId;
		this.itemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
		this.quantity = quantity;
	}
	
	public ShoppingCartItem(ShoppingCartItem item) {
		userId = item.userId;
		itemName = item.itemName.substring(0, 1).toUpperCase() + item.itemName.substring(1);
		quantity = item.quantity;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "userId:" + userId + "," + "itemName:" + itemName + "," + "quantity:" + quantity;
	}

}
