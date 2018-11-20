package MoonRocks_ItsNotWhatYoureThinking;

import javax.swing.*;
import java.awt.*;

public class CyberpunkWallpapersPanel extends JPanel {
    int width;
    int height;
    String imageFileName;

    ImageIcon backgroundImageIcon;
    Image backgroundImage;

    public CyberpunkWallpapersPanel(int width, int height) {
        this.width = width;
        this.height = height;
        imageFileName = "src/MoonRocksItsNotWhatYoureThinking/cyberpunk_wallpapers(1920x1080).jpg";

        backgroundImageIcon = new ImageIcon(imageFileName);
        backgroundImage = backgroundImageIcon.getImage();

        this.setPreferredSize(new Dimension(this.width, this.height));
        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 1, 1, this.width, this.height, 0, 0, 1920, 1080, null);
    }
}