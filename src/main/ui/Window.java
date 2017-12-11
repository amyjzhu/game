package main.ui;


import main.data.DialogueParser;
import main.ui.layer.TextLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gijin on 2017-12-07.
 */
public class Window extends JFrame {

    JPanel textPane;
    JLabel test;

    public Window() {
        init();
    }

    public void init() {
        getContentPane().setLayout(new OverlayLayout(getContentPane()));
        this.setMinimumSize(new Dimension(500,500));
        textPane = new TextLayer();
        JPanel mainPane = new JPanel();

        mainPane.setLayout(new OverlayLayout(mainPane));
        mainPane.setBackground(Color.WHITE);

        mainPane.add(textPane);

        JButton click = new JButton();
        click.setText("Click me for new text");
        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newVal = DialogueParser.load("simple.txt");
                DialogueParser.changeDisplayText(newVal);
            }
        });
        mainPane.add(click);

        getContentPane().add(mainPane);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void textInit() {

        getContentPane().setLayout(new OverlayLayout(getContentPane()));
        this.setMinimumSize(new Dimension(500,500));
        textPane = new JPanel();
        JPanel mainPane = new JPanel();

        mainPane.setLayout(new OverlayLayout(mainPane));
        mainPane.setBackground(Color.WHITE);

        textPane.setLayout(new OverlayLayout(textPane));
        textPane.setBackground(Color.GREEN);

        test = new JLabel();
        test.setText("Init");
        test.setBackground(Color.CYAN);
        test.setFont(Font.getFont("Comic Sans"));
        textPane.add(test);

        textPane.setPreferredSize(new Dimension(400, 100));
        mainPane.add(textPane);

        JButton click = new JButton();
        click.setText("Click me for new text");
        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newVal = DialogueParser.load("simple.txt");
                DialogueParser.changeDisplayText(newVal);
            }
        });
        mainPane.add(click);

        JButton click2 = new JButton();
        click2.setText("Click me to do whatever is specified in load.txt!");
        click2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newVal = DialogueParser.load("load.txt");
                DialogueParser.runScript(newVal);
            }
        });
        mainPane.add(click2);

        JPanel pic = new ImageAsset("aigis.png");
        mainPane.add(pic);

        getContentPane().add(mainPane);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void update(String newText) {
        test.setText(newText);
        validate();
    }



}
