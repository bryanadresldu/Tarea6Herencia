public class Cajero extends Empleado{
    public Cajero(String nombre, String cedula, String direccion, String telefono,
                  String usuario, String clave) {
        super(nombre, cedula, direccion, telefono, usuario, clave);
    }
        @Override
        public void mostrarRol() {
            System.out.println("Ha ingresado como Cajero");
        }

        public void procesarRetiro(Cliente cliente, double monto) {
            if (cliente.getSaldo()>=monto){
                System.out.println("Retiro de " + monto + " $");
                cliente.setSaldo(cliente.getSaldo()-monto);
                System.out.println("Su saldo es de " + cliente.getSaldo());}
            else
                System.out.println("Saldo insuficiente");
        }

        public void consultarSaldo(Cliente cliente) {
            System.out.println("Consulta de saldo para el cliente.");
            System.out.println("Su saldo es de " + cliente.getSaldo());
        }

        public void procesarDeposito(Cliente cliente, double monto) {
            if (monto>0){
                System.out.println("Deposito de " + monto + "$");
                cliente.setSaldo(cliente.getSaldo()+monto);
                System.out.println("Su saldo es de " + cliente.getSaldo());}
            else
                System.out.println("Deposito no valido");


        }

}

