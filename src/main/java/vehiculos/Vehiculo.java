package vehiculos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vehiculo {
    private String placa;
    private int puertas;
    private int velocidadMaxima;
    private String nombre;
    private double precio;
    private double peso;
    private String traccion;
    private Fabricante fabricante;
    private static int cantidadVehiculos = 0;
    private static List<Vehiculo> vehiculos = new ArrayList<>();

    public Vehiculo(String placa, int puertas, int velocidadMaxima, String nombre, double precio, double peso, String traccion, Fabricante fabricante) {
        this.placa = placa;
        this.puertas = puertas;
        this.velocidadMaxima = velocidadMaxima;
        this.nombre = nombre;
        this.precio = precio;
        this.peso = peso;
        this.traccion = traccion;
        this.fabricante = fabricante;
        cantidadVehiculos++;
        vehiculos.add(this);
    }

    // Getters y Setters
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public int getPuertas() { return puertas; }
    public void setPuertas(int puertas) { this.puertas = puertas; }
    public int getVelocidadMaxima() { return velocidadMaxima; }
    public void setVelocidadMaxima(int velocidadMaxima) { this.velocidadMaxima = velocidadMaxima; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    public String getTraccion() { return traccion; }
    public void setTraccion(String traccion) { this.traccion = traccion; }
    public Fabricante getFabricante() { return fabricante; }
    public void setFabricante(Fabricante fabricante) { this.fabricante = fabricante; }
    public static int getCantidadVehiculos() { return cantidadVehiculos; }

    public static String vehiculosPorTipo() {
        return "Automoviles: " + Automovil.getCantidadAutomoviles() + "\n" +
               "Camionetas: " + Camioneta.getCantidadCamionetas() + "\n" +
               "Camiones: " + Camion.getCantidadCamiones();
    }

    public static Pais paisMasVendedor() {
        Map<Pais, Integer> ventasPorPais = new HashMap<>();
        for (Vehiculo vehiculo : vehiculos) {
            Pais pais = vehiculo.getFabricante().getPais();
            ventasPorPais.put(pais, ventasPorPais.getOrDefault(pais, 0) + 1);
        }
        Pais paisConMasVentas = null;
        int maxVentas = 0;
        for (Map.Entry<Pais, Integer> entry : ventasPorPais.entrySet()) {
            if (entry.getValue() > maxVentas) {
                maxVentas = entry.getValue();
                paisConMasVentas = entry.getKey();
            }
        }
        return paisConMasVentas;
    }

    public static Fabricante fabricaMayorVentas() {
        Map<Fabricante, Integer> ventasPorFabricante = new HashMap<>();
        for (Vehiculo vehiculo : vehiculos) {
            Fabricante fabricante = vehiculo.getFabricante();
            ventasPorFabricante.put(fabricante, ventasPorFabricante.getOrDefault(fabricante, 0) + 1);
        }
        Fabricante fabricanteConMasVentas = null;
        int maxVentas = 0;
        for (Map.Entry<Fabricante, Integer> entry : ventasPorFabricante.entrySet()) {
            if (entry.getValue() > maxVentas) {
                maxVentas = entry.getValue();
                fabricanteConMasVentas = entry.getKey();
            }
        }
        return fabricanteConMasVentas;
    }
}
