package CountLegacyInit.GameTemplate.mouseadapter;

import javax.swing.*;
import java.awt.*;

public class TinkerMouseAdapterBackground extends JPanel {
    String imageAddress = "src/MoonRocks_ItsNotWhatYoureThinking/cyberpunk_wallpapers(1920x1080).jpg";
    Image image;

    public TinkerMouseAdapterBackground() {
        Toolkit awt = Toolkit.getDefaultToolkit();
        image = awt.getImage(imageAddress);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("Image width/height: " + this.getWidth() + "/" + this.getHeight(), 1920/2, 1080/2);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), 0, 0, 1920, 1080, null);
    }
}
