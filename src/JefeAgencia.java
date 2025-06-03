public class JefeAgencia extends Empleado {
    public JefeAgencia(String nombre, String cedula, String direccion, String telefono,
                       String usuario, String clave) {
        super(nombre, cedula, direccion, telefono, usuario, clave);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Ha ingresado como Jefe de agencia");
    }

    public boolean aprobarPrestamo(Cliente cliente, double monto) {
        System.out.println("Cliente: "+cliente.nombre) ;
        System.out.println("Préstamo de $" + monto + " aprobado.");
        return true;
    }

    public void generarReporteOperaciones() {

        System.out.println("Reporte de operaciones generado");
    }

    public void evaluarEmpleado(Empleado empleado) {

        System.out.println("Evaluando desempeño de " + empleado.nombre);
        System.out.println("         Resultado satisfactorio");
    }
}
