import java.util.Scanner;

public class DriverClass {

	static Doctor doctor[] = new Doctor[5];

	public static void main(String[] args) {
		// Doctor d=new Doctor();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		do {
			System.out.println("1. for doctor names");
			System.out.println("2.for sort using names");
			System.out.println("searching using ids");
			System.out.println("4.exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {

				for (int i = 0; i < 5; i++) {
					System.out.println("Enter the id");
					int doctorId = sc.nextInt();

					System.out.println("Enter the names");
					/// sc.nextLine();
					String doctorName = sc.next();
					System.out.println("Enter the salary");
					double salary = sc.nextDouble();
					doctor[i] = new Doctor(doctorId, doctorName, salary);
				}
				for (Doctor doctor2 : doctor) {
					System.out.println(doctor2);
				}

				break;

			}
			case 2: {
				System.out.println("Enter the names");
				for (int i = 0; i < doctor.length; i++) {

					/// sc.nextLine();
					String doctorName2 = sc.next();

					doctor[i] = new Doctor(doctorName2);
				}
				bubbleSort(doctor);

				for (int i = 0; i < doctor.length; i++) {

					System.out.println(doctor[i]);
				}

				break;

			}
			case 3: {
				System.out.println("Enter the id");
				for (int i = 0; i < doctor.length; i++) {
					int id = sc.nextInt();
					doctor[i] = new Doctor(id);
				}
				System.out.println("Enter the key");
				int key = sc.nextInt();
				boolean p = findElement(doctor, key);
				System.out.println(p);
				/*for (int i = 0; i < doctor.length; i++) {

					System.out.println(doctor[i]);
				}
*/
				break;
			}
			case 4: {
				flag = false;
				break;
			}
			default: {
				System.err.println("wrong Choice");
				break;
			}
			}
		} while (flag = true);
	}

	public static void bubbleSort(Doctor[] doctor) {
		for (int i = 0; i < doctor.length - 1; i++) {// 4 iterations

			for (int j = 0; j < doctor.length - 1 - i; j++) {// to sit in the last position
				if ((doctor[j].getDoctorName()).compareTo((doctor[j + 1].getDoctorName())) > 0) {// i constant j is
																									// incremented every
																									// time for rounds
																									// swap
					Doctor temp = doctor[j];
					doctor[j] = doctor[j + 1];
					doctor[j + 1] = temp;
				}
			}
		}
	}

	static boolean findElement(Doctor[] doctor, int key) {

		int low = 0;
		int high = doctor.length - 1;
		while (high >= low) {
			int mid = low + high / 2;
			if (doctor[mid].getDoctorId() == key) {

				return true;

			} else if (doctor[mid].getDoctorId() > key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		return false;
	}

}