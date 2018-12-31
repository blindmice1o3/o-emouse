package count_zero_init.view;

import count_zero_init.controller.CountZeroInit;
import count_zero_init.model.map.Map;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Displayer extends JFrame {
    JPanel battlePanel, gamePanel, introPanel, itemListPanel, monsterListPanel, myMonsterListPanel, startMenuPanel,
        animationPracticePanel;

    CountZeroInit countZeroInit;
    Map map;
    Toolkit awt;
    int width, height;
    String frameIconImageAddress = "src/count_zero_init/model/icons/sick_bear.png";
    Image frameIcon;

    JPanel currentPanel;

    //========================================================================================//

    JMenuBar menuBar;
    JMenu saveAndLoadMenu, editMenu, themeMenu;
    JMenuItem saveCommand, loadCommand,
            cutCommand, copyCommand, pasteCommand,
            themeCommand0, themeCommand1, themeRosePetalGlasses;

    String cursorIconFishImageAddress = "src/count_zero_init/model/icons/2fish_purple.jpg";
    Image cursorIconFish;
    Cursor cursorFish;

    //==========================================================================================//

    public Displayer(CountZeroInit countZeroInit, Map map) {
        this.countZeroInit = countZeroInit;
        this.map = map;

        awt = Toolkit.getDefaultToolkit();
        width = (int)awt.getScreenSize().getWidth();
        height = (int)awt.getScreenSize().getHeight()-38;   // -38  to try to account for start bar
        frameIcon = awt.getImage(frameIconImageAddress);

        this.setTitle("Moon Rocks - It's NOT What You're Thinking");
        this.setIconImage(frameIcon);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);   // Centers the window on the screen.
        this.setResizable(false);           // The frame can NOT be resized.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initCursorIcons();

        initMenuBar();
        this.setJMenuBar(menuBar);

        battlePanel = new BattlePanel(countZeroInit);
        gamePanel = new GamePanel(countZeroInit);
        introPanel = new IntroPanel(countZeroInit);
        itemListPanel = new ItemListPanel(countZeroInit);
        monsterListPanel = new MonsterListPanel(countZeroInit);
        myMonsterListPanel = new MyMonsterListPanel(countZeroInit);
        startMenuPanel = new StartMenuPanel(countZeroInit);
        animationPracticePanel = new AnimationPracticePanel(countZeroInit);

        // Using this line to select the module to work on.
        currentPanel = getIntroPanel();

        this.setContentPane(currentPanel);
        this.setVisible(true);
    }

    public void setCurrentPanel(String currentState) {
        switch (currentState) {
            case "Battle":
                currentPanel = getBattlePanel();
                break;
            case "Game":
                currentPanel = getGamePanel();
                break;
            case "Intro":
                currentPanel = getIntroPanel();
                break;
            case "ItemList":
                currentPanel = getItemListPanel();
                break;
            case "MonsterList":
                currentPanel = getMonsterListPanel();
                break;
            case "MyMonsterList":
                currentPanel = getMyMonsterListPanel();
                break;
            case "StartMenu":
                currentPanel = getStartMenuPanel();
                break;
        }


        //getContentPane().removeAll();
        //getContentPane().add(currentPanel);
        currentPanel.repaint();
    }

    public void redrawPanel() {
       currentPanel.repaint();

    }





    //============================================================================//

    private void initCursorIcons() {
        cursorIconFish = awt.getImage(cursorIconFishImageAddress);
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






    //=============================================================================//

    public JPanel getCurrentPanel() {
        return currentPanel;
    }

    public JPanel getBattlePanel() {
        return battlePanel;
    }

    public JPanel getGamePanel() {
        return gamePanel;
    }

    public JPanel getIntroPanel() {
        return introPanel;
    }

    public JPanel getItemListPanel() {
        return itemListPanel;
    }

    public JPanel getMonsterListPanel() {
        return monsterListPanel;
    }

    public JPanel getMyMonsterListPanel() {
        return myMonsterListPanel;
    }

    public JPanel getStartMenuPanel() {
        return startMenuPanel;
    }

    public JPanel getAnimationPracticePanel() { return animationPracticePanel; }

}

