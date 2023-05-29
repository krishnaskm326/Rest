package PojoClass;

public class Employee {

	String emp_Name;
	String emp_Id;
	String emp_Mail;
	long emp_phone;
	public Employee(String emp_Name,String emp_Id,String emp_Mail,long emp_phone) {
		
		this.emp_Name=emp_Name;
		this.emp_Id=emp_Id;
		this.emp_Mail=emp_Mail;
		this.emp_phone=emp_phone;
	}
	public Employee() {
		
	}
	public String getEmp_Name() {
		return emp_Name;
	}
	public String getEmp_Id() {
		return emp_Id;
	}
	public String getEmp_Mail() {
		return emp_Mail;
	}
	public long getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}
	public void setEmp_Id(String emp_Id) {
		this.emp_Id = emp_Id;
	}
	public void setEmp_Mail(String emp_Mail) {
		this.emp_Mail = emp_Mail;
	}
	public void setEmp_phone(long emp_phone) {
		this.emp_phone = emp_phone;
	}
	

	}


