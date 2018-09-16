package com.semiceri;

import javax.swing.*;
import java.awt.*;

public class TransparentFrame extends JFrame{

JLabel infoLabel;

    public TransparentFrame(String info, int fontSize){
        super("Transparent Frame");
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setAlwaysOnTop(true);
        this.getContentPane().setLayout(new java.awt.BorderLayout());
        infoLabel = new JLabel(info);
        infoLabel.setForeground(Color.WHITE);
        infoLabel.setFont(new Font("Helvetica", Font.CENTER_BASELINE, fontSize));
        this.getContentPane().add(infoLabel, java.awt.BorderLayout.SOUTH);
        this.setLocation(300, 20);
        this.pack();
    }

    public void updateLabel(String info){
        infoLabel.setText(info);
    }


}
