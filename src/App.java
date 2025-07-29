import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        //save and load from a file

        Course course = new Course();
        Scanner scanner = new Scanner(System.in);
        FileInterantion fileInterantion = new FileInterantion();
        Student student = new Student();
        boolean Switch = true;
        
        while (Switch) {
            
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Añadir estudiante");
            System.out.println("2. Mostrar datos del curso");
            System.out.println("3. Buscar estudiante por DNI");
            System.out.println("4. Eliminar estudiante por DNI");
            System.out.println("5. Modificar estudiante");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int value = scanner.nextInt();

            System.out.println();

            switch (value) {

                case 0:
                    System.out.println("Saliendo del programa...");
                    Switch = false;
                break;
                
                case 1:

                    scanner.nextLine(); 
                    System.out.print("\nIngrese el DNI del estudiante: ");
                    String dni = scanner.nextLine();

                    if(course.searchStudentByDni(dni) == null)
                    {

                        System.out.print("\nIngrese el nombre del estudiante: ");
                        String name = scanner.nextLine();

                        System.out.print("\nIngrese el archivo del estudiante: ");
                        int file = scanner.nextInt();

                        if (validationParameters(name, dni, file)) {
                            
                            System.out.println();
                            student.setName(name);
                            student.setDni(dni);
                            student.setFile(file);
                            course.addStudent(student);
                            fileInterantion.saveCourseToFile(student);
                        }
                    }
                    else {
                        System.out.println("El estudiante ya existe.\n");
                    }

                break;

                case 2:
                    
                    System.out.println();
                    course.showCourseData();
                    break;

                case 3:

                    scanner.nextLine();
                    System.out.print("ingrese el dni del estudiante a buscar: ");
                    String searchDni = scanner.nextLine();
                    
                    System.out.println();

                    if(course.searchStudentByDni(searchDni) == null){
                      
                        System.out.println("\nStudent not found.\n");
                    }
                  
                
                break;

                case 4:
                
                    scanner.nextLine();
                    System.out.print("ingrese el dni del estudiante a eliminar: ");
                    String deleteDni = scanner.nextLine();

                    course.deleteStudentByDniOrFile(deleteDni);

                break;

                case 5:
                    scanner.nextLine();

                    System.out.print("ingrese el dni del estudiante a modificar: ");
                    String modifyDni = scanner.nextLine();
                    student = course.searchStudentByDni(modifyDni);

                    if (student != null) {
                        
                        System.out.print("Ingrese el nuevo nombre del estudiante: ");
                        String name = scanner.nextLine();

                        System.out.print("Ingrese el nuevo DNI del estudiante: ");
                        modifyDni = scanner.nextLine();

                        System.out.print("Ingrese el nuevo archivo del estudiante: ");
                        int file = scanner.nextInt();
                        
                        if(validationParameters(name, modifyDni, file)){
                            Student newStudent = new Student(name, modifyDni, file);

                            course.UpdateStudent(newStudent, student);
                        } 
                        

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

        scanner.close();
    }

    private static boolean validationParameters(String name, String dni, int file) {
        
        if (name.equals("") || dni.equals("") || file <= 0) {
            System.out.println("Los datos del estudiante no pueden estar vacíos o el archivo debe ser mayor que cero.");
            return false;
            
        }

        return true;
    }
}


