package com.vehicles.project.view;

import javax.swing.*;
import java.awt.*;

/**
 * Clase abstracta de la capa de la vista, la extienden las clases InputDataJOptionPane,
 * ShowMessageDialog y ShowConfirmDialog
 */
public class Frame extends Component {

    private static Frame instance=null;

    Frame() {
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(500, 500);
    }

    public static Frame getInstance() {
        if (instance==null){
            instance=new Frame();
        }
        return instance;
    }
}
