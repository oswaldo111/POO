import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Course {

    protected String courseName;
    protected String teacher;
    protected List<Student> students;
    Student student = new Student();
    FileInterantion fileInterantion = new FileInterantion();

  

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
        this.students = fileInterantion.loadCourseFromFile();
    }

    protected void addStudent(Student student) {
        students.add(student);
    }   

    protected void showCourseData() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Teacher: " + teacher);
        System.out.println("Students enrolled:");
        System.out.println("--------------------");
        student.showStudentData();
    }

    protected Student searchStudentByDni(String dni){

        for (Student student : students) {
            
            if (student.dni.equals(dni)){

                System.out.println("Student found:\n");
                System.out.println("Name: " + student.getName());
                System.out.println("DNI: " + student.getDni());
                System.out.println("File: " + student.getFile() + "\n");
                return student;
            }
        }
        System.out.println("No student found with the provided DNI.\n");
        return null;
    }

    protected void deleteStudentByDniOrFile(String dni){

     Student student = searchStudentByDni(dni);

        if (student != null) {
            students.remove(student);
            System.out.println("Student with DNI " + dni + " has been removed successfully.");
            fileInterantion.overwriteCourseFile(students);
        } else {
            
            System.out.println("No student found with the provided file number.\n");
            
        }
    }

    protected void UpdateStudent(Student newStudent) {
       
        int index = students.indexOf(newStudent);

        students.get(index).setName(newStudent.name);
        students.get(index).setDni(newStudent.dni);
        students.get(index).setFile(newStudent.file);

        fileInterantion.overwriteCourseFile(students);

        System.out.println("Student updated successfully.");


    }

    protected void countStudents() {
        System.out.println("Total number of students: " + students.size());
    }
}
