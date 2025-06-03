import java.util.Scanner;

public class Cliente extends Persona {
    private double saldo;

    public Cliente() {
        super();
    }

    public Cliente(String nombre, String cedula, String direccion, String telefono,Double saldo) {
        super(nombre, cedula, direccion, telefono);
        this.saldo=saldo;
    }

    public Cliente registrarCliente(){
        Scanner leer=new Scanner(System.in);
        super.registrarPersona();
        System.out.print("Saldo: ");
        this.saldo = leer.nextDouble();
        leer.nextLine();
        return new Cliente(nombre, cedula, direccion, telefono,saldo);
    }


    @Override
    public void mostrarRol() {
        System.out.println("Usted ha ingresado como: Cliente");
    }

    public boolean ingresarAlSistema() {
        return true;
    }
    public void registrarCuenta(String tipo) {

        System.out.println("Cuenta registrada: " + tipo);
    }

    public void solicitarPrestamo(double monto) {

        System.out.println("Préstamo solicitado por: $" + monto);
    }

    public void agregarTarjetaCredito() {

        System.out.println("Tarjeta de crédito agregada.");
    }

    public void verSaldo() {
        System.out.println("saldo: "+saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void verResumenFinanciero() {

        System.out.println("Resumen financiero mostrado.");
    }

    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Saldo:"+saldo);
    }

}

