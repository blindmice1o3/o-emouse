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

        this.setVisible(true);
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 1, 1, this.getWidth(), this.getHeight(), 0, 0, 1920, 1080, null);
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
