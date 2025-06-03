import java.util.Scanner;

public class Empleado extends Persona{

    protected String usuario;
    protected String clave;

    public Empleado(){

     }
    public Empleado(String nombre, String cedula, String direccion, String telefono,
                    String usuario, String clave) {
        super(nombre, cedula, direccion, telefono);
        this.usuario = usuario;
        this.clave = clave;
    }

    public Empleado registrarEmpleado(){
        Scanner leer=new Scanner(System.in);
        super.registrarPersona();
        System.out.print("Ingrese su nuevo Usuario: ");
        this.usuario = leer.nextLine();
        System.out.print("Ingrese su nueva Clave: ");
        this.clave = leer.nextLine();
        return new Empleado(nombre, cedula, direccion, telefono,usuario, clave);
    }
    public void mostrarRol() {
        System.out.println("Ha ingresado como Empleado");
    }

    public boolean autenticarEmpleado(String usuario, String clave) {
        return this.usuario.equals(usuario) && this.clave.equals(clave);
    }

    public  void crearCuentaParaCliente(Cliente cliente, String tipo){
        cliente.registrarCuenta(tipo);
        System.out.println("Cuenta creada exitosamente por el empleado.");
    }
    public  void modificarDatosCliente(Cliente cliente){
        Scanner leer = new Scanner(System.in);
        System.out.print("Nueva dirección: ");
        String direccion = leer.nextLine();
        System.out.print("Nuevo teléfono: ");
        String telefono = leer.nextLine();
        cliente.actualizarDatos(direccion,telefono);
        System.out.println("Cliente actulizado por el empleado.");

    }
    public  void registrarPrestamo(Cliente cliente, double monto){
        cliente.solicitarPrestamo(monto);
        System.out.println("Préstamo registrado por el empleado.");
    }
    public  void cerrarCuenta(Cliente cliente, String cuenta){
        System.out.println("Cuenta " + cuenta + " cerrada exitosamente.");
    }


}
