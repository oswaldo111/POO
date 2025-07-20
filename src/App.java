import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Course course = new Course();
        Scanner scanner = new Scanner(System.in);
        
        boolean Switch = true;
        
        while (Switch) {
            
            System.out.println("que desea hacer (1) añadir estudiante (2) mostrar datos del curso (3) salir");
            int value = scanner.nextInt();


            switch (value) {

                case 1:
                    
                System.out.println("Ingrese el nombre del estudiante:");
                String name = scanner.next();

                System.out.println("Ingrese el DNI del estudiante:");
                String dni = scanner.next();

                System.out.println("Ingrese el archivo del estudiante:");
                int file = scanner.nextInt();

                Student student = new Student(name, dni, file);
                course.addStudent(student);

                    break;
                case 2:
                    course.showCourseData();
                    break;

                case 3:
                    Switch = false;
            
                default:
                    System.out.println("opcion no valida");
                    break;
            }

        }


        // course.setCourseName("mate");
        // course.setTeacher("Mr. Smith");

        // Student[] student = {
        //     new Student("John Doe", "12345678A", 101),
        //     new Student("Jane Smith", "87654321B", 102),
        //     new Student("Alice Johnson", "11223344C", 103),
        // };

        // for (Student s : student) {
        //     course.addStudent(s);
        // }

         course.showCourseData();

    }
}


