package co.edu.collect;

public class Employees {
	int empId;
	String empName;
	int salary;
	public Employees(int empId, String empName, int salary){
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}
	
}
