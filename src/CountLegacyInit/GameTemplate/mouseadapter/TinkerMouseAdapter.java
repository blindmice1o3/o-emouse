package CountLegacyInit.GameTemplate.mouseadapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TinkerMouseAdapter implements MouseListener, MouseMotionListener {
    private Toolkit awt;
    private int frameWidth;
    private int frameHeight;

    private JFrame frame;
    private JPanel mainPanel;
    private JPanel displayPanel;
    private JPanel controlPanel;

    public TinkerMouseAdapter() {
        awt = Toolkit.getDefaultToolkit();
        frameWidth = awt.getScreenSize().width;
        frameHeight = awt.getScreenSize().height - 37;

        displayPanel = new TinkerMouseAdapterBackground();
        displayPanel.setSize(frameWidth, frameHeight);
        displayPanel.setVisible(true);

        controlPanel = new JPanel();
        controlPanel.setBackground( Color.YELLOW );

        mainPanel = new JPanel();
        mainPanel.setLayout( new BorderLayout() );
        mainPanel.setPreferredSize( new Dimension(frameWidth, frameHeight) );
        mainPanel.add(displayPanel, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.PAGE_END);
        mainPanel.setRequestFocusEnabled(true);
        mainPanel.setFocusable(true);
        mainPanel.setVisible(true);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setContentPane(mainPanel);
        frame.setVisible(true);



    }
    public static void main(String[] args) {
        TinkerMouseAdapter test = new TinkerMouseAdapter();
    }

    /////////////// MouseEvent methods ///////////////////

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
