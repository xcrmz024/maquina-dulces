package maquina_dulces;

import java.util.ArrayList;
import java.util.List;

public class MaquinaDulces {

    private List<Dulce> listaDulces;
    private double totalVentas;


    public MaquinaDulces() {
        this.listaDulces = new ArrayList<>();
        this.totalVentas = 0.0;
    }

    public void agregarDulce(Dulce dulce){
        this.listaDulces.add(dulce);
    }


    public void mostrarMenu() {
        System.out.println("--MENU DE DULCES--");
        for (int i=0; i < listaDulces.size(); i++) {
            Dulce d = listaDulces.get(i);
            System.out.println((i+1)+ "." + d.getNombre() + "Precio: $ " + d.getPrecio());
        }
    }



    public void generarVenta(int indexDulce, double dineroIngresado, TipoPago tipoPago ) {
        //verificar index dulce correcto
        if (indexDulce < 0 || indexDulce >= listaDulces.size()) {
            System.out.println("Opcion invalida");
            return;
        }
        Dulce dulceAComprar = listaDulces.get(indexDulce);
        //verificar stock
        if (dulceAComprar.getStock() <= 0) {
            System.out.println("No hay stock para dulce: " + dulceAComprar);
            return;
        }

        // verificar fondos
        if (dineroIngresado <= dulceAComprar.getPrecio()) {
            System.out.println("Fondos insuficientes");
            return;
        }
        //venta existosa
        System.out.println("Venta existosa!");
        dulceAComprar.reducirStock();
        this.totalVentas += dulceAComprar.getPrecio();

    }

    public void mostrarReporteAdministrador() {         
        System.out.println("----");         
        System.out.println("Dinero total en caja: $" + this.totalVentas);         
        System.out.println("Inventario actual:");         
        for (Dulce d : listaDulces) {             
            System.out.println("- " + d.getNombre() + " | Stock: " + d.getStock());
        }
    }

       
    //getter
    public List<Dulce> getListaDulces() {return listaDulces;}

    public double getTotalVentas() {return totalVentas;}


}

    



    
    
