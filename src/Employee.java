import java.time.LocalDate;

public class Employee {
	
	private String employeeName;
	private long salary;
	private LocalDate birthday;
	
	static int pensionRemainingAge = 65;
	static LocalDate currentDate = LocalDate.now();

///////////////////////////////////////////////////////////////////////////////

	public Employee(String name, LocalDate birthday, long salary) {
		employeeName = name;
		this.birthday = birthday;
		this.salary = salary;
	}
	
	public Employee(String name, LocalDate birthday) {
		this(name, birthday, ((currentDate.getYear() - birthday.getYear())*10000));
	}
	
///////////////////////////////////////////////////////////////////////////////
	public int getRemainingYearsUntilPansion() {
		return (pensionRemainingAge - getAge());
	}
	
	public String toString() {
		return ("Name: " + this.employeeName + "\n\tAge: "+  getAge() + "\n\tRemaining age: "
				+ getRemainingYearsUntilPansion() + "\n\tSalary: "+ this.salary);
	}
	
	public static Employee getYoungerEmployeeName(Employee a, Employee b) {
		if(a.getRemainingYearsUntilPansion() > b.getRemainingYearsUntilPansion())
			return a;
		
		return b;
	}
	
	public int getAge() {
		return (currentDate.getYear() - birthday.getYear());
	}
	
//////////////////////////////////////////////////////////////////////////////	
	
///////////////////////////////////////////////////////////////////////////////
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	public long getPensionRemainingAge() {
		return pensionRemainingAge;
	}

	public void setPensionRemainingAge(int newAge) {
		this.pensionRemainingAge = newAge;
	}
///////////////////////////////////////////////////////////////////////////////	
	public boolean isInSalaryRange(long salaryStart, long salaryEnd) {
		if(this.salary >= salaryStart && this.salary < salaryEnd)
			return true;
		else return false;
	}
	
	public long getTax() {
		return (long)(this.salary*0.16);
	}
	
	public boolean hasHigherSalary(Employee employee) {
		if(this.salary > employee.getSalary())
			return true;
		else return false;
	}
}
