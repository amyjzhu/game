package main.ui.layer;

import main.ui.ImageAsset;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gijin on 2017-12-10.
 */
public class BackgroundLayer extends Layer {

    ImageAsset background;

    public BackgroundLayer(String file) {
        background = new ImageAsset(file);
        // resize!!!
        // https://stackoverflow.com/questions/10634417/image-resize-to-fit-on-jpanel ?
        this.add(background);
        this.setPreferredSize(new Dimension(1000,1000));
        this.setLayout(new OverlayLayout(this));
        this.setOpaque(false);
    }

}
