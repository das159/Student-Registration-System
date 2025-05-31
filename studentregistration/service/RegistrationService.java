package studentregistration.service;

import studentregistration.model.Student;
import studentregistration.model.Course;
import studentregistration.model.Registration;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Registration> registrations = new ArrayList<>();

    public void addStudent(String id, String name) {
        students.add(new Student(id, name));
    }

    public void addCourse(String code, String title) {
        courses.add(new Course(code, title));
    }

    public Student getStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) return s;
        }
        return null;
    }

    public Course getCourseByCode(String code) {
        for (Course c : courses) {
            if (c.getCode().equals(code)) return c;
        }
        return null;
    }

    public boolean registerStudent(String studentId, String courseCode) {
        Student student = getStudentById(studentId);
        Course course = getCourseByCode(courseCode);
        if (student != null && course != null) {
            registrations.add(new Registration(student, course));
            return true;
        }
        return false;
    }

    public List<Student> getAllStudents() { return students; }
    public List<Course> getAllCourses() { return courses; }
    public List<Registration> getAllRegistrations() { return registrations; }
}
