package com.vehicles.project.application;

import com.vehicles.project.domain.Car;
import com.vehicles.project.domain.Vehicle;
import com.vehicles.project.domain.Wheel;
import com.vehicles.project.persistence.TotalWheelsVehicle;
import com.vehicles.project.persistence.VehiclesRepository;


public class TallerController {


    VehiclesRepository repository;
    WheelsFactory wheelsFactory;


    public TallerController() {

        repository = new VehiclesRepository();
        wheelsFactory = new WheelsFactory();
    }


    public void createCar(String matricula, String marca, String color) throws Exception {
        Vehicle car=new Car(matricula,marca,color);
        repository.addVehicle(car);
        wheelsFactory.setTotalWheels(TotalWheelsVehicle.CAR.getNumWheels());
    }

    public boolean checkPlate(String matricula){
        boolean plateOk=true;
        if(!Vehicle.checkPlate(matricula)){
            plateOk=false;
        }
        return plateOk;
    }

    public String generaPlate() {
        return Vehicle.generaPlate();
    }

    public void createWheels(String marca, double diametro) throws Exception {
        Wheel wheel = new Wheel(marca,diametro);
        wheelsFactory.addWheel(wheel,wheelsFactory.getTotalWheels());
        wheelsFactory.addWheel(wheel, wheelsFactory.getTotalWheels());
    }

    public void addWheelsVehicle() throws Exception {
        Car currentCar= (Car) repository.getCurrentVehicle();
        currentCar.addWheels(wheelsFactory.getFrontWheels(), wheelsFactory.getBackWheels());
        wheelsFactory.clearWheels();
    }

    public String getAllVehicles() {
        String infoVehicles = "";
        for (Vehicle vehicle : repository.getAllVehicles()) {
            infoVehicles = infoVehicles.concat(vehicle.toString().concat("\n"));
        }
        return infoVehicles;
    }

}
