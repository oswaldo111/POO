import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        //save and load from a file

        Course course = new Course();
        Scanner scanner = new Scanner(System.in);
        FileInterantion fileInterantion = new FileInterantion();
        
        boolean Switch = true;
        
        while (Switch) {
            
            System.out.print("que desea hacer (1) añadir estudiante (2) mostrar datos del curso (3) salir: ");
            int value = scanner.nextInt();

            System.out.println();

            switch (value) {

                case 1:
                
                    scanner.nextLine(); 
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String name = scanner.nextLine();

                    System.out.print("\nIngrese el DNI del estudiante: ");
                    String dni = scanner.nextLine();

                    System.out.print("\nIngrese el archivo del estudiante: ");
                    int file = scanner.nextInt();

                    System.out.println();
                    Student student = new Student(name, dni, file);
                    course.addStudent(student);
                    
                    fileInterantion.saveCourseToFile(student);
                break;
                case 2:
                    course.countStudents();
                    System.out.println();
                    course.showCourseData();
                    break;

                case 3:
                    Switch = false;
                
                    break;

                case 4:

                    scanner.nextLine();
                    System.out.print("ingrese el dni del estudiante a buscar: ");
                    String searchDni = scanner.nextLine();
                    
                    System.out.println();

                    course.searchStudentByDni(searchDni);
                
                break;

                case 5:
                
                    scanner.nextLine();
                    System.out.print("ingrese el dni del estudiante a eliminar: ");
                    String deleteDni = scanner.nextLine();

                    course.deleteStudentByDniOrFile(deleteDni);

                break;

                case 6:
                scanner.nextLine();

                System.out.print("ingrese el dni del estudiante a modificar: ");
                String modifyDni = scanner.nextLine();

                student = course.searchStudentByDni(modifyDni);

                if (student != null) {
                    
                    System.out.print("Ingrese el nuevo nombre del estudiante: ");
                    student.name = scanner.nextLine();

                    System.out.print("Ingrese el nuevo DNI del estudiante: ");
                    student.dni = scanner.nextLine();

                    System.out.print("Ingrese el nuevo archivo del estudiante: ");
                    student.file = scanner.nextInt();

                    course.UpdateStudent(student);

                } else {
                    System.out.println("Estudiante no encontrado.\n");
                }
                break;

                default:
                    System.out.println("opcion no valida \n");
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
        scanner.close();
    }
}


