package com.vehicles.project.persistence;

import com.vehicles.project.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;


public class VehiclesRepository {

    private static List<Vehicle> vehicles=new ArrayList<>();

    public VehiclesRepository() {
    }

    public List<Vehicle> getAllVehicles(){

        return new ArrayList<>(vehicles);
    }

    public void addVehicle(Vehicle vehicle) throws Exception{

        if(vehicle==null){
            throw new Exception();
        }

        vehicles.add(vehicle);
    }

    public Vehicle getCurrentVehicle(){
        return vehicles.get(getAllVehicles().size()-1);
    }



}
