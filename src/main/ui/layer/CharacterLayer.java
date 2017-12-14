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
    JPanel positioner;
    Component rightRigidArea;

    public CharacterLayer() {
        ImageAsset aigis = new ImageAsset("aigis.png");
        positioner = new JPanel();
        positioner.setLayout(new BoxLayout(positioner, BoxLayout.X_AXIS));
        rightRigidArea = Box.createRigidArea(new Dimension(800,0));
        positioner.add(Box.createRigidArea(new Dimension(800, 0))); // get the full height
        positioner.add(aigis, BorderLayout.PAGE_END);
        positioner.add(Box.createVerticalGlue());
        positioner.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        aigis.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        positioner.setOpaque(false);
        positioner.setBackground(Color.blue);

        this.setBackground(Color.green);
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(0,5500));
        // bandaid solution to not being able to BorderLayer.CENTER and OverlayLayout simultaneously
        this.add(positioner, BorderLayout.SOUTH);
    }

    public void addCharacter(String path) {
        positioner.remove(rightRigidArea); // probab;y don;t have to make a new one
        rightRigidArea = Box.createRigidArea(new Dimension(400,0));
        ImageAsset newChar = new ImageAsset(path);
        positioner.add(rightRigidArea);
        positioner.add(newChar, BorderLayout.WEST);
        revalidate();
    }

}
