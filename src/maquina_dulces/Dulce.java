package maquina_dulces;

public class Dulce {

    private String nombre;
    private double precio;
    private int stock;


    public Dulce(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }


    public void reducirStock() {
        if(this.stock > 0){
            this.stock--;
        }
    }  

    //getters & setters
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public double getPrecio() {return precio;}
    public void setPrecio(double precio) {this.precio = precio;}

    public int getStock() {return stock;}
    public void setStock(int stock) {this.stock = stock;}
 
}