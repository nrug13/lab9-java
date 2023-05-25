public class App {
    public static void main(String[] args) {
       
        CourseEnrollmentSystem enrollmentSystem = new CourseEnrollmentSystem();

        
        Course mathCourse = new Course("Math", 3);
        Course historyCourse = new Course("History", 2);

        
        Student nurgun = new Student("Nurgun");
        Student nuray = new Student("Nuray");

        
        enrollmentSystem.enrollStudent(nurgun, mathCourse);
        enrollmentSystem.enrollStudent(nuray, historyCourse);
        enrollmentSystem.enrollStudent(nuray, mathCourse); 

        
        System.out.println("Math Course availability: " + enrollmentSystem.isCourseAvailable(mathCourse)); 
        System.out.println("History Course availability: " + enrollmentSystem.isCourseAvailable(historyCourse)); 

        
        enrollmentSystem.dropCourse(nuray, mathCourse);

       
        System.out.println("Math Course availability after dropping: " + enrollmentSystem.isCourseAvailable(mathCourse)); 
        
        System.out.println(nurgun.getName() + "'s enrolled courses: " + nurgun.getCourses());
        System.out.println(nuray.getName() + "'s enrolled courses: " + nuray.getCourses());
    }
}
