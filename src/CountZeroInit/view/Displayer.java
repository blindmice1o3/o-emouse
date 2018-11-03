package CountZeroInit.view;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.model.map.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Displayer {
    GameboyColor gb;
    Map map;

    public Displayer(GameboyColor gb, Map map) {
        this.gb = gb;
        this.map = map;
    }

    public void initiate() {
        JFrame frame = new JFrame();
        frame.setSize(400, 600);

        MyDrawPanel panel = new MyDrawPanel(gb);
        frame.getContentPane().add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
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