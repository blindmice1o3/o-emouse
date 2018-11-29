package CountLegacyInit.GameTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventDispatchThread {

    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        } );
    }

    public static void createAndShowGUI() {
        System.out.println("Created GUI on EDT (Event Dispatch Thread)? " +
            SwingUtilities.isEventDispatchThread());
        JFrame frame = new JFrame("Swing Paint Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new MyPanel() );
        frame.pack();
        frame.setVisible(true);
    }
}

class MyPanel extends JPanel {
    private int squareX = 50;
    private int squareY = 50;
    private int squareW = 20;
    private int squareH = 20;

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        addMouseListener( new MouseAdapter() {
           public void mousePressed(MouseEvent e) {
               moveSquare(e.getX(), e.getY());
           }
        });
        addMouseMotionListener( new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                moveSquare(e.getX(), e.getY());
            }
        });
    }
    private void moveSquare(int x, int y) {
        int OFFSET = 1;
        if ((squareX!=x) || (squareY!=y)) {
            repaint(squareX, squareY, squareW+OFFSET, squareH+OFFSET);
            squareX = x;
            squareY = y;
            repaint(squareX, squareY, squareW+OFFSET, squareH+OFFSET);
        }
    }

    // this is ***overriding*** getPreferredSize().
    public Dimension getPreferredSize() {
        return new Dimension(250, 200);
    }

    // this is overriding paintComponent(Graphics g).
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("This is my custom Panel!", 10, 20);
        g.setColor(Color.RED);
        g.fillRect(squareX, squareY, squareW, squareH);
        g.setColor(Color.BLACK);
        g.drawRect(squareX, squareY, squareW, squareH);
    }
}
