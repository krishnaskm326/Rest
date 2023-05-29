package PojoClass;

public class EmployeeArray {

	String emp_Name;
	long []phNo;
	public EmployeeArray(String emp_Name, long[] phNo) {
		
		this.emp_Name = emp_Name;
		this.phNo = phNo;
	}
	public String getEmp_Name() {
		return emp_Name;
	}
	public long[] getPhNo() {
		return phNo;
	}
	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}
	public void setPhNo(long[] phNo) {
		this.phNo = phNo;
	}
	
	public EmployeeArray() {
		
	}
}
