package main.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gijin on 2017-12-09.
 */
public class ImageAsset extends JPanel {

    public ImageAsset(String fileName) {

        ImageIcon imageIcon = new ImageIcon("resources/assets/" + fileName);
        Image image = imageIcon.getImage(); // transform it
        // hm, need a better way to scale
        Image newimg = image.getScaledInstance(515, 915,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        JLabel label = new JLabel("", imageIcon, JLabel.CENTER);
        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.CENTER);
    };
}
