package com.mindtree.client;

import java.util.*;

import com.mindtree.service.Service;
import com.mindtree.service.ServiceImp;

public class Booking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Service serv = new ServiceImp();
		boolean flag = true;
		do {
			System.out.println(
					"choose option \n 1. insert booking portal \n 2. book a movie ticket  \n 3. delete a booking portal \n 4. display in descending order of price \n 5. exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter booking id");
				int portalId = sc.nextInt();
				sc.nextLine();
				System.out.println("enter the booking portal name");
				String portalName = sc.nextLine();
				serv.insert(portalId, portalName);
				break;
			case 2:
				System.out.println("enter movie Id");
				int movieId = sc.nextInt();
				sc.nextLine();
				System.out.println("enter movie name");
				String movieName = sc.nextLine();
				System.out.println("enter the price");
				int price = sc.nextInt();
				sc.nextLine();
				System.out.println("enter the portal name");
				portalName = sc.nextLine();
				System.out.println("enter the portal id");
				portalId = sc.nextInt();
				serv.bookTicket(movieId, movieName, price, portalName, portalId);

				break;
			case 3:
				System.out.println("enter the portal id");
				portalId = sc.nextInt();
				serv.delete(portalId);
				break;
			case 4:
				serv.sort();
				break;
			case 5:
				flag = false;
				break;
			default:
				System.out.println("invalid input");
				break;
			}

		} while (flag);

	}

}
