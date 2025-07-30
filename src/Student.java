import java.util.ArrayList;
import java.util.Comparator;
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
        orderStudentsByName();
    }

    public void orderStudentsByName()
    {
        students.sort(new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {
                
                return s1.getName().compareToIgnoreCase(s2.getName());
            }
        });
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
