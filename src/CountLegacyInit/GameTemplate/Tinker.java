package CountLegacyInit.GameTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Tinker {
    Toolkit awt;
    int frameWidth;
    int frameHeight;
    JFrame frame;
    JPanel framePanel;
    JMenuBar frameMenuBar;
    JMenu frameBackgroundColorMenu;
    JMenuItem colorRadioButtonMenuItem;

    JPanel displayPanel;
    JPanel buttonsPanel;

    String displayPanelBackgroundImageAddress;
    Image displayPanelBackgroundImage;
    ImageObserver displayPanelBackgroundImageImageObserver;


    JButton upButton;
    JButton downButton;
    JButton leftButton;
    JButton rightButton;
    JButton aButton;
    JButton bButton;
    JButton selectButton;
    JButton startButton;

    public Tinker() {
        initMemberVariables();
        startTinker();
    }

    class DisplayPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(displayPanelBackgroundImage, 0, 0, this.getWidth(), this.getHeight(),
                    0, 0, displayPanelBackgroundImage.getWidth(displayPanelBackgroundImageImageObserver),
                    displayPanelBackgroundImage.getHeight(displayPanelBackgroundImageImageObserver), null);
        }
    }
    class DisplayPanelBackgroundImageImageObserver
            implements ImageObserver {
        @Override
        public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
            return false;
        }
    }

    public void initMemberVariables() {
        awt = Toolkit.getDefaultToolkit();
        frameWidth = (int)awt.getScreenSize().getWidth();
        frameHeight = (int)awt.getScreenSize().getHeight()-38;
        frame = new JFrame("Tinker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePanel = new JPanel();
        frameMenuBar = new JMenuBar();
        frameBackgroundColorMenu = new JMenu("GameboyColor's Color");
        colorRadioButtonMenuItem = new JRadioButtonMenuItem();
        frameBackgroundColorMenu.add(colorRadioButtonMenuItem);
        frameMenuBar.add(frameBackgroundColorMenu);

        frame.setSize(frameWidth, frameHeight);
        framePanel.setSize(frameWidth, frameHeight);
        framePanel.setVisible(true);
        System.out.println("framePanel width&height: " + framePanel.getWidth() + ", " + framePanel.getHeight());

        displayPanelBackgroundImageAddress = "src/MoonRocks_ItsNotWhatYoureThinking/cyberpunk_wallpapers(1920x1080).jpg";
        displayPanelBackgroundImage = awt.getImage(displayPanelBackgroundImageAddress);
        displayPanelBackgroundImageImageObserver = new DisplayPanelBackgroundImageImageObserver();

        displayPanel = new DisplayPanel();
        displayPanel.setSize((int)(framePanel.getWidth()*(0.60)), (int)(framePanel.getHeight()*(0.80)));
        System.out.println("displayPanel width&height: " + displayPanel.getWidth() + ", " + displayPanel.getHeight());
        displayPanel.setLayout(null);
        displayPanel.setVisible(true);
        displayPanel.repaint();

        buttonsPanel = new JPanel();
        buttonsPanel.setSize((int)(framePanel.getWidth()*(0.60)),(int)(framePanel.getHeight()*(0.20)));
        System.out.println("buttonsPanel width&height: " + buttonsPanel.getWidth() + ", " + buttonsPanel.getHeight());
        buttonsPanel.setLayout(new GridLayout(3, 16));
        buttonsPanel.add(new JButton("helloWORLD"));
        buttonsPanel.setVisible(true);

        framePanel.setLayout(null);
        framePanel.add(displayPanel);
        framePanel.add(buttonsPanel);
        displayPanel.setLocation((int)(framePanel.getWidth()/2)-(displayPanel.getWidth()/2), 6);
        buttonsPanel.setLocation((int)(framePanel.getWidth()/2)-(buttonsPanel.getWidth()/2), (int)(framePanel.getHeight()*(0.80))+8);


        frame.setJMenuBar(frameMenuBar);
        frame.setContentPane(framePanel);
        framePanel.repaint();
    }

    public void startTinker() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Tinker tinkerer = new Tinker();

    }
}
