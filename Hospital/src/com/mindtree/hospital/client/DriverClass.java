package com.mindtree.hospital.client;

import java.util.Scanner;

import com.mindtree.hospital.entity.Doctor;
import com.mindtree.hospital.service.DoctorServiceImpl;
import com.mindtree.hospital.service.IDoctor;

public class DriverClass {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//System.out.println("Enter the size");
		//int n = sc.nextInt();
		IDoctor service = new DoctorServiceImpl();
		boolean flag = true;

		System.out.println("Enter Number Of Doctors");
		int size = sc.nextInt();
		service.setSize(size);

		do {

			System.out.println("\n\n1. creating n doctors");
			System.out.println("2.display all doctors");
			System.out.println("3.display doctor as per specialization");
			System.out.println("4.sort all doctors as per specialization");

			System.out.println("5.Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				for (int i = 0; i < size; i++) {
					System.out.println("Enter doctor id");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter doctor name");
					String name = sc.nextLine();
					System.out.println("Enter patient count");
					int pcount = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter designation");
					String deg = sc.nextLine();
				doctor[i] = new Doctor(id, name, pcount, deg);

				}
				System.out.println("Doctor added Successfully");

				break;
			}
			case 2: {
				for 
				// service.getDisplay(doctor);
				for (Doctor doctor2 : doctor) {
					System.out.println(doctor2);
				}
				break;
			}
			case 3: {
				Doctor[] d1 = service.displaySpecilazation(doctor);
				for (Doctor doctors : d1) {
					System.out.println(doctors.getSpecilization());
				}
				break;

			}
			case 4: {
				break;
			}
			case 5: {
				flag = false;
				System.out.println("Exit");
				break;
			}
			default: {
				System.err.println("Wrong Choice");
				break;
			}

			}

		} while (flag = true);
	}
}
