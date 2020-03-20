package com.mindtree.hospital.service;

import com.mindtree.hospital.entity.Doctor;

public class DoctorServiceImpl implements IDoctor {

	static Doctor doctors[];

	@Override
	public Doctor[] displaySpecilazation(Doctor[] doctor) {
		for (int i = 0; i < doctor.length - 1; i++) {

			for (int j = 0; j < doctor.length - 1 - i; j++) {
				if ((doctor[j].getSpecilization()).compareTo((doctor[j + 1].getSpecilization())) > 0) {
					Doctor temp = doctor[j];
					doctor[j] = doctor[j + 1];
					doctor[j + 1] = temp;
				}
			}
		}
		return doctor;
	}

	public void setSize(int n) {
		doctors = new Doctor[n];
	}

	/*
	 * @Override public Doctor[] getDisplay(Doctor[] doctor) { for (Doctor doctor2 :
	 * doctor) { //System.out.println(doctor2); } return doctor; }
	 * 
	 */

}
