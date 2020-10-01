package com.vehicles.project.view;

import javax.swing.*;

/**
 * Clase de la capa de la vista
 */
public class ShowMessageDialog extends Frame{

    ShowMessageDialog(String message) {
        JOptionPane.showMessageDialog(Frame.getInstance(), message,"ENTRADA DE DATOS NO PERMITIDA", JOptionPane.WARNING_MESSAGE);
    }
}
