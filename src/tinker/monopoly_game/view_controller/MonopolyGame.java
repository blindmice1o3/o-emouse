package tinker.monopoly_game.view_controller;

import tinker.monopoly_game.model.board.MonopolyBoard;
import tinker.monopoly_game.model.board.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MonopolyGame extends JFrame {

    private MonopolyBoard monopolyBoard;
    List<Tile> board;
    List<JLabel> listOfBorder;
    private int player1BoardPosition = 0;

    private JLayeredPane monopolyLayeredPane;
    private MonopolyFuturamaPanel monopolyFuturamaPanel;

    public MonopolyGame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1360, 400);
        setTitle("Monopoly - Futurama Edition");
        setLocationRelativeTo(null);


        monopolyBoard = new MonopolyBoard();
        board = monopolyBoard.getBoard();

        monopolyLayeredPane = new JLayeredPane();
        monopolyLayeredPane.setPreferredSize( new Dimension(1360, 400) );
        monopolyLayeredPane.setBorder( BorderFactory.createTitledBorder("+++ Using JLayeredPane +++") );
        setContentPane(monopolyLayeredPane);

        monopolyFuturamaPanel = new MonopolyFuturamaPanel();

        monopolyLayeredPane.add(monopolyFuturamaPanel, new Integer(0), 1);



        listOfBorder = new ArrayList<JLabel>(11);
        Point origin = new Point(1169, 30);
        int offsetX = 111;

        System.out.println("board's size: " + board.size());
        System.out.println("listOfBorder's size: " + listOfBorder.size());

        for (int i = 0; i < 11; i++) {
            for (Tile tile: board) {

                if (i == tile.getBoardPosition()) {

                    if (tile.getBoardPosition() == 0 || tile.getBoardPosition() == 10) {
                        listOfBorder.add(tile.getBoardPosition(), null);
                    } else {
                        JLabel label;

                        origin.x = origin.x - (offsetX * tile.getBoardPosition());
                        label = createColoredTileBorder(origin);
                        origin.x = 1169;

                        listOfBorder.add(tile.getBoardPosition(), label);
                    }

                }

            }
        }

        System.out.println("board's size: " + board.size());
        System.out.println("listOfBorder's size: " + listOfBorder.size());

        for (JLabel label: listOfBorder) {
            if (label != null) {
                monopolyLayeredPane.add(label, new Integer(0), 0);
            }
        }

        //monopolyLayeredPane.moveToBack(listOfBorder.get(0));

        //monopolyLayeredPane.moveToBack(listOfBorder.get(1));
        monopolyLayeredPane.moveToBack(listOfBorder.get(2));
        //monopolyLayeredPane.moveToBack(listOfBorder.get(3));
        //monopolyLayeredPane.moveToBack(listOfBorder.get(4));
        monopolyLayeredPane.moveToBack(listOfBorder.get(5));
        //monopolyLayeredPane.moveToBack(listOfBorder.get(6));
        //monopolyLayeredPane.moveToBack(listOfBorder.get(7));
        monopolyLayeredPane.moveToBack(listOfBorder.get(8));
        //monopolyLayeredPane.moveToBack(listOfBorder.get(9));

        //monopolyLayeredPane.moveToBack(listOfBorder.get(10));


        setVisible(true);
    } // **** end MonopolyGame() constructor ****

    public static void main(String[] args) {
        new MonopolyGame();
    } // **** end main(String[]) ****

    private JLabel createColoredTileBorder(Point origin) {
        JLabel label = new JLabel();
        label.setBorder( BorderFactory.createLineBorder(Color.YELLOW, 3) );
        label.setBounds(origin.x, origin.y, 111, 300);
        return label;
    }

    class MonopolyFuturamaPanel extends JPanel {
        Image futuramaBoardImage;
        String futuramaBoardImageAddress;

        public MonopolyFuturamaPanel() {
            futuramaBoardImageAddress = "src/tinker/monopoly_game/view_controller/monopoly_board-futurama_edition_(1600x1600).jpg";
            futuramaBoardImage = new ImageIcon(futuramaBoardImageAddress).getImage();
            this.setSize( new Dimension(1340, 330) );
        } // **** end MonopolyFuturamaPanel() constructor ****

        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(futuramaBoardImage, 2, 30, 1340, 330,
                                            0, 1400, 1600, 1600, null);

        } // **** end paintComponent(Graphics) ****
    } // **** end MonopolyFuturamaPanel inner-class ****

} // **** end MonopolyGame class ****
