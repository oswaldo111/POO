import java.util.List;

public class Student extends Person {
    
    protected int file;
  
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
    }

    public void showStudentData() {
        FileInterantion fileInterantion = new FileInterantion();

        List<Student> students  = fileInterantion.loadCourseFromFile();

        for (Student student : students) {
           
            System.out.println("Name: " + student.getName());
            System.out.println("DNI: " + student.getDni());
            System.out.println("File: " + student.getFile());
            System.out.println("--------------------");
        }
    }



}
