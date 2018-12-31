package tinker.count_legacy_init;

import javax.swing.*;
import java.awt.*;

public class BackgroundDisplayPanel extends JPanel {

    String backgroundDisplayImageAddress;
    ImageIcon backgroundDisplayImageIcon;
    Image backgroundDisplayImage;

    public BackgroundDisplayPanel(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));

        backgroundDisplayImageAddress = "src/count_zero_init/model/icons/cyberpunk_wallpapers(1920x1080).jpg";
        backgroundDisplayImageIcon = new ImageIcon(backgroundDisplayImageAddress);
        backgroundDisplayImage = backgroundDisplayImageIcon.getImage();

        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(backgroundDisplayImage, 0, 0, this.getWidth(), this.getHeight(), 0, 0, 1920, 1080, null);
    }
}
