package vehiculos;

import java.util.HashMap;
import java.util.Map;

public class Fabricante {
    private String nombre;
    private Pais pais;

    public Fabricante(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public static Fabricante fabricaMayorVentas() {
        Map<Fabricante, Integer> ventasPorFabricante = new HashMap<>();
        for (Vehiculo vehiculo : Vehiculo.getVehiculos()) {
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