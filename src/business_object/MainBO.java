package business_object;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import data_access_object.*;
import transfer_object.*;

public class MainBO {

	public static void main(String[] args) throws Exception {

//		 * Create 2 new students,
		StudentDAO sd = new StudentDAO();
		sd.insertStudent(new Student(4, "Jim",
				"Jim@gmail.com", 3.2, "123", -1));
		sd.insertStudent(new Student(5, "Bo",
				"Bo@gmail.com", 3.9, "456", -1));
		System.out.println("Created 2 students");
//		 * create 3 new courses,
		CourseDAO cd = new CourseDAO();
		cd.insertCourse(new Course(5, "Chemistry", 3.0));
		cd.insertCourse(new Course(6, "Applied Physics", 3.0));
		cd.insertCourse(new Course(7, "Applied Mathematics for Engineering", 3.5));
		System.out.println("Created 3 courses");
//		 * register students to courses so that every student are registered to at least 2 courses,
		
		//fetch all students
		ArrayList<Student> sa = new ArrayList<Student>();
		int id = 1;
		while(true) {
			try {
			sa.add(sd.getStudentById(id++));
			}
			catch(SQLException e) {
				break;
			}
		}
		//fetch all courses
		ArrayList<Course> ca = cd.getAllAvailableCourses();
		Random r = new Random();
		int r_course_max = ca.size();
		//register them to **random** classes
		for(Student s:sa) {
			//find out how many courses student is registered to
			while(sd.getAllCoursesForStudent(s).size()<2) {
				sd.registerStudentToCourse(cd.getCourseById(r.nextInt(r_course_max)+1), s);
			}
		}
		System.out.println("All students registered to 2 courses");
//		 * retrieve all the courses related to a particular student, 
		int r_student_max = sa.size();
		Student s = sd.getStudentById(r.nextInt(r_student_max)+1);
		ca = sd.getAllCoursesForStudent(s);
		System.out.println("Courses for "+s.getName()+": "+ca);
		
//		 * and display all unique courses that are in the system.
		ca = cd.getAllAvailableCourses();
		System.out.println("All Unique Courses: "+ca);
		
	}

}
