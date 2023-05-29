package PojoClass;

public class EmployeeComplex {
String emp_Name;
EmployeeSpouse spouse;
public EmployeeComplex(String emp_Name,EmployeeSpouse  spouse) {
	super();
	this.emp_Name = emp_Name;
	this.spouse = spouse;
}
public EmployeeComplex() {
}
public String getEmp_Name() {
	return emp_Name;
}
public EmployeeSpouse getSpouse() {
	return spouse;
}
public void setEmp_Name(String emp_Name) {
	this.emp_Name = emp_Name;
}
public void setSpouse(EmployeeSpouse spouse) {
	this.spouse = spouse;
}

}
