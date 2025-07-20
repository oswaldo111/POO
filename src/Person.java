public class Person {
  
    protected String name;
    protected String dni;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    protected void showData(){

        System.out.println("Name: " + name);
        System.out.println("DNI: " + dni);
    }
  
}
