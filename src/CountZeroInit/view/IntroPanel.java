package CountZeroInit.view;

import CountZeroInit.controller.CountZeroInit;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntroPanel extends JPanel
        implements ActionListener {
    CountZeroInit countZeroInit;

    Toolkit awt;
    int width, height;

    JPanel mainDisplayPanel, secondaryDisplayPanel, textInputPanel;

    JScrollPane textOutputScrollPane;
    JTextArea textOutput;
    JLabel textInputLabel;
    JTextField textInput;
    String inputMessage = "player1's request: ";
    String player1SetNameMessage = "player1, please input your handle: ";
    String prevRequest = "";
    StringBuffer history;

    String cursorIconMonkeyImageAddress = "src/CountZeroInit/model/icons/5monkey.jpg";
    String cursorIconPigImageAddress = "src/CountZeroInit/model/icons/4pig.jpg";
    Image cursorIconMonkey, cursorIconPig;
    Cursor cursorMonkey, cursorPig;

    int timerCounter = 0;
    JLabel timerDisplay;
    Timer timer;

    public IntroPanel(CountZeroInit countZeroInit) {
        this.countZeroInit = countZeroInit;

        awt = Toolkit.getDefaultToolkit();
        width = (int)awt.getScreenSize().getWidth();
        height = (int)awt.getScreenSize().getHeight()-38;   // -38  to try to account for start bar

        this.setPreferredSize( new Dimension(width, height) );
        this.setLayout( new BorderLayout() );

        initCursorIcons();

        initMainDisplayPanel();
        initSecondaryDisplayPanel();
        initTextInputPanel();

        this.add(mainDisplayPanel, BorderLayout.CENTER);
        this.add(secondaryDisplayPanel, BorderLayout.EAST);
        this.add(textInputPanel, BorderLayout.SOUTH);
        this.setVisible(true);

    }

    public void startTimer() {
        timer = new Timer(1000, this);
        timer.start();
    }

    public void setPlayer1Name() {
        countZeroInit.getPlayer1().setName(JOptionPane.showInputDialog(this, player1SetNameMessage));

        inputMessage = countZeroInit.getPlayer1().getName() + inputMessage.substring(7);
        textInputLabel.setText(inputMessage);

        history.append("\n\n\n" + countZeroInit.getPlayer1().getName() + ", if you wish to enter THE GRID...\n" +
                "Socket your device, then request entry...\n\n\n" +
                "To request entry, type:\n\"setGreenEggsAndSpam(true);\"\nand press the Enter key. \n\n\n" +
                "(it's not too late to turn back, type: \n\"eggsAreNotSupposeToBeGreen();\"\nand press the Enter key.)\n\n\n");
        textOutput.setText(history.toString());
        textOutput.setCaretPosition(history.toString().length());

        textInput.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            timerDisplay.setText("" + timerCounter++);

            if (timerCounter == 3600) {
                timer.removeActionListener(this);
            }
        }
        else if (e.getSource() == textInput) {
            prevRequest = textInput.getText();
            history.append(textInput.getText() + "\n\n\n");
            textOutput.setText(history.toString());
            textInput.setText("");
            textInput.requestFocus();
            //if(this.phaseNow == this.phase1) {
            if (prevRequest.equals("setGreenEggsAndSpam(true);")) {
                countZeroInit.setCurrentState(countZeroInit.getGameState());

                this.remove(mainDisplayPanel);
                mainDisplayPanel = countZeroInit.getDisplayer().getGamePanel();
                this.add(mainDisplayPanel, BorderLayout.CENTER);
                mainDisplayPanel.setRequestFocusEnabled(true);
                mainDisplayPanel.grabFocus();
                this.revalidate();

                //mainDisplayPanel.setSize( new Dimension(50,350) );
                //this.phaseNow = this.phase2;
            } else if (prevRequest.equals("eggsAreNotSupposeToBeGreen();")) {

                this.remove(mainDisplayPanel);
                mainDisplayPanel = countZeroInit.getDisplayer().getAnimationPracticePanel();
                this.add(mainDisplayPanel, BorderLayout.CENTER);

                AnimationPracticePanel animationPracticePanel = (AnimationPracticePanel) countZeroInit.getDisplayer().getAnimationPracticePanel();
                Timer timer = animationPracticePanel.getTimer();
                timer.start();

                this.revalidate();

            /*
            this.remove(mainDisplayPanel);
            mainDisplayPanel = new MouseClickDisplayPanel();
            this.add(mainDisplayPanel, BorderLayout.CENTER);
            this.revalidate();
            */

                //this.phaseNow = this.phase0;
            } else {
                history.append("INPUT ERROR, may only choose from the earlier two options. \n\n\n");
                textOutput.setText(history.toString());
                textInput.setText("");
                textInput.requestFocus();
            }
        } else {
            System.out.println("IntroPanel's actionPerformed(ActionEvent) method");
        }
        // }
    }
    private void initCursorIcons() {
        cursorIconMonkey = awt.getImage(cursorIconMonkeyImageAddress);
        cursorMonkey = awt.createCustomCursor(cursorIconMonkey, new Point(0,0), "cursorMonkey");
        cursorIconPig = awt.getImage(cursorIconPigImageAddress);
        cursorPig = awt.createCustomCursor(cursorIconPig, new Point(0, 0), "cursorPig");
    }

    JLabel somethingText;
    private void initMainDisplayPanel() {
        mainDisplayPanel = new BackgroundDisplayPanel((width-(int)(width*0.25)), height-(15 /*+ menuBar.getHeight()*/));
        mainDisplayPanel.setPreferredSize( new Dimension((width-(int)(width*0.25)), height-(15 /*+ menuBar.getHeight()*/)) );
        mainDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3, false));

        mainDisplayPanel.setLayout(null);
        //somethingText = new JLabel("The Cantina scene && The Space Bazaar scene && That Ice Planet battle scene");
        somethingText = new JLabel("What if every moment really does count? Keep studying, keep learning. The Resistance needs you.");
        somethingText.setFont( new Font("san-serif", Font.BOLD, 17) );
        somethingText.setForeground(Color.YELLOW);
        somethingText.setBorder(BorderFactory.createRaisedBevelBorder());
        somethingText.setSize(800, 35);
        somethingText.setLocation(90, 75);
        //mainDisplayPanel.setLayout( new FlowLayout() );
        mainDisplayPanel.add(somethingText);

        timerDisplay = new JLabel("" + timerCounter);
        timerDisplay.setFont( new Font("san-serif", Font.BOLD, 8) );
        timerDisplay.setForeground(Color.YELLOW);
        timerDisplay.setSize(50, 15);
        timerDisplay.setLocation(10, 10);
        mainDisplayPanel.add(timerDisplay);

        mainDisplayPanel.setFocusable(true);
        mainDisplayPanel.setCursor(cursorMonkey);

        startTimer();
    }
    private void initSecondaryDisplayPanel() {
        secondaryDisplayPanel = new JPanel();
        secondaryDisplayPanel.setSize( new Dimension((width-(int)(width*0.75)), (height-(15 /*+ menuBar.getHeight()*/))));
        secondaryDisplayPanel.setBackground(Color.LIGHT_GRAY);
        secondaryDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2, false));
        secondaryDisplayPanel.setLayout(new FlowLayout());
        history = new StringBuffer();
        history.append(player1SetNameMessage);
        textOutput = new JTextArea(history.toString(),38, 28);
        textOutput.setSize(new Dimension((width-(int)(width*0.75)), (height-(15 /*+ menuBar.getHeight()*/)))); // 15 for the textInput
        textOutput.setMargin(new Insets(0, 3, 0, 0));
        textOutput.setLineWrap(true);
        textOutput.setWrapStyleWord(true);
        textOutput.setEditable(false);
        textOutputScrollPane = new JScrollPane(textOutput);
        textOutputScrollPane.setSize(new Dimension ((width-(int)(width*0.75)), (height-(15 /*+ menuBar.getHeight()*/))));
        textOutputScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        secondaryDisplayPanel.add(textOutputScrollPane);
        secondaryDisplayPanel.setCursor(cursorPig);
    }
    private void initTextInputPanel() {
        textInputPanel = new JPanel();
        textInputPanel.setSize( new Dimension(width, 15));
        textInputPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2, false));
        textInputPanel.setLayout(new BorderLayout());
        textInputLabel = new JLabel(inputMessage);
        textInput = new JTextField(60);
        textInput.setMargin(new Insets(0, 3, 0, 0));
        textInput.setEditable(true);
        textInput.setFocusable(true);
        textInput.addActionListener(this);
        textInputPanel.add(textInputLabel, BorderLayout.LINE_START);
        textInputPanel.add(textInput, BorderLayout.CENTER);
    }


}





