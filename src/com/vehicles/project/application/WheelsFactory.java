package com.vehicles.project.application;
import com.vehicles.project.domain.Wheel;

import java.util.ArrayList;
import java.util.List;

public class WheelsFactory {

    private List<Wheel> backWheels = new ArrayList<>();
    private List<Wheel> frontWheels = new ArrayList<>();
    private int totalWheels;

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


    public void addWheel(Wheel wheel){
        if(this.backWheels.isEmpty() || this.backWheels.size()!=this.totalWheels/2){
            this.backWheels.add(wheel);
        }else if (this.frontWheels.isEmpty() || this.frontWheels.size()!=this.totalWheels/2){
            this.frontWheels.add(wheel);
        }
    }

}


