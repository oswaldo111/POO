import java.util.ArrayList;
import java.util.List;

public class Course {

    protected String courseName;
    protected String teacher;
    protected List<Student> students;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Course() {
        this.courseName = "";
        this.teacher = "";
        this.students = new ArrayList<>();
    }

    protected void addStudent(Student student) {
        students.add(student);
    }   

    protected void showCourseData() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Teacher: " + teacher);
        System.out.println("Students enrolled:");
        System.out.println("--------------------");
        for (Student student : students) {
            student.showStudentData();
            System.out.println("--------------------");
        }
    }

    protected boolean searchStudentByDni(String dni){

        for (Student student : students) {
            
            if (student.dni == dni) return true;
        }
        return false;
    }
}
