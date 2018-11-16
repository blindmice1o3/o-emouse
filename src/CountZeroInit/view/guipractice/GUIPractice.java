package CountZeroInit.view.guipractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPractice {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JButton aButton = new JButton("A");
        JButton bButton = new JButton("B");

        aButton.addActionListener(new AButtonListener());
        bButton.addActionListener(new BButtonListener());

        frame.getContentPane().add(BorderLayout.NORTH, aButton);
        frame.getContentPane().add(BorderLayout.SOUTH, bButton);
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
