import java.util.Scanner;

public abstract class Persona {
    protected String nombre;
    protected String cedula;
    protected String direccion;
    protected String telefono;

    public Persona(){

    }
    public Persona(String nombre, String cedula, String direccion, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public void registrarPersona(){
        Scanner leer=new Scanner(System.in);
        System.out.println("  Por favor ingrese la siguiente informacion:");
        System.out.print("Nombre: ");
        nombre = leer.nextLine();
        System.out.print("Cedula: ");
        cedula = leer.nextLine();
        System.out.print("Direccion: ");
        direccion = leer.nextLine();
        System.out.print("Telefono: ");
        telefono = leer.nextLine();

    }

    public void actualizarDatos(String direccion, String telefono) {
        this.direccion = direccion;
        this.telefono = telefono;
        System.out.println("Datos actualizados correctamente");

    }

    public abstract void mostrarRol();

    public void mostrarDatos(){
        System.out.println("-----DATOS INGRESADOS-----");
        System.out.println("Nombre: "+ nombre);
        System.out.println("Cedula: "+ cedula );
        System.out.println("Direccion: "+ direccion );
        System.out.println("Telefono: "+ telefono );


    }

}