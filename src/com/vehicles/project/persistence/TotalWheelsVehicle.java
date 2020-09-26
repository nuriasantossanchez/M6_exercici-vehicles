package com.vehicles.project.persistence;

public enum TotalWheelsVehicle {
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
