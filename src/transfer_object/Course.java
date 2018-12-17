package transfer_object;

public class Course {
	private int id;
	private String name;
	private double min_gpa;
	
	public Course(int id, String name, double min_gpa) {
		this.id = id;
		this.name = name;
		this.min_gpa = min_gpa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMin_gpa() {
		return min_gpa;
	}
	public void setMin_gpa(double min_gpa) {
		this.min_gpa = min_gpa;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Id: "+id+", Name: "+name+", Minimum GPA: "+min_gpa+"]";
	}
	
}
