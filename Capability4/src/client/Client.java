package client;

import java.util.Scanner;

import entity.Furniture;
import service.Service;

public class Client {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Furniture[] furniture = null;
		Furniture[] furniture2 = null;
		int flag = 1;
		do {
			System.out.println("enter one choice");
			System.out.println("1.Add furniture.\n2.Insertion sort by cost\n3.Purchase\n4.binary search\n5.exit");
			int choice = in.nextInt();
			switch (choice) {

			case 1:
				System.out.println("enter no of furnitures to be added");
				int no = in.nextInt();
				furniture = new Furniture[no];
				in.nextLine();
				for (int i = 0; i < no; i++) {
					System.out.println("enter details for " + (i + 1) + " furniture");
					System.out.println("enter furniture name");
					String name = in.nextLine();
					System.out.println("enter furniture cost");
					double cost = in.nextDouble();
					System.out.println("enter quantity");
					int quantity = in.nextInt();
					System.out.println("enter id");
					int id = in.nextInt();
					furniture[i] = new Furniture(name, cost, quantity, id);
					in.nextLine();
				}
				for (int i = 0; i < furniture.length; i++) {
					System.out.println("Furniture name: " + furniture[i].getName());
					System.out.println("Furniture cost: " + furniture[i].getCost());
					System.out.println("Furniture quantity " + furniture[i].getQuantity());
					System.out.println("Furniture id: " + furniture[i].getId());
					System.out.println("--------");
				}
				break;
			case 2:
				furniture2 = furniture;
				Service.insertionSort(furniture2);
				Service.display(furniture2);
				break;
			case 3:
				in.nextLine();
				System.out.println("enter the furniture name");
				String name = in.nextLine();
				System.out.println("enter the quantity required");
				int quantity = in.nextInt();
				Service.purchase(furniture, quantity, name);
				Service.display(furniture);
				break;
			case 4:
				furniture2 = furniture;
				Service.bubbleSort(furniture2);
				Service.display(furniture2);
				System.out.println("enter the id to search");
				int id = in.nextInt();
				Service.binarySearch(furniture2, 0, furniture2.length, id);
				break;
			case 5:
				flag=0;
			}
		} while (flag != 0);
	}
}
