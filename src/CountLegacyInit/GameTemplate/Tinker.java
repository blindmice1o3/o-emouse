package CountLegacyInit.GameTemplate;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Tinker {
    Toolkit awt;
    int frameWidth;
    int frameHeight;
    JFrame frame;
    JPanel framePanel;
    JPanel displayPanel;
    String displayPanelBackgroundImageAddress;
    Image displayPanelBackgroundImage;

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
        displayPanelBackgroundImageAddress = "src/MoonRocks_ItsNotWhatYoureThinking/cyberpunk_wallpapers(1920x1080).jpg";
        displayPanelBackgroundImage = awt.getImage(displayPanelBackgroundImageAddress);

        frame = new JFrame("Tinker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        framePanel = new JPanel();
        framePanel.setSize(frameWidth, frameHeight);
        framePanel.setLayout(null);
        System.out.println("framePanel width&height: " + framePanel.getWidth() + ", " + framePanel.getHeight());

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
