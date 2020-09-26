package com.vehicles.project.application;
import com.vehicles.project.domain.Wheel;

import java.util.ArrayList;
import java.util.List;

public class WheelsFactory {



    private List<Wheel> backWheels = new ArrayList<>();
    private List<Wheel> frontWheels = new ArrayList<>();
    private int totalWheels;


    public WheelsFactory() {
    }

    public int getTotalWheels() {
        return totalWheels;
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


    public void addWheel(Wheel wheel, int num){
        if(backWheels.isEmpty() || backWheels.size()!=num/2){
            backWheels.add(wheel);
        }else if (frontWheels.isEmpty() || frontWheels.size()!=num/2){
            frontWheels.add(wheel);
        }
    }

}
