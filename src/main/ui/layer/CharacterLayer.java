package main.ui.layer;

import main.ui.ImageAsset;

import java.awt.*;
import java.util.List;

/**
 * Created by gijin on 2017-12-10.
 */
public class CharacterLayer extends Layer {

    List<ImageAsset> characters;

    public CharacterLayer() {
        ImageAsset aigis = new ImageAsset("aigis.png");
        setLayout(new BorderLayout());
        this.add(aigis, BorderLayout.PAGE_END);
        this.setOpaque(false);
    }

}
