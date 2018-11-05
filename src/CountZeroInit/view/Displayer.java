package CountZeroInit.view;

import CountZeroInit.controller.GameboyColor;
import CountZeroInit.model.map.Map;

import javax.swing.*;

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
    }
}