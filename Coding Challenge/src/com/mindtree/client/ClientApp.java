package com.mindtree.client;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.mindtree.entity.Laptop;
import com.mindtree.service.serviceimpl.PriceComparator;
import com.mindtree.service.serviceimpl.Service2;

public class ClientApp {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Laptop> laptop = new ArrayList<Laptop>();
		List<Laptop> laptop1 = new ArrayList<Laptop>();

		int flag = 1;
		Service2 service = new Service2();
		do {
			try {
				System.out.println("enter one choice");
				System.out.println(
						"1.Add laptop\n2.Laptops based on price\n3.Laptops of particular model\n4.diplay the brands having more than 3 laptops\n5.File writing\n6.Exit");
				int choice = in.nextInt();
				in.nextLine();
				switch (choice) {
				case 1:
					System.out.println("Enter the brand of laptop");
					String brand = in.nextLine();
					System.out.println("enter the model of the laptop");
					String model = in.nextLine();
					System.out.println("enter price of the laptop");
					double price = in.nextDouble();
					System.out.println("enter the id of the laptop");
					int id = in.nextInt();
					in.nextLine();
					try {
						laptop.add(service.addLaptop(laptop, id, price, model, brand));
						System.out.println(laptop.toString());
					} catch (Exception e) {
						System.out.println(e);
					}
					break;

				case 2:
					Comparator<Laptop> cm1 = Comparator.comparing(Laptop::getPrice);
					Collections.sort(laptop, new PriceComparator());
					for (Laptop p : laptop) {
						System.out.println(p.toString());
					}
					break;
				case 4:

					List<String> brands = new ArrayList<String>();
					brands = service.displayBrands(laptop);
					System.out.println(brands.toString());
					break;
				case 3:
					System.out.println("enter the model");
					String model1 = in.nextLine();
					try {
						List<Laptop> laptop2 = service.addLaptop1(laptop, model1);
						System.out.println(laptop2.toString());
					}

					catch (Exception e) {
						System.out.println(e);
					}
					break;
				case 5:
					FileWriter fileWriter = new FileWriter("output1.txt");
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					for (Laptop f : laptop) {
						bufferedWriter.write(f.toString());
						bufferedWriter.newLine();
					}
					System.out.println("done");
					bufferedWriter.close();

				}
			} catch (Exception e) {
				System.out.println("OOPs invalid input");
				in.nextLine();
			}
		} while (flag != 0);
	}
}
