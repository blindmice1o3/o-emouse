package CountZeroInit.view;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.model.map.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Displayer {
    GameboyColor gb;
    Map map;
    JFrame frame;
    MyDrawPanel panel;

    public Displayer(GameboyColor gb, Map map) {
        this.gb = gb;
        this.map = map;

        frame = new JFrame();
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void refresh() {
        panel = new MyDrawPanel(gb);
        frame.getContentPane().add(panel);
/*
        JButton aButton = new JButton("A");
        JButton bButton = new JButton("B");

        aButton.addActionListener(new AButtonListener());
        bButton.addActionListener(new BButtonListener());

        frame.getContentPane().add(BorderLayout.NORTH, aButton);
        frame.getContentPane().add(BorderLayout.SOUTH, bButton);
*/
    }
}

class AButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button was pressed: A");
    }
}

class BButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button was pressed: B");
    }
}