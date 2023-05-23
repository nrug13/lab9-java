import java.util.ArrayList;
import java.util.List;

public class CourseEnrollmentSystem {
    private List<Course> courses;
    private List<Student> students;

    public CourseEnrollmentSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student, Course course) {


        course.addStudent(student);
        student.addCourse(course);
    }

    public void dropCourse(Student student, Course course) {
        if (students.contains(student) && courses.contains(course)) {
            student.dropCourse(course);
            course.removeStudent(student);

            if (student.getCourses().isEmpty()) {
                students.remove(student);
            }
            if (course.getStudents().isEmpty()) {
                courses.remove(course);
            }

        }
    }

    public boolean isCourseAvailable(Course course) {
        for (Course c : courses) {
            if (c.getCourseName().equals(course.getCourseName())) {
                return c.getAvailablePeopleCount() > 0;
            }
        }
        return false;
    }

}
