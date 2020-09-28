package com.vehicles.project.application;

import com.vehicles.project.domain.Car;
import com.vehicles.project.domain.Vehicle;
import com.vehicles.project.domain.Wheel;
import com.vehicles.project.persistence.VehiclesRepository;

/**
 * Clase de la capa de aplicacion
 */
public class TallerController {

    VehiclesRepository repository;
    WheelsFactory wheelsFactory;

    public TallerController() {

        repository = new VehiclesRepository();
        wheelsFactory = new WheelsFactory();
    }

    /**
     * Crea un objeto de tipo Car, lo añade a la capa de persistencia y fija el total de ruedas
     * que corresponde al objeto Car
     * @param matricula
     * @param marca
     * @param color
     * @throws Exception
     */
    public void createCar(String matricula, String marca, String color) throws Exception {
        Vehicle car=new Car(matricula,marca,color);
        repository.addVehicle(car);
        wheelsFactory.setTotalWheels(WheelsFactory.TotalWheelsVehicle.CAR.getNumWheels());
    }

    /**
     * Llama al metodo checkPlate() implementado en la clase abstracta Vehicle, para ckekear si
     * una matricula es o no valida
     * @param matricula
     * @return true si la matricula es valida, false si no lo es
     */
    public boolean checkPlate(String matricula){
        boolean plateOk=true;
        if(!Vehicle.checkPlate(matricula)){
            plateOk=false;
        }
        return plateOk;
    }

    /**
     * Llama al metodo generaPlate() implemnetado en la clase abstracta Vehicle, para generar
     * una matricula valida de forma aleatoria
     * @return String con la matricula generada valida
     */
    public String generaPlate() {
        return Vehicle.generaPlate();
    }

    /**
     * Crea un objeto de tipo Wheel y lo añade 2 veces a la clase WheelsFactory.
     * Se utiliza para generar las 2 ruedas delantera y las 2 ruedas traseras
     * @param marca
     * @param diametro
     * @throws Exception
     */
    public void createWheels(String marca, double diametro) throws Exception {
        Wheel wheel = new Wheel(marca,diametro);
        wheelsFactory.addWheel(wheel);
        wheelsFactory.addWheel(wheel);
    }

    /**
     * Añade al vehiculo de tipo Car dos listado, uno con las ruedas delanteras y otro con las traseras
     * @throws Exception
     */
    public void addWheelsVehicle() throws Exception {
        Car currentCar= (Car) repository.getCurrentVehicle();
        currentCar.addWheels(wheelsFactory.getFrontWheels(), wheelsFactory.getBackWheels());
        wheelsFactory.clearWheels();
    }

    /**
     * Imprime la informacion de cada objeto de tipo Vehicle, almacenados en la capa de persistencia
     * @return String, con la info de todos los vehiculos del repositorio
     */
    public String getAllVehicles() {
        String infoVehicles = "";
        for (Vehicle vehicle : repository.getAllVehicles()) {
            infoVehicles = infoVehicles.concat(vehicle.toString().concat("\n"));
        }
        return infoVehicles;
    }

}