class BackgroundDisplayPanel extends JPanel {

    String backgroundDisplayImageAddress;
    ImageIcon backgroundDisplayImageIcon;
    Image backgroundDisplayImage;

    public BackgroundDisplayPanel(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));

        backgroundDisplayImageAddress = "src/CountZeroInit/model/icons/cyberpunk_wallpapers(1920x1080).jpg";
        backgroundDisplayImageIcon = new ImageIcon(backgroundDisplayImageAddress);
        backgroundDisplayImage = backgroundDisplayImageIcon.getImage();

        this.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(backgroundDisplayImage, 0, 0, this.getWidth(), this.getHeight(), 0, 0, 1920, 1080, null);
    }
}




class MouseClickDisplayPanel extends JPanel {
    private int squareX = 50;
    private int squareY = 50;
    private int squareW = 20;
    private int squareH = 20;

    public MouseClickDisplayPanel() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        addMouseListener( new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                moveSquare(e.getX(), e.getY());
            }
        });
        addMouseMotionListener( new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                moveSquare(e.getX(), e.getY());
            }
        });
    }
    private void moveSquare(int x, int y) {
        int OFFSET = 1;
        if ((squareX!=x) || (squareY!=y)) {
            repaint(squareX, squareY, squareW+OFFSET, squareH+OFFSET);
            squareX = x;
            squareY = y;
            repaint(squareX, squareY, squareW+OFFSET, squareH+OFFSET);
        }
    }

    // this is ***overriding*** getPreferredSize().
    public Dimension getPreferredSize() {
        return new Dimension(250, 200);
    }

    // this is overriding paintComponent(Graphics g).
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("This is my custom Panel!", 10, 20);
        g.setColor(Color.RED);
        g.fillRect(squareX, squareY, squareW, squareH);
        g.setColor(Color.BLACK);
        g.drawRect(squareX, squareY, squareW, squareH);
    }
}