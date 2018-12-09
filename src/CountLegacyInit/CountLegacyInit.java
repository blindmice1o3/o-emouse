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
    int width, height;
    Toolkit awt;
    String frameIconImageAddress = "src/CountLegacyInit/icons/sick_bear.png";
    Image frameIcon;

    //JMenuBar menuBar;
    //JMenu saveAndLoadMenu, editMenu, themeMenu;
    //JMenuItem saveCommand, loadCommand,
    //        cutCommand, copyCommand, pasteCommand,
    //        themeCommand0, themeCommand1, themeRosePetalGlasses;

    //String cursorIconMonkeyImageAddress = "src/CountLegacyInit/icons/5monkey.jpg";
    //String cursorIconPigImageAddress = "src/CountLegacyInit/icons/4pig.jpg";
    //String cursorIconFishImageAddress = "src/CountLegacyInit/icons/2fish_purple.jpg";
    //Image cursorIconMonkey, cursorIconPig, cursorIconFish;
    //Cursor cursorMonkey, cursorPig, cursorFish;

    JPanel mainDisplayPanel, secondaryDisplayPanel, textInputPanel;

    JScrollPane textOutputScrollPane;
    JTextArea textOutput;
    JLabel textInputLabel;
    JTextField textInput;
    String inputMessage = "player1's request: ";
    String player1SetNameMessage = "player1, please input your handle: ";
    String prevRequest = "";


    public CountLegacyInit() {
        Player player1 = new Player();
        this.phaseNow = this.phase0;
            //awt = Toolkit.getDefaultToolkit();
            //width = (int)awt.getScreenSize().getWidth();
            //height = (int)awt.getScreenSize().getHeight()-38;   // -38  to try to account for start bar
            //frameIcon = awt.getImage(frameIconImageAddress);

            //initCursorIcons();

            //initMenuBar();
            //this.setJMenuBar(menuBar);

            //initFramePanel();

            //this.setTitle("Moon Rocks - It's NOT What You're Thinking");
            //this.setIconImage(frameIcon);
            //this.setContentPane(framePanel);
            //this.setSize(width, height);
            //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //textInput.requestFocusInWindow();
            //this.setVisible(true);

/*      player1.setName(JOptionPane.showInputDialog(this, player1SetNameMessage));
        textOutput.append(player1.getName() + "\n\n\n");

        inputMessage = player1.getName() + inputMessage.substring(7);
        textInputLabel.setText(inputMessage);
*/
        this.phaseNow = this.phase1;

/*      textOutput.append(player1.getName() + ", if you wish to enter THE GRID...\n"
                + "Socket your device, then request entry...\n\n\n" +
                "To request entry, type:\n\"setGreenEggsAndSpam(true);\"\nand press the Enter key. \n\n\n");
        textOutput.append("(it's not too late to turn back, type: \n\"eggsAreNotSupposeToBeGreen();\"\nand press the Enter key.)\n\n\n");

        textInput.requestFocus();
*/

        //textInput.setCaretPosition(inputMessage.length());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    /*    prevRequest = textInput.getText();
        textOutput.append(textInput.getText() + "\n\n\n");
        textInput.setText("");
        textInput.requestFocus();
        //if(this.phaseNow == this.phase1) {
        if (prevRequest.equals("setGreenEggsAndSpam(true);")) {
            mainDisplayPanel.setSize( new Dimension(50,350) );
            //this.phaseNow = this.phase2;
        } else if (prevRequest.equals("eggsAreNotSupposeToBeGreen();")) {
            framePanel.remove(mainDisplayPanel);
            mainDisplayPanel = new MouseClickDisplayPanel();
            framePanel.add(mainDisplayPanel, BorderLayout.CENTER);
            framePanel.revalidate();
            //framePanel.repaint();
            //mainDisplayPanel.setSize( new Dimension(350,50) );
            //this.phaseNow = this.phase0;
        } else {
            textOutput.append("INPUT ERROR, may only choose from the earlier two options. \n\n\n");
            textInput.setText("");
            textInput.requestFocus();
        }
        // } */
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                CountLegacyInit countLegacyInit = new CountLegacyInit();
            }
        } );

    }

    private void initFramePanel() {
        //framePanel = new JPanel();
        //framePanel.setPreferredSize( new Dimension(width, height) );
        //framePanel.setLayout( new BorderLayout() );

        //initMainDisplayPanel();
        //initSecondaryDisplayPanel();
        //initTextInputPanel();

        //framePanel.add(mainDisplayPanel, BorderLayout.CENTER);
        //framePanel.add(secondaryDisplayPanel, BorderLayout.EAST);
        //framePanel.add(textInputPanel, BorderLayout.SOUTH);
        //framePanel.setVisible(true);
    }
