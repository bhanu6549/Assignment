
public class Doctor {
private int doctorId;
private String doctorName;
private double salary;
public Doctor(String doctorName2) {
	super();
	this.doctorName=doctorName2;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", salary=" + salary + "]";
}
/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + doctorId;
	result = prime * result + ((doctorName == null) ? 0 : doctorName.hashCode());
	long temp;
	temp = Double.doubleToLongBits(salary);
	result = prime * result + (int) (temp ^ (temp >>> 32));
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
	if (doctorId != other.doctorId)
		return false;
	if (doctorName == null) {
		if (other.doctorName != null)
			return false;
	} else if (!doctorName.equals(other.doctorName))
		return false;
	if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
		return false;
	return true;
}
/**
 * @return the doctorId
 */
public int getDoctorId() {
	return doctorId;
}
/**
 * @param doctorId the doctorId to set
 */
public void setDoctorId(int doctorId) {
	this.doctorId = doctorId;
}
/**
 * @return the doctorName
 */
public String getDoctorName() {
	return doctorName;
}
/**
 * @param doctorName the doctorName to set
 */
public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}
/**
 * @return the salary
 */
public double getSalary() {
	return salary;
}
/**
 * @param salary the salary to set
 */
public void setSalary(double salary) {
	this.salary = salary;
}
public Doctor(int doctorId, String doctorName, double salary) {
	super();
	this.doctorId = doctorId;
	this.doctorName = doctorName;
	this.salary = salary;
}
public Doctor(int id) {
	super();
	this.doctorId=id;
}

}
