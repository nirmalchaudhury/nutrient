package com.nirmalsprojects.nutrient.modulelisteners.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.junit.Test;

import com.nirmalsprojects.nutrient.modulelisteners.KitchenListener;
import com.nirmalsprojects.nutrient.types.UserItem;

public class KitchenListenerGivenNewInstance {
	
	int newItemPeriodicityMin = 2;

	@Test
	public void returnEstimatedPurchaseTimeGivenItemAddedPeriodically() {
		ArrayList<UserItem> itemHistory = createItemHistory();
		long calculatePurchaseDate = KitchenListener.calculatePurchaseTimeRemaining(itemHistory);
		long expectedPurcahseDateMs = (newItemPeriodicityMin*60)*1000;
		assertEquals(calculatePurchaseDate, expectedPurcahseDateMs);
	}
	
	@Test
	public void returnEstimatedPurchaseDateGivenItemAddedPeriodically() {
		ArrayList<UserItem> itemHistory = createItemHistory();
		for (UserItem item : itemHistory) {
			System.out.println(item.dateAdded);
		}
		DateTime calculatePurchaseDate = KitchenListener.calculateNextPurchaseDate(itemHistory);
		System.out.println("Next Purchase Date: " + calculatePurchaseDate);
	}
	
	@Test
	public void returnEstimatedPurchaseTimeGivenItemAddedNonPeriodically() {
		ArrayList<UserItem> itemHistory = createItemHistoryWithNonConsistantItemAddedTime();
		for (UserItem item : itemHistory) {
			System.out.println(item.dateAdded);
		}
		long calculatePurchaseDate = KitchenListener.calculatePurchaseTimeRemaining(itemHistory);
		long expectedPurchaseTimeRemaining = 150000;
		assertEquals(calculatePurchaseDate, expectedPurchaseTimeRemaining);
	}
	
	private ArrayList<UserItem> createItemHistory() {
		int USER_ID = 1;
		String ITEM_NAME = "Apple";
		int QUANTITY = 2;
		DateTime nextItemAddedTime = new DateTime();
		
		ArrayList<UserItem> itemHistory = new ArrayList<UserItem>();
		int itemHistorySize = 5;
		for (int i=0; i<itemHistorySize; i++) {
			itemHistory.add(new UserItem(USER_ID, ITEM_NAME, QUANTITY, nextItemAddedTime));
			nextItemAddedTime = nextItemAddedTime.plusMinutes(newItemPeriodicityMin);
		}
		
		return itemHistory;
	}
	
	private ArrayList<UserItem> createItemHistoryWithNonConsistantItemAddedTime() {
		int USER_ID = 1;
		String ITEM_NAME = "Apple";
		int QUANTITY = 2;
		DateTime nextItemAddedTime = new DateTime();
		int addedMinutes = 0;
		ArrayList<UserItem> itemHistory = new ArrayList<UserItem>();
		int itemHistorySize = 5;
		for (int i=0; i<itemHistorySize; i++) {
			nextItemAddedTime = nextItemAddedTime.plusMinutes(addedMinutes);
			itemHistory.add(new UserItem(USER_ID, ITEM_NAME, QUANTITY, nextItemAddedTime));
			addedMinutes++;
		}
		return itemHistory;
		
	}

}