/*
    private void initMainDisplayPanel() {
        mainDisplayPanel = new BackgroundDisplayPanel((width-(int)(width*0.25)), height-(15 + menuBar.getHeight()));
        mainDisplayPanel.setPreferredSize( new Dimension((width-(int)(width*0.25)), height-(15 + menuBar.getHeight())) );
        mainDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3, false));
        mainDisplayPanel.setCursor(cursorMonkey);
    }
    private void initSecondaryDisplayPanel() {
        secondaryDisplayPanel = new JPanel();
        secondaryDisplayPanel.setSize( new Dimension((width-(int)(width*0.75)), (height-(15 + menuBar.getHeight()))));
        secondaryDisplayPanel.setBackground(Color.LIGHT_GRAY);
        secondaryDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2, false));
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
*/

/*
    private void initCursorIcons() {
        cursorIconMonkey = awt.getImage(cursorIconMonkeyImageAddress);
        cursorIconPig = awt.getImage(cursorIconPigImageAddress);
        cursorIconFish = awt.getImage(cursorIconFishImageAddress);
        cursorMonkey = awt.createCustomCursor(cursorIconMonkey, new Point(0,0), "cursorMonkey");
        cursorPig = awt.createCustomCursor(cursorIconPig, new Point(0, 0), "cursorPig");
        cursorFish = awt.createCustomCursor(cursorIconFish, new Point(0, 0), "cursorFish");
    }

    private void initMenuBar() {
        menuBar = new JMenuBar();

        initSaveAndLoadMenu();
        initEditMenu();
        initThemeMenu();

        menuBar.add(saveAndLoadMenu);
        menuBar.add(editMenu);
        menuBar.add(themeMenu);
    }

    private void initSaveAndLoadMenu() {
        saveAndLoadMenu = new JMenu("Save/Load");
        saveCommand = new JMenuItem("Record \"current\" state");
        saveCommand.setToolTipText("save");
        loadCommand = new JMenuItem("Reboot to \"previous\" state");
        loadCommand.setToolTipText("load");
        // saveCommand.addActionListener(listener);
        // loadCommand.addActionListener(listener);
        saveAndLoadMenu.add(saveCommand);
        saveAndLoadMenu.addSeparator();
        saveAndLoadMenu.add(loadCommand);
    }
    private void initEditMenu() {
        editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
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
        editMenu.add(cutCommand);
        editMenu.add(copyCommand);
        editMenu.addSeparator();
        editMenu.add(pasteCommand);
    }
    private void initThemeMenu() {
        themeMenu = new JMenu("Theme");
        themeCommand0 = new JMenuItem("ThemeCommand0");
        themeCommand0.setToolTipText("TODO: implement themeCommand0");
        themeCommand1 = new JMenuItem("ThemeCommand1");
        themeCommand1.setToolTipText("TODO: implement themeCommand1");
        themeRosePetalGlasses = new JMenuItem("ThemeRosePetalGlasses");
        themeRosePetalGlasses.setToolTipText("from nothing,\nto nothing,\nbut this is everything inbetween");
        themeRosePetalGlasses.setCursor(cursorFish);
        // themeCommand0.addActionListener(listener);
        // themeCommand1.addActionListener(listener);
        themeMenu.add(themeCommand0);
        themeMenu.add(themeCommand1);
        themeMenu.addSeparator();
        themeMenu.add(themeRosePetalGlasses);
    }
*/
}
