package service;

import entity.*;

public class Service {
	public static Furniture[] insertionSort(Furniture[] furniture) {
		int n = furniture.length;
		for (int j = 1; j < n; j++) {
			Furniture key = furniture[j];
			int i = j - 1;
			while ((i > -1) && (furniture[i].getCost() < key.getCost())) {
				furniture[i + 1] = furniture[i];
				i--;
			}
			furniture[i + 1] = key;
		}
		return furniture;
	}

	public static void display(Furniture[] furniture) {
		for (int i = 0; i < furniture.length; i++) {
			System.out.println("Furniture name: " + furniture[i].getName());
			System.out.println("Furniture cost: " + furniture[i].getCost());
			System.out.println("Furniture quantity " + furniture[i].getQuantity());
			System.out.println("Furniture id: " + furniture[i].getId());
			System.out.println("--------");
		}
	}

	public static Furniture[] bubbleSort(Furniture[] furniture) {
		for (int i = 0; i < furniture.length; i++) {
			for (int j = 0; j < furniture.length; j++) {
				if (furniture[i].getId() < furniture[j].getId()) {
					Furniture temp = furniture[i];
					furniture[i] = furniture[j];
					furniture[j] = temp;
				}
			}
		}
		return furniture;
	}

	public static int binarySearch(Furniture[] furniture, int first, int last, int key) {
		if (first <= last) {
			int mid = (first + last) / 2;
			// System.out.println(mid);
			if (furniture[mid].getId() < key) {
				// System.out.println("1..."+mid);
				first = mid + 1;
				return binarySearch(furniture, first, last, key);
			} else if (furniture[mid].getId() == key) {
				// System.out.println("2...."+mid);
				System.out.println("Element is found at index: " + mid);
				return mid;
			} else {
				last = mid - 1;
				// System.out.println("3...." + last);
				return binarySearch(furniture, first, last, key);
			}

		} else {
			System.out.println("Index out of bound");
			return -1;
		}
	}

	public static String purchase(Furniture[] furniture, int quantity, String name) {
		for (int i = 0; i < furniture.length; i++) {
			if (furniture[i].getName().equals(name)) {
				int diff = (furniture[i].getQuantity()) - quantity;
				// System.out.println(diff);
				if (diff >= 0) {
					// int diff = furniture[i].getQuantity() - quantity;
					furniture[i].setQuantity(diff);
					System.out.println("The bill amount is: " + (furniture[i].getCost() * quantity));
					System.out.println("total pieces left: " + furniture[i].getQuantity());
					System.out.println("------");
					return furniture[i].toString();

				} else if (furniture[i].getQuantity() < quantity) {
					System.out.println("we do not have sufficient quantity");
				}
			}

		}
		return "No such furniture in store";
	}
}
