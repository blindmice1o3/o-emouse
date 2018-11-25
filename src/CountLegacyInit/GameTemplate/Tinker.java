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
        frameHeight = (int)awt.getScreenSize().getHeight();
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

        displayPanelBackgroundImageAddress = "src/CountLegacyInit/icons/butters_profchaos.jpg";
        displayPanelBackgroundImage = awt.getImage(displayPanelBackgroundImageAddress);
        displayPanelBackgroundImageImageObserver = new DisplayPanelBackgroundImageImageObserver();

        displayPanel = new DisplayPanel();
        displayPanel.setSize((frameWidth*(4/5)), (int)(frameHeight*0.80));
        displayPanel.setVisible(true);
        buttonsPanel = new JPanel();
        buttonsPanel.setSize((frameWidth*(4/5)),(int)(frameHeight*0.20));
        buttonsPanel.setLayout(new GridLayout(3, 16));
        buttonsPanel.add(new JButton("helloWORLD"));
        buttonsPanel.setVisible(true);

        framePanel.setLayout(new BorderLayout());
        framePanel.add(displayPanel, BorderLayout.CENTER);
        framePanel.add(buttonsPanel, BorderLayout.SOUTH);

        frame.setJMenuBar(frameMenuBar);
        frame.setContentPane(framePanel);
    }

    public void startTinker() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Tinker tinkerer = new Tinker();

    }
}
