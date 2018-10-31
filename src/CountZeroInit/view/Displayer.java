package CountZeroInit.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Displayer {
    public static void main(String[] args) {
        Displayer d = new Displayer();
        d.initiate();
    }

    public void initiate() {
        JFrame frame = new JFrame();

        frame.setSize(400, 600);
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
        MyDrawPanel panel = new MyDrawPanel();
        frame.getContentPane().add(panel);
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