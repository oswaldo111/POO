public class Student extends Person {
    
    private int file;
  
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

    public void showStudentData() {
        showData();
        System.out.println("Student File: " + file);
    }



}
