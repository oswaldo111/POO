public class Course extends Student{

    protected String courseName;
    protected String teacher;

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

    public Course() {
        this.courseName = "aa";
        this.teacher = "zz";
    }

    protected void addStudent(Student student) {
        students.add(student);
    }   

    protected void showCourseData() {
        Student student = new Student();
        
        System.out.println("Course Name: " + courseName);
        System.out.println("Teacher: " + teacher);
        System.out.println("Students enrolled:");
        System.out.println("--------------------");
        student.showStudentData();
        countStudents();
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

    protected void UpdateStudent(Student newStudent, Student oldStudent) {
       
        int index = students.indexOf(oldStudent);

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
