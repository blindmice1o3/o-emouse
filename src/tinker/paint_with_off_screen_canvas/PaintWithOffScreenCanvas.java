package tinker.paint_with_off_screen_canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.EnumSet;

public class PaintWithOffScreenCanvas extends JPanel {

    public static void main(String[] args) {

        JFrame frame = new JFrame("PaintWithOffScreenCanvas");
        PaintWithOffScreenCanvas panel = new PaintWithOffScreenCanvas();
        frame.setContentPane(panel);
        frame.setJMenuBar(panel.getMenuBar());
        frame.pack();
        frame.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation( (screenSize.width - frame.getWidth())/2,
                (screenSize.height - frame.getHeight())/2 );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    } // **** end main(String[]) ****

    private enum Tool { CURVE, LINE, RECT, OVAL, FILLED_RECT, FILLED_OVAL, SMUDGE, ERASE }

    private final static EnumSet<Tool> SHAPE_TOOLS = EnumSet.range(Tool.LINE, Tool.FILLED_OVAL);

    private Tool currentTool = Tool.CURVE;

    private Color currentColor = Color.BLACK;

    private Color fillColor = Color.WHITE;

    private BufferedImage OSC;

    private boolean dragging;

    private int startX, startY;

    private int currentX, currentY;

    /**
     * The constructor sets the preferred size of the panel to 640-by-480.
     * It also sets up mouse listeners.
     */
    public PaintWithOffScreenCanvas() {

        setPreferredSize( new Dimension(640, 480) );
        MouseHandler mouseHandler = new MouseHandler();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);

    } // **** end PaintWithOffScreenCanvas constructor ****

    /**
     * The paintComponent() method copies the off-screen canvas to the screen (first creating it, if necessary). If a
     * mouse drag is in progress, and the current tool is not Tool.CURVE, then the shape that the user is drawing is
     * drawn over the off-screen canvas. (This is to avoid making the shape a permanent part of the picture until after
     * the user releases the mouse. The effect is a "rubber band cursor" in which the shape changes as the user drags
     * the mouse, but the picture under the shape is not affected.)
     */
    public void paintComponent(Graphics g) {

        /* First create the off-screen canvas, if it does not already exist. */
        if (OSC == null) {
            createOSC();
        }

        /* Copy the off-screen canvas to the panel. Since we know that the image is already completely available, the
                fourth "ImageObserver" parameter to g.drawImage() can be null. Since the canvas completely fills the
                panel, there is no need to call super.paintComponent(g). */
        g.drawImage(OSC, 0, 0, null);

        /* If the user is currently dragging the mouse to drag a line, oval, or rectangle, draw the shape on top of the
                image from the off-screen canvas, using the current drawing color. (This is not done if the user is
                drawing a curve or using the smudge tool.) */
        if (dragging && SHAPE_TOOLS.contains(currentTool)) {
            g.setColor(currentColor);
            putCurrentShape(g);
        }

    } // **** end PaintWithOffScreenCanvas.paintComponent(Graphics) ****

    private void createOSC() {



    } // **** end PaintWithOffScreenCanvas.createOSC() ****

    private void putCurrentShape(Graphics g) {



    } // **** end PaintWithOffScreenCanvas.putCurrentShape(Graphics) ****

    private void putRect(Graphics g, boolean filled, int x1, int y1, int x2, int y2) {



    } // **** end PaintWithOffScreenCanvas.putRect(Graphics, boolean, int, int, int, int) ****

    private void putOval(Graphics g, boolean filled, int x1, int y1, int x2, int y2) {



    } // **** end PaintWithOffScreenCanvas.putOval(Graphics, boolean, int, int, int, int) ****

    private void repaintRect(int x1, int y1, int x2, int y2) {



    } // **** end PaintWithOffScreenCanvas.repaintRect(int, int, int, int) ****

    public JMenuBar getMenuBar() {

        JMenuBar menuBar = new JMenuBar();
        JMenu colorMenu = new JMenu("Color");
        JMenu toolMenu = new JMenu("Tool");
        menuBar.add(colorMenu);
        menuBar.add(toolMenu);

        ActionListener listener = new MenuHandler();
        JMenuItem item;

        item = new JMenuItem("Draw With Black");
        item.addActionListener(listener);
        colorMenu.add(item);

        item = new JMenuItem("Draw With White");
        item.addActionListener(listener);
        colorMenu.add(item);

        item = new JMenuItem("Draw With Red");
        item.addActionListener(listener);
        colorMenu.add(item);

        item = new JMenuItem("Draw With Green");
        item.addActionListener(listener);
        colorMenu.add(item);

        item = new JMenuItem("Draw With Blue");
        item.addActionListener(listener);
        colorMenu.add(item);

        item = new JMenuItem("Draw With Yellow");
        item.addActionListener(listener);
        colorMenu.add(item);

        item = new JMenuItem("Select Drawing Color...");
        item.addActionListener(listener);
        colorMenu.add(item);

        colorMenu.addSeparator();

        item = new JMenuItem("Fill With Color...");
        item.addActionListener(listener);
        colorMenu.add(item);

        item = new JMenuItem("Curve");
        item.addActionListener(listener);
        toolMenu.add(item);

        toolMenu.addSeparator();

        item = new JMenuItem("Line");
        item.addActionListener(listener);
        toolMenu.add(item);

        item = new JMenuItem("Rectangle");
        item.addActionListener(listener);
        toolMenu.add(item);

        item = new JMenuItem("Oval");
        item.addActionListener(listener);
        toolMenu.add(item);

        item = new JMenuItem("Filled Rectangle");
        item.addActionListener(listener);
        toolMenu.add(item);

        item = new JMenuItem("Filled Oval");
        item.addActionListener(listener);
        toolMenu.add(item);

        toolMenu.addSeparator();

        item = new JMenuItem("Smudge");
        item.addActionListener(listener);
        toolMenu.add(item);

        item = new JMenuItem("Erase");
        item.addActionListener(listener);
        toolMenu.add(item);

        return menuBar;

    } // **** end PaintWithOffScreenCanvas.getMenuBar() ****


    private class MenuHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {



        } // **** end MenuHandler.actionPerformed(ActionEvent) ****

    } // **** end nested class MenuHandler ****

    private class MouseHandler implements MouseListener, MouseMotionListener {



        public void mousePressed(MouseEvent e) {



        } // **** end MouseHandler.mousePressed(MouseEvent) ****

        public void mouseDragged(MouseEvent e) {



        } // **** end MouseHandler.mouseDragged(MouseEvent) ****

        public void mouseReleased(MouseEvent e) {



        } // **** end MouseHandler.mouseReleased(MouseEvent) ****

        public void mouseMoved(MouseEvent e){ } // **** end MouseHandler.mouseMoved(MouseEvent) ****
        public void mouseClicked(MouseEvent e) { } // **** end MouseHandler.mouseClicked(MouseEvent) ****
        public void mouseEntered(MouseEvent e) { } // **** end MouseHandler.mouseEntered(MouseEvent) ****
        public void mouseExited(MouseEvent e) { } // **** end MouseHandler.mouseExited(MouseEvent) ****

    } // **** end nested class MouseHandler ****

} // **** end PaintWithOffScreenCanvas class ****
