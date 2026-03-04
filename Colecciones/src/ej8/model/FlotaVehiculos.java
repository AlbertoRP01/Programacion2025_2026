package ej8.model;

import ej8.exceptions.VehiculoException;
import ej8.model.Vehiculo;

import java.util.HashMap;

public class FlotaVehiculos {

    private HashMap<String, Vehiculo> vehiculos;

    /**
     * Variable que guarda donde se insertará el siguiente vehiculo
     * Empieza con 0 y si vale vehiculos.length el almacen esta lleno
     */
    private int numeroRealDeVehiculos;

    public FlotaVehiculos() throws VehiculoException {
        this.vehiculos = new HashMap<>();
    }

    /**
     * Introduce el vehiculo al mapa de vehculos
     * se comprueba que el vehiculo no sea nulo
     * @param vehiculo la variable que se instancia en el parámetro
     * @throws VehiculoException
     */
    public void introducirVehiculo(Vehiculo vehiculo) throws VehiculoException {
        if (vehiculo == null) {
            throw new VehiculoException("El vehiculo no puede ser nulo ");

        }
        if (vehiculos.containsKey(vehiculo.getMatricula())) {
            throw new VehiculoException("Ya existe este vehiculo");
        }
        // los mapas utiliza put en vez de add como las listas para añadir la clave  con su respectivo  valor
        vehiculos.put(vehiculo.getMatricula(), vehiculo);
    }

    private Vehiculo buscarMatricula(String matricula) {

        return vehiculos.get(matricula);
    }

    public double precioAlquiler(String matricula, int dias) throws VehiculoException {
        Vehiculo vehiculo = buscarMatricula(matricula);
        if (vehiculo == null) {
            throw new VehiculoException("No existe ese vehiculo con esa matricula");
        }
        return vehiculo.calcularAlquiler(dias);
    }

    public String toString() {
        return null;

    }
}
