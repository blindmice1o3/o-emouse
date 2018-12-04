package CountLegacyInit;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class CountLegacyInit extends JFrame
        implements ActionListener {
    Player player1;
    public static final int phase0 = 0;
    public static final int phase1 = 1;
    public static final int phase2 = 2;
    public static final int phase3 = 3;
    public static final int phase4 = 4;
    public static int phaseNow;

    JPanel framePanel;
    int width;
    int height;

    Toolkit awt;
    String frameIconImageAddress = "src/CountLegacyInit/icons/sick_bear.png";
    String cursorIconMonkeyImageAddress = "src/CountLegacyInit/icons/5monkey.jpg";
    String cursorIconPigImageAddress = "src/CountLegacyInit/icons/4pig.jpg";
    String cursorIconFishImageAddress = "src/CountLegacyInit/icons/2fish_purple.jpg";
    Image frameIcon;
    Image cursorIconMonkey;
    Image cursorIconPig;
    Image cursorIconFish;


    JMenuBar menuBar;
    JMenu saveAndLoadMenu;
    JMenu editMenu;
    JMenu themeMenu;
    JMenuItem saveCommand;
    JMenuItem loadCommand;
    JMenuItem cutCommand;
    JMenuItem copyCommand;
    JMenuItem pasteCommand;
    JMenuItem themeCommand0;
    JMenuItem themeCommand1;
    JMenuItem themeRosePetalGlasses;

    JPanel mainDisplayPanel;
    JPanel secondaryDisplayPanel;
    JPanel textInputPanel;

    JScrollPane textOutputScrollPane;
    JTextArea textOutput;
    JLabel textInputLabel;
    JTextField textInput;
    String inputMessage = "player1's request: ";
    String player1SetNameMessage = "player1, please input your handle: ";
    Cursor cursorMonkey;
    Cursor cursorPig;
    Cursor cursorFish;
    String prevRequest = "";


    public CountLegacyInit() {
        Player player1 = new Player();
        this.phaseNow = this.phase0;
        awt = Toolkit.getDefaultToolkit();
        width = (int)awt.getScreenSize().getWidth();
        height = (int)awt.getScreenSize().getHeight()-38;   // -38  to try to account for start bar
        frameIcon = awt.getImage(frameIconImageAddress);
        cursorIconMonkey = awt.getImage(cursorIconMonkeyImageAddress);
        cursorIconPig = awt.getImage(cursorIconPigImageAddress);
        cursorIconFish = awt.getImage(cursorIconFishImageAddress);
        cursorMonkey = awt.createCustomCursor(cursorIconMonkey, new Point(0,0), "cursorMonkey");
        cursorPig = awt.createCustomCursor(cursorIconPig, new Point(0, 0), "cursorPig");
        cursorFish = awt.createCustomCursor(cursorIconFish, new Point(0, 0), "cursorFish");

        menuBar = new JMenuBar();
        saveAndLoadMenu = new JMenu("Save/Load");
        editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        themeMenu = new JMenu("Theme");

        saveCommand = new JMenuItem("Record \"current\" state");
        saveCommand.setToolTipText("save");
        loadCommand = new JMenuItem("Reboot to \"previous\" state");
        loadCommand.setToolTipText("load");
        cutCommand = new JMenuItem(new DefaultEditorKit.CutAction());
        cutCommand.setText("Cut");
        cutCommand.setToolTipText("cut (ctrl + x)");
        cutCommand.setMnemonic(KeyEvent.VK_X);
        copyCommand = new JMenuItem(new DefaultEditorKit.CopyAction());
        copyCommand.setText("Copy");
        copyCommand.setToolTipText("copy (ctrl + c)");
        copyCommand.setMnemonic(KeyEvent.VK_C);
        pasteCommand = new JMenuItem(new DefaultEditorKit.PasteAction());
        pasteCommand.setText("Paste");
        pasteCommand.setToolTipText("paste (ctrl + v)");
        pasteCommand.setMnemonic(KeyEvent.VK_V);
        themeCommand0 = new JMenuItem("ThemeCommand0");
        themeCommand0.setToolTipText("TODO: implement themeCommand0");
        themeCommand1 = new JMenuItem("ThemeCommand1");
        themeCommand1.setToolTipText("TODO: implement themeCommand1");
        themeRosePetalGlasses = new JMenuItem("ThemeRosePetalGlasses");
        themeRosePetalGlasses.setToolTipText("from nothing,\nto nothing,\nbut this is everything inbetween");
        themeRosePetalGlasses.setCursor(cursorFish);
        // saveCommand.addActionListener(listener);
        // loadCommand.addActionListener(listener);
        // themeCommand0.addActionListener(listener);
        // themeCommand1.addActionListener(listener);
        saveAndLoadMenu.add(saveCommand);
        saveAndLoadMenu.addSeparator();
        saveAndLoadMenu.add(loadCommand);
        editMenu.add(cutCommand);
        editMenu.add(copyCommand);
        editMenu.addSeparator();
        editMenu.add(pasteCommand);
        themeMenu.add(themeCommand0);
        themeMenu.add(themeCommand1);
        themeMenu.addSeparator();
        themeMenu.add(themeRosePetalGlasses);
        menuBar.add(saveAndLoadMenu);
        menuBar.add(editMenu);
        menuBar.add(themeMenu);
        this.setJMenuBar(menuBar);



        framePanel = new JPanel();
        framePanel.setPreferredSize(new Dimension(width, height));
        framePanel.setLayout(new BorderLayout());

        mainDisplayPanel = new BackgroundDisplayPanel((width-(int)(width*0.25)), height-(15 + menuBar.getHeight()));
        mainDisplayPanel.setPreferredSize( new Dimension((width-(int)(width*0.25)), height-(15 + menuBar.getHeight())));
        mainDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3, false));
        mainDisplayPanel.setCursor(cursorMonkey);

        secondaryDisplayPanel = new JPanel();
        secondaryDisplayPanel.setSize( new Dimension((width-(int)(width*0.75)), (height-(15 + menuBar.getHeight()))));
        secondaryDisplayPanel.setBackground(Color.LIGHT_GRAY);
        secondaryDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2, false));
        secondaryDisplayPanel.setLayout(new FlowLayout());
        textOutput = new JTextArea(player1SetNameMessage,38, 28);
        textOutput.setSize(new Dimension((width-(int)(width*0.75)), (height-(15 + menuBar.getHeight())))); // 15 for the textInput
        textOutput.setMargin(new Insets(0, 3, 0, 0));
        textOutput.setLineWrap(true);
        textOutput.setWrapStyleWord(true);
        textOutput.setEditable(false);
        textOutputScrollPane = new JScrollPane(textOutput);
        textOutputScrollPane.setSize(new Dimension ((width-(int)(width*0.75)), (height-(15 + menuBar.getHeight()))));
        textOutputScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        secondaryDisplayPanel.add(textOutputScrollPane);
        secondaryDisplayPanel.setCursor(cursorPig);

        textInputPanel = new JPanel();
        textInputPanel.setSize( new Dimension(width, 15));
        textInputPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, false));
        textInputPanel.setLayout(new BorderLayout());
        textInputLabel = new JLabel(inputMessage);
        textInput = new JTextField(60);
        textInput.setMargin(new Insets(0, 3, 0, 0));
        textInput.setEditable(true);
        textInput.setFocusable(true);
        textInput.addActionListener(this);
        textInputPanel.add(textInputLabel, BorderLayout.LINE_START);
        textInputPanel.add(textInput, BorderLayout.CENTER);

        framePanel.add(mainDisplayPanel, BorderLayout.CENTER);
        framePanel.add(secondaryDisplayPanel, BorderLayout.EAST);
        framePanel.add(textInputPanel, BorderLayout.SOUTH);
        framePanel.setVisible(true);

        this.setTitle("Moon Rocks - It's NOT What You're Thinking");
        this.setIconImage(frameIcon);
        this.setContentPane(framePanel);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textInput.requestFocusInWindow();
        this.setVisible(true);

        player1.setName(JOptionPane.showInputDialog(this, player1SetNameMessage));
        textOutput.append(player1.getName() + "\n\n\n");

        inputMessage = player1.getName() + inputMessage.substring(7);
        textInputLabel.setText(inputMessage);

        this.phaseNow = this.phase1;

        textOutput.append(player1.getName() + ", if you wish to enter THE GRID...\n"
                + "Socket your device, then request entry...\n\n\n" +
                "To request entry, type:\n\"setGreenEggsAndSpam(true);\"\nand press the Enter key. \n\n\n");
        textOutput.append("(it's not too late to turn back, type: \n\"eggsAreNotSupposeToBeGreen();\"\nand press the Enter key.)\n\n\n");

        textInput.requestFocus();
        //textInput.setCaretPosition(inputMessage.length());


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        prevRequest = textInput.getText();
        textOutput.append(textInput.getText() + "\n\n\n");
        textInput.setText("");
        textInput.requestFocus();
        //if(this.phaseNow == this.phase1) {
            if (prevRequest.equals("setGreenEggsAndSpam(true);")) {
                mainDisplayPanel.setSize( new Dimension(50,350) );
                framePanel.repaint();
                this.phaseNow = this.phase2;
            } else if (prevRequest.equals("eggsAreNotSupposeToBeGreen();")) {
                mainDisplayPanel.setSize( new Dimension(350,50) );
                framePanel.repaint();
                this.phaseNow = this.phase0;

            } else {
                textOutput.append("INPUT ERROR, may only choose from the earlier two options. \n\n\n");
                textInput.setText("");
                textInput.requestFocus();
            }
       // }
    }

    public static void main(String[] args) {
        CountLegacyInit countLegacyInit = new CountLegacyInit();
    }

}
