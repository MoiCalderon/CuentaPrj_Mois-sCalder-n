import java.util.ArrayList;
import java.util.Scanner;

public class ClasePrincipalCuenta{
    private static ArrayList<Cuenta> cuentas = new ArrayList<>();
    private static Cuenta cuentaActual = null;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú principal");
            System.out.println("1) Crear Cuenta");
            System.out.println("2) Conocer la cantidad de Cuentas Creadas");
            System.out.println("3) Listar Cuentas");
            System.out.println("4) Seleccionar Cuenta actual");
            System.out.println("5) Depositar");
            System.out.println("6) Retirar");
            System.out.println("7) Consultar Saldo");
            System.out.println("8) Consultar Estado (toString)");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    crearCuenta(sc);
                    break;
                case 2:
                    System.out.println("Cantidad de cuentas creadas: " + Cuenta.getCantidadCuentas());
                    break;
                case 3:
                    listarCuentas();
                    break;
                case 4:
                    seleccionarCuenta(sc);
                    break;
                case 5:
                    if (cuentaActual != null) {
                        System.out.print("Monto a depositar: ");
                        double monto = sc.nextDouble();
                        System.out.println("Nuevo saldo: " + cuentaActual.depositar(monto));
                    } else {
                        System.out.println("Debe seleccionar una cuenta primero.");
                    }
                    break;
                case 6:
                    if (cuentaActual != null) {
                        System.out.print("Monto a retirar: ");
                        double monto = sc.nextDouble();
                        System.out.println("Nuevo saldo: " + cuentaActual.retirar(monto));
                    } else {
                        System.out.println("Debe seleccionar una cuenta primero.");
                    }
                    break;
                case 7:
                    if (cuentaActual != null) {
                        System.out.println("Saldo actual: " + cuentaActual.getSaldo());
                    } else {
                        System.out.println("Debe seleccionar una cuenta primero.");
                    }
                    break;
                case 8:
                    if (cuentaActual != null) {
                        System.out.println(cuentaActual.toString());
                    } else {
                        System.out.println("Debe seleccionar una cuenta primero.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }

     private static void crearCuenta(Scanner sc) {
        System.out.println("¿Desea crear la cuenta con 1 o 2 parámetros?");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            System.out.print("Ingrese saldo inicial: ");
            double saldo = sc.nextDouble();
            Cuenta nueva = new Cuenta(saldo);

            System.out.print("Ingrese el nombre del titular: ");
            sc.nextLine();
            String nombre = sc.nextLine();
            nueva.setCuentaHabiente(nombre);

            cuentas.add(nueva);
            System.out.println("Cuenta creada: " + nueva);

        } else if (opcion == 2) {
            System.out.print("Ingrese el nombre del titular: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese saldo inicial: ");
            double saldo = sc.nextDouble();

            Cuenta nueva = new Cuenta(nombre, saldo);
            cuentas.add(nueva);
            System.out.println("Cuenta creada: " + nueva);
        } else {
            System.out.println("Opción inválida. Intente de nuevo.");
        }
    }
    
    private static void listarCuentas() {
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas creadas.");
        } else {
            for (Cuenta c : cuentas) {
                System.out.println(c.toString());
            }
        }
    }  
    
    private static void seleccionarCuenta(Scanner sc) {
        listarCuentas();
        if (!cuentas.isEmpty()) {
            System.out.print("Ingrese el número de cuenta a seleccionar: ");
            int num = sc.nextInt();
            sc.nextLine();

            for (Cuenta c : cuentas) {
                if (c.toString().contains("Cuenta N°: " + num)) {
                    cuentaActual = c;
                    System.out.println("Cuenta seleccionada: " + cuentaActual);
                    return;
                }
            }
            System.out.println("Número de cuenta no encontrado.");
        }
    }
}
    
