package com.vehicles.project.application;
import com.vehicles.project.domain.Wheel;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de la capa de aplicacion
 */
public class WheelsFactory {

    private List<Wheel> backWheels = new ArrayList<>();
    private List<Wheel> frontWheels = new ArrayList<>();
    private int totalWheels;

    /**
     * Enum de la clase WheelsFactory que alamacena enteros como valores constantes
     * que contienen el numero de ruedas totales que tiene cada objeto de tipo Car y Bike
     */
    enum TotalWheelsVehicle {
        CAR(4),
        BICKE(2);

        private int numWheels;

        TotalWheelsVehicle(int numWheels) {
            this.numWheels=numWheels;
        }

        public int getNumWheels() {
            return numWheels;
        }
    }

    public WheelsFactory() {
    }

    public void setTotalWheels(int totalWheels) {
        this.totalWheels = totalWheels;
    }

    /**
     * Vacia los listados que contienen las ruedas delanteras y las traseras,
     * una vez se han añadido al Vehicle concreto correspondiente
     */
    public void clearWheels() {
        frontWheels.clear();
        backWheels.clear();
    }

    public List<Wheel> getBackWheels() {

        return backWheels;
    }

    public List<Wheel> getFrontWheels() {

        return frontWheels;
    }

    /**
     * Añade el objeto de tipo Wheel pasado como parametro, al listado que le sorresponda,
     * listado de ruedas traseras o listado de ruedas delanteras
     * @param wheel
     */
    public void addWheel(Wheel wheel){
        if(this.backWheels.isEmpty() || this.backWheels.size()!=this.totalWheels/2){
            this.backWheels.add(wheel);
        }else if (this.frontWheels.isEmpty() || this.frontWheels.size()!=this.totalWheels/2){
            this.frontWheels.add(wheel);
        }
    }

}


