package com.vehicles.project.persistence;

import com.vehicles.project.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de la capa de persistencia
 */
public class VehiclesRepository {

    private static List<Vehicle> vehicles=new ArrayList<>();

    public VehiclesRepository() {
    }

    /**
     * Devuelve un listado con todos los objetos hijos de la clase abstracta Vehicle
     * @return el listado formado por objetos que extienden a la clase Vehicle
     */
    public List<Vehicle> getAllVehicles(){

        return new ArrayList<>(vehicles);
    }

    /**
     * Añade un objeto de tipo Vehicle al listado de vehiculos, o repositorio
     * @param vehicle
     * @throws Exception
     */
    public void addVehicle(Vehicle vehicle) throws Exception{

        if(vehicle==null){
            throw new Exception();
        }

        vehicles.add(vehicle);
    }

    /**
     * Obtiene el objeto Car o Bike con el que el usuario esta interactuando en cada momento
     * @return la ultima implementacion concreta de la clase abstracta Vehicle(Car o Bike), que ha sido
     * añadida al listado de Vehicles o repositorio
     */
    public Vehicle getCurrentVehicle(){

        return vehicles.get(getAllVehicles().size()-1);
    }



}
