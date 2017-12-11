package main.ui.layer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gijin on 2017-12-10.
 */
public class TextLayer extends Layer {

    JLabel nameText;


    public TextLayer() {
        nameText = new JLabel();
        nameText.setText("Test");
        nameText.setBackground(Color.PINK);
        nameText.setOpaque(true);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(600,700)));
        this.add(Box.createVerticalGlue());
        this.add(nameText);
        this.setBackground(Color.WHITE);
        int width = this.getWidth();
        this.setOpaque(false);
        nameText.setPreferredSize(new Dimension(width,100));
    }

    public void updateText(String text) {
        nameText.setText(text);
    }
}
