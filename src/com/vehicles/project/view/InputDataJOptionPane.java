package com.vehicles.project.view;

import javax.swing.*;

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

    public String getData() {
        this.data = (String)JOptionPane.showInputDialog(frame, inputData,title,JOptionPane.INFORMATION_MESSAGE,null,null,defaultValue);
        return data;
    }



}


