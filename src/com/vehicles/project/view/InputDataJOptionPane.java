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

    InputDataJOptionPane(String inputData,String title){
        this.inputData = inputData;
        this.title=title;
    }
    InputDataJOptionPane(String inputData, String title, String defaultValue){
        this.inputData = inputData;
        this.title=title;
        this.defaultValue=defaultValue;
    }

    /**
     * Abre una ventana para introducir datos
     * @return un String con la cadena de datos introducidos
     */
    public String getData() {
        this.data = (String)JOptionPane.showInputDialog(frame, inputData,title,JOptionPane.INFORMATION_MESSAGE,null,null,defaultValue);
        return data;
    }



}


