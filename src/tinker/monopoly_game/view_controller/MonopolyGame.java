package tinker.monopoly_game.view_controller;

import javax.swing.*;
import java.awt.*;

public class MonopolyGame extends JFrame {

    private MonopolyFuturamaPanel monopolyFuturamaPanel;

    public MonopolyGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1360, 400);
        setTitle("Monopoly - Futurama Edition");
        setLocationRelativeTo(null);

        monopolyFuturamaPanel = new MonopolyFuturamaPanel();
        setContentPane(monopolyFuturamaPanel);

        setVisible(true);
    } // **** end MonopolyGame() constructor ****

    public static void main(String[] args) {
        new MonopolyGame();
    } // **** end main(String[]) ****

    class MonopolyFuturamaPanel extends JPanel {
        Image futuramaBoardImage;
        String futuramaBoardImageAddress;

        public MonopolyFuturamaPanel() {
            futuramaBoardImageAddress = "src/tinker/monopoly_game/view_controller/monopoly_board-futurama_edition_(1600x1600).jpg";
            futuramaBoardImage = new ImageIcon(futuramaBoardImageAddress).getImage();
        } // **** end MonopolyFuturamaPanel() constructor ****

        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(futuramaBoardImage, 2, 30, 1340, 330,
                                            0, 1400, 1600, 1600, null);
        } // **** end paintComponent(Graphics) ****
    } // **** end MonopolyFuturamaPanel inner-class ****

} // **** end MonopolyGame class ****
