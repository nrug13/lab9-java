import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private int AvailablePeopleCount;
    private List<Student> students;

    public Course(String courseName, int availableSeats) {
        this.courseName = courseName;
        this.AvailablePeopleCount = availableSeats;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public int getAvailablePeopleCount() {
        return AvailablePeopleCount;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
        AvailablePeopleCount--;
    }

    public void removeStudent(Student student) {
        students.remove(student);
        AvailablePeopleCount++;
    }

    @Override
    public String toString() {
        return courseName;
    }
}
