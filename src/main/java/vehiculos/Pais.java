package vehiculos;

import java.util.HashMap;
import java.util.Map;

public class Pais {
    private String nombre;

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static Pais paisMasVendedor() {
        Map<Pais, Integer> ventasPorPais = new HashMap<>();
        for (Vehiculo vehiculo : Vehiculo.getVehiculos()) {
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
}