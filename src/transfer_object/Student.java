package transfer_object;

public class Student {
	private int id, role;
	private String name, email, password;
	private double gpa;
	
	public Student(int id, String name, String email, double gpa, String password, int role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.gpa = gpa;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Id: "+id+", Name: "+name+", E-mail: "+email+", GPA: "+gpa
				+", Password: "+password+", Role: "+role+"]";
	}
	
}
