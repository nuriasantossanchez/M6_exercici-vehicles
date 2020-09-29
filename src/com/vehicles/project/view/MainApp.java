package com.vehicles.project.view;

import com.vehicles.project.application.TallerController;

import javax.swing.*;

public class MainApp {

    private static TallerController controller =new TallerController();

    public static void main(String[] args) throws Exception{
        String inputDataMatricula;
        String inputDataMarca;
        String inputDataColor;
        String inputDataBackWheelsMarca;
        String inputDataBackWheelsDiametro;
        String inputDataFrontWheelsMarca;
        String inputDataFrontWheelsDiametro;

        do {
            inputDataMatricula= getInputData("Introduzca la matricula del vehiculo\n\n"
                        + "Ha de tener 4 numeros al incio\n"
                        + " y 2 o 3 letra en la parte final",
                        "MATRICULA");

            if(!controller.checkPlate(inputDataMatricula)){
                inputDataMatricula=controller.generaPlate();
                new ShowMessageDialog("La matricula introducida no es correcta\n"
                        + "Se le asignara una matricula por defecto con valor \n"
                        + inputDataMatricula);
            }

            inputDataMarca= getInputData("Introduzca la marca del vehiculo","MARCA");
            inputDataColor= getInputData("Introduzca el color del vehiculo","COLOR");

            controller.createCar(inputDataMatricula, inputDataMarca, inputDataColor);

            inputDataBackWheelsMarca =getInputData("Introduzca la marca de las ruedas traseras","MARCA RUEDAS TRASERAS");
            inputDataBackWheelsDiametro =getInputData("Introduzca el diametro de las ruedas traseras\n\n"
                        + "Ha de ser superior a 0.4 e inferior a 4","DIAMETRO RUEDAS TRASERAS","2.2");

            if(!controller.checkDiameter((inputDataBackWheelsDiametro))){
                inputDataBackWheelsDiametro="2.2";
                new ShowMessageDialog("El diametro introducido no esta dentro del rango establecido\n"
                        + "Se le asignara un diametro por defecto con valor de 2.2");
            }

            try {
                controller.createWheels(inputDataBackWheelsMarca, Double.parseDouble(inputDataBackWheelsDiametro));
            }catch (NumberFormatException e){
                controller.createWheels(inputDataBackWheelsMarca, 2.2);
                new ShowMessageDialog("El valor introducido no es numerico\n"
                        + "Se le asignara un diametro por defecto con valor de 2.2");
            }

            inputDataFrontWheelsMarca =getInputData("Introduzca la marca de las ruedas delanteras","MARCA RUEDAS DELANTERAS");
            inputDataFrontWheelsDiametro =getInputData("Introduzca el diametro de las ruedas delanteras\n\n"
                        +"Ha de ser superior a 0.4 e inferior a 4","DIAMETRO RUEDAS DELANTERAS","2.2");

            if(!controller.checkDiameter((inputDataFrontWheelsDiametro))){
                inputDataFrontWheelsDiametro="2.2";
                new ShowMessageDialog("El diametro introducido no esta dentro del rango establecido\n"
                        + "Se le asignara un diametro por defecto con valor de 2.2");
            }

            try {
                controller.createWheels(inputDataFrontWheelsMarca, Double.parseDouble(inputDataFrontWheelsDiametro));
            }catch (NumberFormatException e){
                controller.createWheels(inputDataFrontWheelsMarca, 2.2);
                new ShowMessageDialog("El diametro introducido no es correcto\n"
                        + "Se le asignara un diametro por defecto con valor de 2.2");
            }

            controller.addWheelsVehicle();

        }while(new ShowConfirmDialog().getConfirmDialog()== JOptionPane.YES_OPTION);

        String allVehicles = controller.getAllVehicles();

        System.out.println("VEHICLES: "+ "\n" + allVehicles + " \n");

        System.exit(0);
    }

    /**
     * Muestra un showInputDialog parala entrada de datos del usuario, no permite blancos,
     * si el valor devuelto es un nullo, el usuario pulsa Canselar, termina la ejecucion
     * @param message, un String con los datos de entrada que se le solicitan al usuario
     * @param title, un String con el tiulo de la ventana
     * @return, un String con los datos introducidos por el usuario
     */
    public static String getInputData(String message, String title){
        String inputData;
        do {
            inputData=new InputDataJOptionPane(message,title).getData();
            if (null==inputData) System.exit(0);
        }while(inputData.trim().isEmpty());
        return  inputData;
    }

    /**
     * Muestra un showInputDialog parala entrada de datos del usuario, no permite blancos,
     * si el valor devuelto es un nullo, el usuario pulsa Canselar, termina la ejecucion
     * @param message, un String con los datos de entrada que se le solicitan al usuario
     * @param title, un String con el tiulo de la ventana
     * @param defaultValue, un String con un valor por defecto
     * @return, un String con los datos introducidos por el usuario
     */
    public static String getInputData(String message, String title, String defaultValue){
        String inputData;
        do {
            inputData=new InputDataJOptionPane(message, title, defaultValue).getData();
            if (null==inputData) System.exit(0);
        }while(inputData.trim().isEmpty());
        return  inputData;
    }

}

