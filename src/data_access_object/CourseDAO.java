package data_access_object;

import java.util.ArrayList;

import connection.OracleConnection;
import transfer_object.Course;

public class CourseDAO extends OracleConnection {
	public ArrayList<Course> getAllAvailableCourses() throws Exception {
		ArrayList<Course> courses = new ArrayList<Course>();
		dbConnection();
		ps = con.prepareStatement(resource.myQuries.getAllAvailableCourses);
		rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("course_id");
			String name = rs.getString("course_name");
			double min_gpa = rs.getDouble("minimum_gpa");
			courses.add(new Course(id, name, min_gpa));
		}
		return courses;
	}
	
	public void insertCourse(Course c) throws Exception {
		dbConnection();
		ps = con.prepareStatement(resource.myQuries.insertCourse);
		ps.setInt(1, c.getId());
		ps.setString(2, c.getName());
		ps.setDouble(3, c.getMin_gpa());

		ps.executeUpdate();
	}
	
	public Course getCourseById(int id) throws Exception {
		dbConnection();
		ps = con.prepareStatement(resource.myQuries.getCourseById);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		rs.next();
		Course c = new Course(id, rs.getString("course_name"), rs.getDouble("minimum_gpa"));
		return c;
	}
}
