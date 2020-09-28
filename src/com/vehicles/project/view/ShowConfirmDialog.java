package com.vehicles.project.view;

import javax.swing.*;

/**
 * Clase de la capa de la vista
 */
public class ShowConfirmDialog extends Frame{

    ShowConfirmDialog() {
    }

    /**
     * Abre una ventana de confirmacion YES_NO_OPTION
     * @return un valor numerico que representa la respuesta introducida
     */
    public int getConfirmDialog() {
        int a = JOptionPane.showConfirmDialog(frame, "Quiere introducir otro vehiculo?\n\n"
                +"Hotkey: Alt+Y (Yes) Alt+N (No) \n"
                +"Hotkey: Tab+Space", "Introduzca mas vehiculos",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        return a;
    }
}
