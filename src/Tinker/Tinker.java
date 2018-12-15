package Tinker;

import javax.swing.*;
import java.awt.*;

/*

Buggy when getting the Image using Toolkit, but works fine using ImageIcon's getImage().

*/

public class Tinker {
    Toolkit awt;
    int frameWidth;
    int frameHeight;
    JFrame frame;
    JPanel framePanel;
    JPanel displayPanel;
    String displayPanelBackgroundImageAddress;
    Image displayPanelBackgroundImage;
    //ImageIcon ii;

    public Tinker() {
        initMemberVariables();
    }

    class DisplayPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(displayPanelBackgroundImage, 0, 0,
                    (int)(framePanel.getWidth()*(0.85)), (int)(framePanel.getHeight()*(0.75)),
                    0, 0, 1920, 1080, null);
        }
    }

    public void initMemberVariables() {
        awt = Toolkit.getDefaultToolkit();
        frameWidth = (int)awt.getScreenSize().getWidth();
        frameHeight = (int)awt.getScreenSize().getHeight()-38;      // -38 pixels to account for window/start bar
        displayPanelBackgroundImageAddress = "src/CountZeroInit/model/icons/cyberpunk_wallpapers(1920x1080).jpg";
        displayPanelBackgroundImage = awt.getImage(displayPanelBackgroundImageAddress);

        //ii = new ImageIcon(displayPanelBackgroundImageAddress);
        //displayPanelBackgroundImage = ii.getImage();

        frame = new JFrame("Tinker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        framePanel = new JPanel();
        framePanel.setSize(frameWidth, frameHeight);
        framePanel.setLayout(null);
        System.out.println("framePanel width&height: " + framePanel.getWidth() + ", " + framePanel.getHeight());

/*
        char snail = 'l';
        System.out.println("hello, " + snail + "!");
*/

        displayPanel = new DisplayPanel();
        displayPanel.setSize((int)(framePanel.getWidth()*(0.85)), (int)(framePanel.getHeight()*(0.75)));
        displayPanel.setLayout(null);
        displayPanel.setFocusable(true);
        System.out.println("displayPanel width&height: " + displayPanel.getWidth() + ", " + displayPanel.getHeight());

        framePanel.add(displayPanel);
        displayPanel.setLocation((framePanel.getWidth()/2)-(displayPanel.getWidth()/2), 50);

        framePanel.setVisible(true);
        displayPanel.setVisible(true);

        frame.setContentPane(framePanel);
        frame.setVisible(true);
        frame.repaint();
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater( new Runnable(){
            public void run() {
                Tinker tinkerer = new Tinker();
            }
        } );
    }

}
