import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseEnrollmentSystemTest {
    private CourseEnrollmentSystem enrollmentSystem;
    private Course oop;
    private Course cs;
    private Student nurgun;
    private Student nuray;

    @BeforeEach
    public void setup() {
        enrollmentSystem = new CourseEnrollmentSystem();
        oop = new Course("oop", 10);
        cs = new Course("cs", 12);
        nurgun = new Student("nurgun");
        nuray = new Student("nuray");
    }

    @Test
    public void testEnrollStudent() {
        enrollmentSystem.enrollStudent(nurgun, oop);
        enrollmentSystem.enrollStudent(nuray, cs);
        enrollmentSystem.enrollStudent(nuray, oop);

        Assertions.assertEquals(1, nurgun.getCourses().size());
        Assertions.assertEquals(2, nuray.getCourses().size());
        Assertions.assertEquals(2, oop.getStudents().size());
        Assertions.assertEquals(1, cs.getStudents().size());
    }

    @Test
    public void testDropCourse() {
        enrollmentSystem.enrollStudent(nurgun, oop);
        enrollmentSystem.enrollStudent(nuray, cs);
        enrollmentSystem.enrollStudent(nuray, oop);

        enrollmentSystem.dropCourse(nuray, oop);

        Assertions.assertNotEquals(14, nurgun.getCourses().size());
        Assertions.assertNotEquals(1, nuray.getCourses().size());
        Assertions.assertNotEquals(12, oop.getStudents().size());
        Assertions.assertNotEquals(2, cs.getStudents().size());
    }

    @Test
    public void testIsCourseAvailable() {
        enrollmentSystem.enrollStudent(nurgun, oop);
        enrollmentSystem.enrollStudent(nuray, cs);

        Assertions.assertFalse(enrollmentSystem.isCourseAvailable(oop));
        Assertions.assertTrue(!enrollmentSystem.isCourseAvailable(cs));

        oop.addStudent(new Student("Another Student"));
    }
}