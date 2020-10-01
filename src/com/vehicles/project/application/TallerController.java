package com.vehicles.project.application;

import com.vehicles.project.domain.Bike;
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
     * Crea un objeto de tipo Car o de tipo Bike en funcion del parametro vehicleType, lo añade a la capa de
     * persistencia y fija el total de ruedas que tiene al objeto creado Car(4), Bike(2)
     * @param matricula, parametro del constructor de la clase padre Vehicle, extendida por las clases Car y Bike
     * @param marca, parametro del constructor de la clase padre Vehicle, extendida por las clases Car y Bike
     * @param color, parametro del constructor de la clase padre Vehicle, extendida por las clases Car y Bike
     * @param vehicleType, String para identificar el tipo de vehiculo, car o bike
     * @throws Exception
     */
    public void createVehicle(String matricula, String marca, String color, String vehicleType) throws Exception {
        if(vehicleType.toUpperCase().equals(Car.VEHICLE_TYPE)){
            Vehicle car=new Car(matricula,marca,color);
            repository.addVehicle(car);
            wheelsFactory.setTotalWheels(WheelsFactory.TotalWheelsVehicle.CAR.getNumWheels());
        }else if(vehicleType.toUpperCase().equals(Bike.VEHICLE_TYPE)){
            Vehicle bike=new Bike(matricula,marca,color);
            repository.addVehicle(bike);
            wheelsFactory.setTotalWheels(WheelsFactory.TotalWheelsVehicle.BICKE.getNumWheels());
        }

    }

    /**
     * Crea un objeto de tipo Wheel y lo añade 1 ó 2 veces al listado de objetos Wheel de la clase
     * WheelsFactory, en funcion de si son ruedas para un objeto tipo Car(crea 2 ruedas delanteras o traseras)
     * o tipo Bike(crea 1 rueda delantera o trasera)
     * @param marca, parametro del constructor de la clase Wheel
     * @param diametro, parametro del constructor de la clase Wheel
     * @param vehicleType, String para identificar el tipo de vehiculo, car o bike
     * @throws Exception
     */
    public void createWheel(String marca, double diametro, String vehicleType) throws Exception {
        Wheel wheel = new Wheel(marca,diametro);
        if(vehicleType.toUpperCase().equals(Car.VEHICLE_TYPE)){
            wheelsFactory.addWheel(wheel);
            wheelsFactory.addWheel(wheel);
        }else if(vehicleType.toUpperCase().equals(Bike.VEHICLE_TYPE)){
            wheelsFactory.addWheel(wheel);
        }
    }

    /**
     * Añade a un objeto hijo de la clase vehiculo, las ruedas delanteras y traseras, en funcion del parametro
     * vehicleType añade 4 ruedas si el objeto es de tipo Car 2 ruedas si es de tipo Bike
     * @param vehicleType, String para identificar el tipo de vehiculo, car o bike
     * @throws Exception
     */
    public void addWheelsVehicle(String vehicleType) throws Exception {
        if(vehicleType.toUpperCase().equals(Car.VEHICLE_TYPE)){
            Car currentCar= (Car) repository.getCurrentVehicle();
            currentCar.addWheels(wheelsFactory.getFrontWheels(), wheelsFactory.getBackWheels());
            wheelsFactory.clearWheels();
        }else if(vehicleType.toUpperCase().equals(Bike.VEHICLE_TYPE)){
            Bike currentBike= (Bike) repository.getCurrentVehicle();
            currentBike.addWheels(wheelsFactory.getFrontWheels(), wheelsFactory.getBackWheels());
            wheelsFactory.clearWheels();
        }

    }

    /**
     * Llama al metodo staic checkPlate() implementado en la clase abstracta Vehicle, para ckeckear si
     * una matricula es o no valida. Se aplica tanto a la subcalse Car como a la subclase Bike
     * @param matricula, valor a checkear
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
     * una matricula valida de forma aleatoria.Se aplica tanto a la subcalse Car como a la subclase Bike
     * @return String con la matricula generada valida
     */
    public String generaPlate() {

        return Vehicle.generaPlate();
    }

    /**
     * Llama al metodo static checkDiameter implementado en la clase Wheel, para checkear si
     * el diametro de una rueda cumple con los requisitos de tamaño mínimo y máximo establecidos
     * @param diameter, valor a chekear
     * @return true si el tamaños del diametro es valido, false si no lo es
     */
    public boolean checkDiameter(String diameter){
        boolean diameterOk=true;
        if(!Wheel.checkDiameter(diameter)){
            diameterOk=false;
        }
        return diameterOk;
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
