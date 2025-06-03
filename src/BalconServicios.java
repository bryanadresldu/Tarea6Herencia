import java.util.Scanner;

public class BalconServicios extends Empleado{
    public BalconServicios(String nombre, String cedula, String direccion, String telefono,
                           String usuario, String clave) {
        super(nombre, cedula, direccion, telefono, usuario, clave);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Ha ingresado como Balcon");
    }

    public Cliente registrarNuevoCliente() {
        Scanner leer = new Scanner(System.in);
        System.out.println("\n--- Registro de Nuevo Cliente ---");
        super.registrarPersona();
        System.out.print("Saldo: ");
        double saldo = leer.nextDouble();
        leer.nextLine();
        System.out.println("Cliente registrado con exito desde balcon");
        return new Cliente(nombre, cedula, direccion, telefono,saldo);
    }

    public void actualizarDatosCliente(Cliente cliente, String direccion, String telefono) {
        cliente.actualizarDatos(direccion, telefono);
        System.out.println("   desde balcon");
    }

}
