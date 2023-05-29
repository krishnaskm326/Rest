package PojoClass;

public class Student {

	String std_name;
	String std_dept;
	int age;
	long phNo[];
	String parents[];
	
	public Student(String std_name, String std_dept, int age, long[] phNo, String[] parents) {
		super();
		this.std_name = std_name;
		this.std_dept = std_dept;
		this.age = age;
		this.phNo = phNo;
		this.parents = parents;
	}
//	public Student(String std_name, String std_dept, int age, long[] phNo, String[] parents,long[] p_phNo) {
//		this.std_name = std_name;
//		this.std_dept = std_dept;
//		this.age = age;
//		this.phNo = phNo;
//		this.parents = parents;
//		this.p_phNo = p_phNo;
//	}
	
	
	public String getStd_name() {
		return std_name;
	}
	public String getStd_dept() {
		return std_dept;
	}
	public int getAge() {
		return age;
	}
	public long[] getPhNo() {
		return phNo;
	}
	public String[] getParents() {
		return parents;
	}
	
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public void setStd_dept(String std_dept) {
		this.std_dept = std_dept;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhNo(long[] phNo) {
		this.phNo = phNo;
	}
	public void setParents(String[] parents) {
		this.parents = parents;
	}
	
	
}
