package main.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by gijin on 2017-12-09.
 */
public class ImageAsset extends JPanel {

    private BufferedImage image;

    public ImageAsset(String fileName) {
            ImageIcon image = new ImageIcon("resources/assets" + fileName);
            JLabel label = new JLabel("", image, JLabel.CENTER);
        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.CENTER);
    };

}
