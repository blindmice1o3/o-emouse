package MoonRocks_ItsNotWhatYoureThinking;

import javax.swing.*;
import java.awt.*;

public class CyberpunkWallpapersPanel extends JPanel {
    Image backgroundImage;

    public CyberpunkWallpapersPanel() {
        backgroundImage = new ImageIcon("src/MoonRocks_ItsNotWhatYoureThinking/cyberpunk_wallpapers(1920x1080).jpg").getImage();
        //setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 1, 1, 478, 358, 0, 0, 1920, 1080, null);
    }
}
