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

    public void drawIntroPanel() {
        JPanel startPanel = new JPanel();
        JButton startButton = new JButton("Press Start");
        startButton.addActionListener(new StartButtonListener());
        startPanel.add(startButton);
        frame.getContentPane().add(startPanel);
    }

    class StartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            gb.setCurrentState(gb.getIntroState());
            gb.getIntroState().startButtonPressed();

        }
    }

    public void redrawPanel() {
        panel = new MyDrawPanel(gb);
        frame.getContentPane().add(panel);

    }
}

