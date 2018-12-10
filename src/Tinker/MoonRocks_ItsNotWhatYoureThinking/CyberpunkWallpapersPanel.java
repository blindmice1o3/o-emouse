package Tinker.MoonRocks_ItsNotWhatYoureThinking;

import javax.swing.*;
import java.awt.*;

public class CyberpunkWallpapersPanel extends JPanel {
    int width;
    int height;
    String imageFileName = "src/CountZeroInit/model/icons/cyberpunk_wallpapers(1920x1080).jpg";;
    Image backgroundImage;

    public CyberpunkWallpapersPanel(int width, int height) {
        this.width = width;
        this.height = height;

        backgroundImage = new ImageIcon(imageFileName).getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, width, height, 0, 0, 1920, 1080, null);
    }
}