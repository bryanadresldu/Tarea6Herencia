import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    String opcion="";
    Scanner leer=new Scanner(System.in);

        Cliente cliente = null;
        Cliente clienteNuevo = null;
        Cajero cajero = null;
        BalconServicios balcon= null;



        while (!opcion.equals("0")) {
            System.out.println("--------- Menú principal ---------");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ingresar como cliente");
            System.out.println("3. Ingresar como empleado (cajero, balcón, jefe agencia)");
            System.out.println("0. Salir");

            System.out.println("Ingrese la opcion (1-2-3-0)");
            opcion = leer.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("             Registro de nuevo cliente");
                    cliente=new Cliente();
                    cliente.registrarCliente();
                    System.out.println("Cliente registrado con exito");
                    cliente.mostrarDatos();

                    break;
                case "2":
                    String opcionCliente="";
                    if (cliente != null && cliente.ingresarAlSistema()) {
                        cliente.mostrarRol();
                        System.out.println("Bienvenido, " + cliente.nombre);

                        while (!opcionCliente.equals("0")){
                            System.out.println("--------- Opciones ---------");
                            System.out.println("1. Abrir cuenta");
                            System.out.println("2. Ver saldo ");
                            System.out.println("3. Solicitar prestamo");
                            System.out.println("4. Solicitar tarjeta de credito");

                            System.out.println("0. Regresar");

                            System.out.println("Ingrese la opcion (1-2-3-0) ");
                            opcionCliente = leer.nextLine();

                            switch (opcionCliente){
                                case "1":
                                    System.out.println(" Abrir cuenta");
                                    System.out.println("Ingrese el tipo de cuenta (ahorro/corriente)");
                                    String tipoCuenta=leer.nextLine();
                                    cliente.registrarCuenta(tipoCuenta);
                                    break;
                                case "2":
                                    System.out.println("  Ver saldo ");
                                    cliente.verSaldo();
                                    break;
                                case "3":
                                    System.out.println("  Solcitar prestamo");
                                    System.out.println("Ingrese el monto a solicitar:");
                                    double prestamo=leer.nextDouble();
                                    leer.nextLine();
                                    cliente.solicitarPrestamo(prestamo);
                                    break;
                                case "4":
                                    System.out.println("  Solcitar tarjeta de credito");
                                    cliente.agregarTarjetaCredito();
                                    break;
                                case "0":
                                    System.out.println("--Regresando al menu principal--");
                                    break;
                                default:
                                    System.out.println("Opcion no valida");
                                    break;
                                    }
                        }
                    } else {
                        System.out.println("Primero debe registrar un cliente");
                    }
                    break;
                case "3":
                    String cargo="";
                    System.out.println(" Ha ingresado como empleado ");
                    Empleado empleado=new Empleado();
                    empleado.registrarEmpleado();

                    int intentos=3;
                    while (intentos!=0) {
                        System.out.println("  Ingrese sus credenciales para ingresar ");
                        System.out.print("Ingrese su Usuario: ");
                        String usuarioIngresado = leer.nextLine();
                        System.out.print("Ingrese su Clave: ");
                        String claveIngresada = leer.nextLine();

                        if (empleado.autenticarEmpleado(usuarioIngresado, claveIngresada)) {
                                intentos=0;
                            while (!cargo.equals("0")){
                                System.out.println("--------- Cargo ---------");
                                System.out.println("1. Cajero");
                                System.out.println("2. Balcon");
                                System.out.println("3. Jefe de agencia");
                                System.out.println("0. Regresar");

                                System.out.println("Ingrese su cargo (1-2-3-0)");
                                cargo = leer.nextLine();
                                String acciones="";
                                switch (cargo) {
                                    case "1":
                                        cajero=new Cajero(empleado.nombre,empleado.cedula,empleado.direccion,empleado.telefono,empleado.usuario,empleado.clave);
                                        cajero.mostrarRol();
                                        if (cliente != null){
                                        while (!acciones.equals("0")){
                                            System.out.println("--------- Acciones ---------");
                                            System.out.println("1. Procesar Retiro");
                                            System.out.println("2. Procesar Deposito");
                                            System.out.println("3. Consultar saldo");
                                            System.out.println("0. Regresar");

                                            System.out.println("Ingrese su accion (1,2 o 3)");
                                            acciones = leer.nextLine();

                                            switch (acciones) {
                                                case "1":
                                                    System.out.println("      Procesar Retiro");
                                                    System.out.println("Ingrese el monto a retirar:");
                                                    double retiro = leer.nextDouble();
                                                    leer.nextLine();
                                                    cajero.procesarRetiro(cliente, retiro);
                                                    break;
                                                case "2":
                                                    System.out.println(" Procesar Deposito");
                                                    System.out.println("Ingrese el monto a depositar:");
                                                    double deposito = leer.nextDouble();
                                                    leer.nextLine();
                                                    cajero.procesarDeposito(cliente, deposito);

                                                    break;
                                                case "3":
                                                    System.out.println("Consultar saldo");
                                                    cajero.consultarSaldo(cliente);
                                                    break;
                                                case "0":
                                                    System.out.println("--Regresando a cargos--");

                                                    break;
                                                default:
                                                    System.out.println("Opcion no valida");
                                                    break;
                                            }
                                            }

                                        }
                                        else
                                            System.out.println("Ingrese un cliente primero");

                                        break;
                                    case "2":
                                        balcon=new BalconServicios(empleado.nombre,empleado.cedula,empleado.direccion,empleado.telefono,empleado.usuario,empleado.clave);

                                        balcon.mostrarRol();
                                        while (!acciones.equals("0")){
                                            System.out.println("--------- Acciones ---------");
                                            System.out.println("1. Registrar nuevo cliente");
                                            System.out.println("2. Actulizar datos cliente");
                                            System.out.println("0. Regresar");

                                            System.out.println("Ingrese su accion (1-2-0)");
                                            acciones = leer.nextLine();

                                            switch (acciones) {
                                                case "1":
                                                    clienteNuevo=balcon.registrarNuevoCliente();
                                                    clienteNuevo.mostrarDatos();
                                                    break;
                                                case "2":
                                                    if (clienteNuevo != null ){

                                                    System.out.println("Ingrese los datos a actualizar ");
                                                    System.out.println("Direccion: ");
                                                    String direccion = leer.nextLine();
                                                    System.out.println("Telefono: ");
                                                    String telefono = leer.nextLine();
                                                    balcon.actualizarDatosCliente(clienteNuevo, direccion, telefono);
                                                    clienteNuevo.mostrarDatos();}
                                                    else
                                                        System.out.println("Ingrese un cliente primero");

                                                    break;

                                                case "0":
                                                    System.out.println("--Regresando a cargos--");

                                                    break;
                                                default:
                                                    System.out.println("Opcion no valida");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "3":
                                        JefeAgencia jefe=new JefeAgencia(empleado.nombre,empleado.cedula,empleado.direccion,empleado.telefono,empleado.usuario,empleado.clave);
                                        jefe.mostrarRol();
                                        while (!acciones.equals("0")){
                                            System.out.println("--------- Acciones ---------");
                                            System.out.println("1. Aprobar prestamos");
                                            System.out.println("2. Generar reporte de Operaciones");
                                            System.out.println("3. Evaluar empleado");
                                            System.out.println("0. Regresar");

                                            System.out.println("Ingrese su accion (1-2-3-0)");
                                            acciones = leer.nextLine();

                                            switch (acciones) {
                                                case "1":
                                                    if (cliente != null ){
                                                    System.out.println("Aprobar prestamos");
                                                    System.out.println("Ingrese el monto del prestamo");
                                                    double prestamo=leer.nextDouble();
                                                    leer.nextLine();
                                                    jefe.aprobarPrestamo(cliente,prestamo);}
                                                    else
                                                        System.out.println("Ingrese un cliente primero");
                                                    break;
                                                case "2":
                                                    System.out.println(" Generar reporte de Operaciones");
                                                    jefe.generarReporteOperaciones();

                                                    break;
                                                case "3":
                                                    if ( cajero!=null && balcon!=null){
                                                    System.out.println("Evaluar empleado");
                                                    jefe.evaluarEmpleado(cajero);
                                                    jefe.evaluarEmpleado(balcon);}
                                                    else
                                                        System.out.println("Ingrese un empleado de blacon y cajero pimero");
                                                    break;
                                                case "0":
                                                    System.out.println("--Regresando a cargos--");

                                                    break;
                                                default:
                                                    System.out.println("Opcion no valida");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "0":
                                        System.out.println("--Regresando al menu principal--");

                                        break;
                                    default:
                                        System.out.println("Opcion no valida");
                                        break;
                                }
                            }
                        }
                        else {
                            System.out.println("  Credenciales incorrectas");
                            intentos-=1;
                            System.out.println("  intentos faltantes,"+intentos);
                        }
                    }
                    break;
                case "0":
                    System.out.println("  Esta saliendo, vuelva pronto");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
}