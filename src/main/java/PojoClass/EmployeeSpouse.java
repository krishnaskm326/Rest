package PojoClass;

public class EmployeeSpouse {

	String spouse_Name;
	long []phNo;
	public EmployeeSpouse(String spouse_Name, long[] phNo) {
		super();
		this.spouse_Name = spouse_Name;
		this.phNo = phNo;
	}
	public EmployeeSpouse() {
		
	}
	public String getSpouse_Name() {
		return spouse_Name;
	}
	public long[] getPhNo() {
		return phNo;
	}
	public void setSpouse_Name(String spouse_Name) {
		this.spouse_Name = spouse_Name;
	}
	public void setPhNo(long[] phNo) {
		this.phNo = phNo;
	}
	
}
