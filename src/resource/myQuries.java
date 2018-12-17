package resource;

public class myQuries {
	public final static String insertStudent = "insert into student values (?, ?, ?, ?, ?, ?)";
	public final static String getStudentById = "select * from student where student_id = ?";
	public final static String getAllStudentCoursesById = "select * from attending join course"
			+ " using (course_id) where attending.student_id = ?";
	public final static String getAllAttending = "select * from attending";
	public final static String registerStudentToCourse = "insert into attending values (?, ?, ?)";
	public final static String insertCourse = "insert into course values (?, ?, ?)";
	public final static String getCourseById = "select * from course where course_id = ?";
	public final static String getAllAvailableCourses = "select distinct * from course";
}
