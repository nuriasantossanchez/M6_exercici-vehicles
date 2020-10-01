package com.vehicles.project.view;

import com.vehicles.project.application.TallerController;

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
        String inputDataTipoVehicle;

        inputDataTipoVehicle=getInputData("Seleccione el vehiculo que quiere crear", "SELECCIONE VEHICULO", InputDataJOptionPane.vehicles);
        while(inputDataTipoVehicle!=null){

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

            controller.createVehicle(inputDataMatricula, inputDataMarca, inputDataColor, inputDataTipoVehicle);

            inputDataBackWheelsMarca =getInputData("Introduzca la marca de las ruedas traseras","MARCA RUEDAS TRASERAS");
            inputDataBackWheelsDiametro =getInputData("Introduzca el diametro de las ruedas traseras\n\n"
                        + "Ha de ser superior a 0.4 e inferior a 4","DIAMETRO RUEDAS TRASERAS","2.2");

            try {
                if(!controller.checkDiameter((inputDataBackWheelsDiametro))){
                    inputDataBackWheelsDiametro="2.2";
                    new ShowMessageDialog("El diametro introducido no esta dentro del rango establecido\n"
                            + "Se le asignara un diametro por defecto con valor de 2.2");
                }
                controller.createWheel(inputDataBackWheelsMarca, Double.parseDouble(inputDataBackWheelsDiametro),inputDataTipoVehicle);
            }catch (NumberFormatException e){
                controller.createWheel(inputDataBackWheelsMarca, 2.2, inputDataTipoVehicle);
                new ShowMessageDialog("El valor introducido no es un valor numerico\n"
                        + "Se le asignara un diametro por defecto con valor de 2.2");
            }

            inputDataFrontWheelsMarca =getInputData("Introduzca la marca de las ruedas delanteras","MARCA RUEDAS DELANTERAS");
            inputDataFrontWheelsDiametro =getInputData("Introduzca el diametro de las ruedas delanteras\n\n"
                        +"Ha de ser superior a 0.4 e inferior a 4","DIAMETRO RUEDAS DELANTERAS","2.2");

            try {
                if(!controller.checkDiameter((inputDataFrontWheelsDiametro))){
                    inputDataFrontWheelsDiametro="2.2";
                    new ShowMessageDialog("El diametro introducido no esta dentro del rango establecido\n"
                            + "Se le asignara un diametro por defecto con valor de 2.2");
                }
                controller.createWheel(inputDataFrontWheelsMarca, Double.parseDouble(inputDataFrontWheelsDiametro), inputDataTipoVehicle);
            }catch (NumberFormatException e){
                controller.createWheel(inputDataFrontWheelsMarca, 2.2, inputDataTipoVehicle);
                new ShowMessageDialog("El diametro introducido no es un valor numerico\n"
                        + "Se le asignara un diametro por defecto con valor de 2.2");
            }

            controller.addWheelsVehicle(inputDataTipoVehicle);

            inputDataTipoVehicle=getInputData("Seleccione el vehiculo que quiere crear", "SELECCIONE VEHICULO", InputDataJOptionPane.vehicles);
        }

        printVehicles();
    }

    public static void printVehicles() {
        String allVehicles = controller.getAllVehicles();

        System.out.println(!allVehicles.isEmpty()?"VEHICLES: "+ "\n" + allVehicles + " \n":"");
    }

    /**
     * Muestra un showInputDialog para la entrada de datos del usuario, no permite blancos,
     * si el valor devuelto es un null (boton Canselar), termina la ejecucion
     * @param message, String con los datos de entrada que se le solicitan al usuario
     * @param title, String con el tiulo de la ventana
     * @return, un String con los datos introducidos por el usuario
     */
    public static String getInputData(String message, String title){
        String inputData;
        do {
            inputData=new InputDataJOptionPane(message,title).getData();
            if (null==inputData){
                printVehicles();
                System.exit(0);
            }
        }while(inputData.trim().isEmpty());
        return  inputData;
    }

    /**
     * Muestra un showInputDialog para la entrada de datos del usuario, no permite blancos,
     * si el valor devuelto es un null (boton Cancelar), termina la ejecucion
     * @param message, String con los datos de entrada que se le solicitan al usuario
     * @param title, String con el tiulo de la ventana
     * @param defaultValue, String con un valor por defecto
     * @return, un String con los datos introducidos por el usuario
     */
    public static String getInputData(String message, String title, String defaultValue){
        String inputData;
        do {
            inputData=new InputDataJOptionPane(message, title, defaultValue).getData();
            if (null==inputData){
                printVehicles();
                System.exit(0);
            }
        }while(inputData.trim().isEmpty());
        return  inputData;
    }

    /**
     * Muestra un showInputDialog para la entrada de datos del usuario,
     * si el valor devuelto es un null (boton Cancelar), termina la ejecucion
     * @param message, String con los datos de entrada que se le solicitan al usuario
     * @param title, String con el tiulo de la ventana
     * @param vehicles, Array de opciones, para la entrada de datos del usuario
     * @return
     */
    public static String getInputData(String message, String title, String[] vehicles){
        String inputData = new InputDataJOptionPane(message, title, vehicles[0], vehicles).getData(vehicles);
        if (null==inputData){
            printVehicles();
            System.exit(0);
        }
        return  inputData;
    }

}

