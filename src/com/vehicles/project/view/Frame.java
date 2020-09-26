package com.vehicles.project.view;

import javax.swing.*;

public abstract class Frame {

    JFrame frame;

    public Frame() {
        this.frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(500, 500);
    }
}
