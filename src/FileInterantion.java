import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileInterantion {

    public void saveCourseToFile(Student student) {
        
        try( BufferedWriter file = new BufferedWriter
             (new FileWriter("C:\\Users\\R5 8500G\\Desktop\\java proyects\\POO\\src\\course_data.txt",true));) 
        {
            file.write(student.getName() + "," + student.getDni() + "," + student.getFile());
            file.newLine();
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }

    }

    public List<Student> loadCourseFromFile() {
        
        List<Student> students = new ArrayList<>();
       
        try (BufferedReader bufferedReader = new BufferedReader
        (new FileReader("C:\\Users\\R5 8500G\\Desktop\\java proyects\\POO\\src\\course_data.txt"))) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length == 3) {

                    String name = parts[0];
                    String dni = parts[1];
                    int file = Integer.parseInt(parts[2]);
                    Student student = new Student(name, dni, file);
                    students.add(student);
                }
            }
            return students;
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;   
    }

    public void overwriteCourseFile(List<Student> students) {

        try (BufferedWriter file = new BufferedWriter(
                new FileWriter("C:\\Users\\R5 8500G\\Desktop\\java proyects\\POO\\src\\course_data.txt", false))) 
            {
                for (Student student : students) {
                
                file.write(student.getName() + "," + student.getDni() + "," + student.getFile());
                file.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
