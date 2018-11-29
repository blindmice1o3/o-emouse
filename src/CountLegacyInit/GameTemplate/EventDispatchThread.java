package CountLegacyInit.GameTemplate;

import javax.swing.*;
import java.awt.*;

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

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    // this is ***overriding*** getPreferredSize().
    public Dimension getPreferredSize() {
        return new Dimension(250, 200);
    }

    // this is overriding paintComponent(Graphics g).
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("This is my custom Panel!", 10, 20);
    }
}
