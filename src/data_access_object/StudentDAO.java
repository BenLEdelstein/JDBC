package data_access_object;

import java.util.ArrayList;
import connection.OracleConnection;
import transfer_object.Course;
import transfer_object.Student;

public class StudentDAO extends OracleConnection {
	public void registerStudentToCourse(Course c, Student s) throws Exception {
		dbConnection();
		//get current count of attending records
		ps = con.prepareStatement(resource.myQuries.getAllAttending);
		rs = ps.executeQuery();
		int attending_id = 0;
		while(rs.next())
			attending_id++;
		int	course_id = c.getId(),
				student_id = s.getId();
		ps = con.prepareStatement(resource.myQuries.registerStudentToCourse);
		ps.setInt(1, ++attending_id);
		ps.setInt(2, course_id);
		ps.setInt(3, student_id);
		ps.executeUpdate();
	}
	
	public ArrayList<Course> getAllCoursesForStudent(Student s) throws Exception {
		ArrayList<Course> courses = new ArrayList<Course>();
		dbConnection();
		ps = con.prepareStatement(resource.myQuries.getAllStudentCoursesById);
		ps.setInt(1, s.getId());
		rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("course_id");
			String name = rs.getString("course_name");
			double min_gpa = rs.getDouble("minimum_gpa");
			courses.add(new Course(id, name, min_gpa));
		}
		return courses;
	}
	
	public void insertStudent(Student s) throws Exception {
		dbConnection();
		ps = con.prepareStatement(resource.myQuries.insertStudent);
		ps.setInt(1, s.getId());
		ps.setString(2, s.getName());
		ps.setString(3, s.getEmail());
		ps.setDouble(4, s.getGpa());
		ps.setString(5, s.getPassword());
		ps.setInt(6, s.getRole());
		
		ps.executeUpdate();
	}
	
	public Student getStudentById(int id) throws Exception {
		dbConnection();
		ps = con.prepareStatement(resource.myQuries.getStudentById);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		rs.next();
		Student s = new Student(id, rs.getString("full_name"), rs.getString("email"), rs.getDouble("gpa"), rs.getString("pass"), rs.getInt("student_role"));
		return s;
	}
}
