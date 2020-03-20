package com.mindtree.comicapp.client;

import java.util.Scanner;
import java.util.Set;

import com.mindtree.comicapp.entity.SuperHero;
import com.mindtree.comicapp.entity.Univers;
import com.mindtree.comicapp.exception.service.ComicAppServiceException;
import com.mindtree.comicapp.service.ComicAppService;
import com.mindtree.comicapp.service.serivceimplementation.ComicAppServiceImpl;

public class DriverClass {

	public static void main(String[] args) {
		ComicAppService comicAppService = new ComicAppServiceImpl();

		Scanner sc = new Scanner(System.in);
		boolean flag = true;

		do {
			System.out.println("************|| COMIC APP ||*************");
			System.out.println("1.	Add Univers");
			System.out.println("2.	Add Super hero");
			System.out.println("3.	Assign Super hero to univers.");
			System.out.println("4.	Display Super hero of given Univers");
			System.out.println("5.	Update HP of Given Super Hero.");
			System.out.println("6.	Get Super hero with max HP given Univers name.");
			System.out.println("7.	Exit.");
			System.out.println("Enter the choice:");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				sc.nextLine();
				System.out.println("Enter the Univers Name:");
				String universName = sc.nextLine();

				Univers univers = new Univers(0, universName, null);

				try {
					String mString = comicAppService.addUnivers(univers);
					System.out.println(mString);
				} catch (ComicAppServiceException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 2:
				sc.nextLine();
				System.out.println("Enter the Super Hero Name:");
				String superHeroName = sc.nextLine();

				System.out.println("Enter the HP of Super Hero:");
				long hp = sc.nextLong();

				SuperHero superHero = new SuperHero(0, superHeroName, hp);

				try {
					String mString = comicAppService.addSuperHero(superHero);
					System.out.println(mString);
				} catch (ComicAppServiceException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				sc.nextLine();
				System.out.println("Enter the Super Hero Name:");
				String spName = sc.nextLine();
				System.out.println("Enter the Univers Id to assign the Super Hero:");
				long universId = sc.nextLong();

				try {
					String mString = comicAppService.assignSuperHeroToUnivers(spName, universId);
					System.out.println(mString);
				} catch (ComicAppServiceException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 4:
				sc.nextLine();
				System.out.println("Enter the univers Name: ");
				String universName1 = sc.nextLine();
				try {
					Set<SuperHero> superHeros = comicAppService.displaySuperHeroByUniversName(universName1);
					System.out.println("Univers Name: " + universName1);
					for (SuperHero superHero2 : superHeros) {
						System.out.println(superHero2);
					}
				} catch (ComicAppServiceException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 5:
				sc.nextLine();
				System.out.println("Enter the Super Hero Name:");
				String sname = sc.nextLine();

				System.out.println("Enter the new HP:");
				long hp1 = sc.nextLong();

				try {
					String mString = comicAppService.updateSuperHeroHP(sname, hp1);
					System.out.println(mString);
				} catch (ComicAppServiceException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 6:
				sc.nextLine();
				System.out.println("Enter the univers Name: ");
				String universName2 = sc.nextLine();
				try {
					SuperHero superHeros = comicAppService.displaySuperHeroWithMaxHpByUniversName(universName2);
					System.out.println();
					System.out.println("Univers Name: " + universName2);

					System.out.println("Super hero with max HP:" + superHeros);

				} catch (ComicAppServiceException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 7:
				System.out.println("Thank You !!!");
				flag = false;
				break;

			default:
				System.out.println("Invalid Choice !!!");
				break;
			}

		} while (flag);

	}

}
