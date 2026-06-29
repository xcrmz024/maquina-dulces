package maquina_dulces;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MaquinaDulces maquina = new MaquinaDulces();

        maquina.agregarDulce(new Chicle("chicle trident", 25.00, 2));
        maquina.agregarDulce(new Paleta("paleta de chile", 2.00, 1));
        maquina.agregarDulce(new Chocolate("chocolate kiss", 30.00, 4));


        boolean continuar = true;
 
        while (continuar) {
            System.out.println("--------");
            System.out.println("  INICIO MAQUINA DE DULCES");
            System.out.println("--------");
            System.out.println("1. Ver menú y Comprar Dulce");
            System.out.println("2. Ver ganancias (panel admin)");
            System.out.println("3. Salir");

            System.out.print("Por favor, selecciona una opción: ");
            int opcionMenu = sc.nextInt();
 
            switch (opcionMenu) {
                case 1 -> {
                    // 1. (menu y generacion de compra de dulce)
                    maquina.mostrarMenu();
                    System.out.print("\nSelecciona el número del dulce que deseas: ");
                    int seleccion = sc.nextInt() - 1; 
 
                    System.out.print("Ingresa la cantidad de dinero: $");
                    double dinero = sc.nextDouble();
 
                    // tipo de pago
                    System.out.println("Elige la forma de pago: 1. MONEDA | 2. BILLETE");
                    int formaPago = sc.nextInt();
                    TipoPago tipoElegido;
                    if (formaPago == 1) {
                        tipoElegido = TipoPago.MONEDA;
                    } else if (formaPago == 2) {
                        tipoElegido = TipoPago.BILLETE;
                    } else {
                        System.out.println("Error: forma de pago invalida.");
                        break; 
                    }
 
                    maquina.generarVenta(opcionMenu, dinero, tipoElegido);
                }
                case 2 -> {
                    // 2. panel admin (ver ganancias)
                    maquina.mostrarReporteAdministrador();
                }
                case 3 -> {
                    //3. salir
                    System.out.println("Uste esta saliendo de la maquina de dulces");
                    continuar = false;
                }
                default -> System.out.println("Opción inválida. Por favor inntenta de nuevo.");
            }
        }
        sc.close();
    }
}


    


