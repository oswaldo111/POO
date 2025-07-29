import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    
    protected int file;
    List<Student> students = new ArrayList<>();
    FileInterantion fileInterantion = new FileInterantion();
  
    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public Student(String name, String dni, int file) {
        this.name = name;
        this.dni = dni;
        this.file = file;
    }

    public Student() {

        students = fileInterantion.loadCourseFromFile();
    }

    public void showStudentData() {

        for (Student student : students) {
           
            System.out.println("Name: " + student.getName());
            System.out.println("DNI: " + student.getDni());
            System.out.println("File: " + student.getFile());
            System.out.println("--------------------");
        }
    }



}
