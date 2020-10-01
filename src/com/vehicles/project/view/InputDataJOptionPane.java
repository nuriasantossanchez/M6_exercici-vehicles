package com.vehicles.project.view;

import javax.swing.*;

/**
 * Clase de la capa de la vista
 */
public class InputDataJOptionPane extends Frame{

    private String inputData;
    private String data;
    private String defaultValue;
    private String title;

    public static String[] vehicles = {
            "Car",
            "Bike"
    };


    InputDataJOptionPane(String inputData,String title){
        this.inputData = inputData;
        this.title=title;
    }


    InputDataJOptionPane(String inputData, String title, String defaultValue){
        this.inputData = inputData;
        this.title=title;
        this.defaultValue=defaultValue;
    }

    InputDataJOptionPane(String inputData, String title, String defaultValue, String[] vehicles){
        this.inputData = inputData;
        this.title=title;
        this.defaultValue=defaultValue;
        this.vehicles =vehicles;
    }

    /**
     * Abre un showInputDialog para introducir datos
     * @return un String con la cadena de datos introducidos
     */
    public String getData() {
        this.data = (String)JOptionPane.showInputDialog(Frame.getInstance(), inputData,title,JOptionPane.INFORMATION_MESSAGE,null,null,defaultValue);
        return data;
    }

    /**
     * Abre un showInputDialog con un JComboBox para mostrar las posibles opciones de seleccion para introducir datos
     * @return un String con la cadena de datos introducidos
     */
    public String getData(String[] vehicles) {
        this.data = (String)JOptionPane.showInputDialog(Frame.getInstance(), inputData,title,JOptionPane.INFORMATION_MESSAGE,null,vehicles,vehicles[0]);
        return data;
    }




}


