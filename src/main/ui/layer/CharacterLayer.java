package main.ui.layer;

import main.ui.ImageAsset;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by gijin on 2017-12-10.
 */
public class CharacterLayer extends Layer {

    List<ImageAsset> characters;

    public CharacterLayer() {
        ImageAsset aigis = new ImageAsset("aigis.png");
        JPanel positioner = new JPanel();
        positioner.setLayout(new BoxLayout(positioner, BoxLayout.X_AXIS));
        positioner.add(Box.createRigidArea(new Dimension(800, 0))); // get the full height
        positioner.add(aigis, BorderLayout.PAGE_END);
        positioner.add(Box.createHorizontalGlue());
        positioner.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        aigis.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        positioner.setOpaque(false);

        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.add(positioner, BorderLayout.SOUTH);
    }

}
