package com.vehicles.project.view;

import javax.swing.*;

/**
 * Clase de la capa de la vista
 */
public class ShowMessageDialog extends Frame{

    ShowMessageDialog(String message) {

        JOptionPane.showMessageDialog(frame, message,"Entrada de datos no permitida", JOptionPane.WARNING_MESSAGE);
    }
}
