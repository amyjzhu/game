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
        nameText.setOpaque(false);
        nameText.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createRigidArea(new Dimension(800,1000)));
        this.add(Box.createVerticalGlue());
        this.setBackground(Color.WHITE);
        int width = this.getWidth();
        this.setOpaque(false);

        JPanel boxColour = new JPanel();
        boxColour.setLayout(new BorderLayout());
        boxColour.add(nameText);
        boxColour.setBackground(Color.pink);
        boxColour.setOpaque(true);
        boxColour.setMaximumSize(new Dimension(1300,300));

        this.add(boxColour);
        nameText.setPreferredSize(new Dimension(width,100));
    }

    public void updateText(String text) {
        nameText.setText(text);
    }
}
