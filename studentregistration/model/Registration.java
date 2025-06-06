package studentregistration.model;

public class Registration {
    private Student student;
    private Course course;

    public Registration(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() { return student; }
    public Course getCourse() { return course; }

    @Override
    public String toString() {
        return "Registration: " + student.getName() + " → " + course.getTitle();
    }
}
