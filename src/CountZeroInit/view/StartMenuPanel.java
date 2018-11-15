package CountZeroInit.view;

import CountZeroInit.controller.CountZeroInit;

import javax.swing.*;
import java.awt.*;

public class StartMenuPanel extends JPanel {
    CountZeroInit countZeroInit;
    String arrowImageAddress;
    Image arrowImage;

    public StartMenuPanel(CountZeroInit countZeroInit) {
        this.countZeroInit = countZeroInit;
        arrowImageAddress = "src/CountZeroInit/model/menuicons/right_arrow.png";
        arrowImage = new ImageIcon(arrowImageAddress).getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(arrowImage, 425, 80, 440, 95, 0, 0, 120, 120, null);

        g2d.drawString("START_MENU_PANEL", 450, 50);
        g2d.drawString(countZeroInit.getMonsterListState().toString(), 450, 90);
        g2d.drawString(countZeroInit.getMyMonsterListState().toString(), 450, 130);
        g2d.drawString(countZeroInit.getItemListState().toString(), 450, 170);
    }
}
