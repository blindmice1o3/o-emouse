package tinker.monopoly_game.view_controller;

import tinker.monopoly_game.model.PairOfDices;
import tinker.monopoly_game.model.PlayerOfMonopoly;
import tinker.monopoly_game.model.board.MonopolyBoard;
import tinker.monopoly_game.model.board.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MonopolyGame extends JFrame {

    private MonopolyBoard monopolyBoard;
    private List<Tile> board;
    private List<JLabel> listOfBorder;

    private PairOfDices pairOfDices;

    private PlayerOfMonopoly player1;
    private Image player1Image;

    private JLayeredPane monopolyLayeredPane;
    private MonopolyFuturamaPanel monopolyFuturamaPanel;

    public MonopolyGame() {


        initMonopolyGame();


        //monopolyLayeredPane.moveToFront(listOfBorder.get(9));



    } // **** end MonopolyGame() constructor ****

    private void initMonopolyGame() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1360, 400);
        setTitle("Monopoly - Futurama Edition");
        setLocationRelativeTo(null);

        monopolyBoard = new MonopolyBoard();
        board = monopolyBoard.getBoard();

        pairOfDices = new PairOfDices();

        player1 = new PlayerOfMonopoly();
        player1Image = new ImageIcon(player1.getImageAddress()).getImage();


        monopolyLayeredPane = new JLayeredPane();
        monopolyLayeredPane.setPreferredSize( new Dimension(1360, 400) );
        monopolyLayeredPane.setBorder( BorderFactory.createTitledBorder("+++ Using JLayeredPane +++") );
        setContentPane(monopolyLayeredPane);


        monopolyFuturamaPanel = new MonopolyFuturamaPanel();
        monopolyLayeredPane.add(monopolyFuturamaPanel, new Integer(0), 1);


        listOfBorder = new ArrayList<JLabel>(11);
        Point origin = new Point(1169, 15);
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
                monopolyLayeredPane.add(label, new Integer(0), 2);
            }
        }


        PairOfDicesGUI pairOfDicesGUI = new PairOfDicesGUI();
        JButton diceButton = new JButton("roll pairOfDices");
        diceButton.setLocation( 1169-333+55, 320 );
        diceButton.setSize(125, 20);

        diceButton.addActionListener(pairOfDicesGUI);

        monopolyLayeredPane.add(pairOfDicesGUI, new Integer(1));
        monopolyLayeredPane.add(diceButton, new Integer(1));

        setVisible(true);
    }

    class PairOfDicesGUI extends JLabel implements ActionListener {

        public PairOfDicesGUI() {

            setLocation(1169-111, 315);
            setSize(281, 30);
            setOpaque(true);
            setBackground(Color.BLUE);
            setForeground(Color.YELLOW);
            setHorizontalAlignment(JLabel.CENTER);
            setVerticalAlignment(JLabel.CENTER);
            setBorder(BorderFactory.createLineBorder(Color.RED, 2));

        } // **** end PairOfDicesGUI() constructor ***

        @Override
        public void actionPerformed(ActionEvent e) {
            if (player1.getCurrentBoardPosition() != 0 && player1.getCurrentBoardPosition() != 10) {
                monopolyLayeredPane.moveToBack(listOfBorder.get(player1.getCurrentBoardPosition()));
            }

            int newRollOfDices = pairOfDices.rollPairOfDices();
            player1.setCurrentBoardPosition( player1.getCurrentBoardPosition() + newRollOfDices );
            setText( "[" + pairOfDices.getDice1() + "] and [" + pairOfDices.getDice2() + "]" +
                    " => pair: " + pairOfDices.getIsPair() );

            monopolyFuturamaPanel.repaint();

            if (player1.getCurrentBoardPosition() != 0 && player1.getCurrentBoardPosition() != 10) {
                monopolyLayeredPane.moveToFront(listOfBorder.get(player1.getCurrentBoardPosition()));
            }
        }
    }


    public static void main(String[] args) {
        new MonopolyGame();
    } // **** end main(String[]) ****

    private JLabel createColoredTileBorder(Point origin) {
        JLabel label = new JLabel();
        label.setBorder( BorderFactory.createLineBorder(Color.RED, 3) );
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
            g.drawImage(futuramaBoardImage, 2, 15, 1340, 315,
                                            0, 1400, 1600, 1600, null);


            g.drawImage(player1Image, 1169 - (111*player1.getCurrentBoardPosition()) + 20, 145,
                                    1169 - (111*player1.getCurrentBoardPosition()) + 70, 195,
                                        0, 0, 225, 225, null);
        } // **** end paintComponent(Graphics) ****
    } // **** end MonopolyFuturamaPanel inner-class ****

} // **** end MonopolyGame class ****
