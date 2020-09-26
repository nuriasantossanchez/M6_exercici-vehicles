package com.vehicles.project.view;

import javax.swing.*;

public class ShowConfirmDialog extends Frame{

    ShowConfirmDialog() {
    }

    public int getConfirmDialog() {
        int a = JOptionPane.showConfirmDialog(frame, "Quiere introducir otro vehiculo?\n\n"
                +"Hotkey: Alt+Y (Yes) Alt+N (No) \n"
                +"Hotkey: Tab+Space", "Introduzca mas vehiculos",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        return a;
    }
}
