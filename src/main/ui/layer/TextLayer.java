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

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(Box.createRigidArea(new Dimension(600,700)));
        this.add(Box.createVerticalGlue());
        this.add(nameText);
    }
}
