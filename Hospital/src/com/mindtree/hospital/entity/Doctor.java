package com.mindtree.hospital.entity;

public class Doctor {

	private int docid;
	private String docname;
	private int patientcount;
	private String Specilization;
	
	

	public Doctor() {
		super();
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Specilization == null) ? 0 : Specilization.hashCode());
		result = prime * result + docid;
		result = prime * result + ((docname == null) ? 0 : docname.hashCode());
		result = prime * result + patientcount;
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (Specilization == null) {
			if (other.Specilization != null)
				return false;
		} else if (!Specilization.equals(other.Specilization))
			return false;
		if (docid != other.docid)
			return false;
		if (docname == null) {
			if (other.docname != null)
				return false;
		} else if (!docname.equals(other.docname))
			return false;
		if (patientcount != other.patientcount)
			return false;
		return true;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Doctor [docid=" + docid + ", docname=" + docname + ", patientcount=" + patientcount + ", Specilization="
				+ Specilization + "]";
	}



	/**
	 * @return the docid
	 */
	public int getDocid() {
		return docid;
	}



	/**
	 * @param docid the docid to set
	 */
	public void setDocid(int docid) {
		this.docid = docid;
	}



	/**
	 * @return the docname
	 */
	public String getDocname() {
		return docname;
	}



	/**
	 * @param docname the docname to set
	 */
	public void setDocname(String docname) {
		this.docname = docname;
	}



	/**
	 * @return the patientcount
	 */
	public int getPatientcount() {
		return patientcount;
	}



	/**
	 * @param patientcount the patientcount to set
	 */
	public void setPatientcount(int patientcount) {
		this.patientcount = patientcount;
	}



	/**
	 * @return the specilization
	 */
	public String getSpecilization() {
		return Specilization;
	}



	/**
	 * @param specilization the specilization to set
	 */
	public void setSpecilization(String specilization) {
		Specilization = specilization;
	}



	public Doctor(int docid, String docname, int patientcount, String specilization) {
		super();
		this.docid = docid;
		this.docname = docname;
		this.patientcount = patientcount;
		Specilization = specilization;
	}

}
