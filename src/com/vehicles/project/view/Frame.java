package com.vehicles.project.view;

import javax.swing.*;

/**
 * Clase abstracta de la capa de la vista, la extienden las clases InputDataJOptionPane,
 * ShowMessageDialog y ShowConfirmDialog
 */
public abstract class Frame {

    JFrame frame;

    public Frame() {
        this.frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(500, 500);
    }
}
