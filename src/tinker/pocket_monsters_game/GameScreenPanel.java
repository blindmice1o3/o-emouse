package tinker.pocket_monsters_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameScreenPanel extends JPanel
        implements KeyListener {

    public static final int GAME_SCREEN_PANEL_WIDTH = 320;
    public static final int GAME_SCREEN_PANEL_HEIGHT = 320;
    public static final int X_START = 960;
    public static final int Y_START = 3168;
    public static final int PIXEL_PER_KEY_PRESS = 8;

    private int gameFrameBorderOffsetWidth = 80;
    private int gameFrameBorderOffsetHeight = 40;

    private int gameFrameWidth;
    private int gameFrameHeight;
    private int xCurrent;
    private int yCurrent;

    Image playerImage;
    String playerImageAddress = "src/count_zero_init/model/icons/player.gif";
    Image mapImage;
    String mapImageAddress = "src/count_zero_init/model/icons/pokemon-gsc-kanto.png";

    /**
     * No-argument constructor creates an ImageIcon using the image found in the directory specified by mapImageAddress.
     * Also, the xCurrent and yCurrent (which tracks the top-left corner of the game screen [relative to where it should
     * be on the file represented by mapImage]) are initialized to pre-specified constants (X_START and Y_START).
     */
    public GameScreenPanel(int gameFrameWidth, int gameFrameHeight) {

        this.gameFrameWidth = gameFrameWidth;
        this.gameFrameHeight = gameFrameHeight;
        setSize( this.gameFrameWidth, this.gameFrameHeight );

        xCurrent = X_START;
        yCurrent = Y_START;
        ImageIcon playerImageIcon = new ImageIcon(playerImageAddress);
        playerImage = playerImageIcon.getImage();
        ImageIcon mapImageIcon = new ImageIcon(mapImageAddress);
        mapImage = mapImageIcon.getImage();

        setFocusable(true);
        addKeyListener(this);

    } // **** end GameScreenPanel() constructor ****

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                yCurrent = yCurrent - PIXEL_PER_KEY_PRESS;
                if (yCurrent < 0) {
                    yCurrent = 0;
                }
                repaint();
                break;
            case KeyEvent.VK_A:
                xCurrent = xCurrent - PIXEL_PER_KEY_PRESS;
                if (xCurrent < 0) {
                    xCurrent = 0;
                }
                repaint();
                break;
            case KeyEvent.VK_S:
                yCurrent = yCurrent + PIXEL_PER_KEY_PRESS;
                if (yCurrent > 4320-GAME_SCREEN_PANEL_HEIGHT) {
                    yCurrent = 4320-GAME_SCREEN_PANEL_HEIGHT;
                }
                repaint();
                break;
            case KeyEvent.VK_D:
                xCurrent = xCurrent + PIXEL_PER_KEY_PRESS;
                if (xCurrent > 4480-GAME_SCREEN_PANEL_WIDTH) {
                    xCurrent = 4480-GAME_SCREEN_PANEL_WIDTH;
                }
                repaint();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * paintComponent(Graphics) is overridden to paint a custom image (specified by mapImageAddress).
     */
    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(mapImage,
                gameFrameBorderOffsetWidth, gameFrameBorderOffsetHeight,
                gameFrameBorderOffsetWidth+GAME_SCREEN_PANEL_WIDTH, gameFrameBorderOffsetHeight+GAME_SCREEN_PANEL_HEIGHT,
                xCurrent, yCurrent, xCurrent+GAME_SCREEN_PANEL_WIDTH, yCurrent+GAME_SCREEN_PANEL_HEIGHT,
                null);
        g.drawImage(playerImage, gameFrameBorderOffsetWidth+((GAME_SCREEN_PANEL_WIDTH/2)-8), gameFrameBorderOffsetHeight+((GAME_SCREEN_PANEL_HEIGHT/2)-8),
                gameFrameBorderOffsetWidth+((GAME_SCREEN_PANEL_WIDTH/2)+8), gameFrameBorderOffsetHeight+((GAME_SCREEN_PANEL_HEIGHT/2)+8),
                0, 0, 16, 16, null);

    } // **** end paintComponent(Graphics) ****

} // **** end GameScreenPanel class ****
