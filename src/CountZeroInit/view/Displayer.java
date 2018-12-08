package CountZeroInit.view;

import CountZeroInit.controller.CountZeroInit;
import CountZeroInit.model.map.Map;

import javax.swing.*;
import java.awt.*;

public class Displayer extends JFrame {
    JPanel battlePanel, gamePanel, introPanel, itemListPanel, monsterListPanel, myMonsterListPanel, startMenuPanel,
        animationPracticePanel;

    CountZeroInit countZeroInit;
    Map map;
    Toolkit awt;
    int width, height;
    String frameIconImageAddress = "src/CountLegacyInit/icons/sick_bear.png";
    Image frameIcon;

    JPanel currentPanel;

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

        battlePanel = new BattlePanel(countZeroInit);
        gamePanel = new GamePanel(countZeroInit);
        introPanel = new IntroPanel(countZeroInit);
        itemListPanel = new ItemListPanel(countZeroInit);
        monsterListPanel = new MonsterListPanel(countZeroInit);
        myMonsterListPanel = new MyMonsterListPanel(countZeroInit);
        startMenuPanel = new StartMenuPanel(countZeroInit);
        animationPracticePanel = new AnimationPracticePanel(countZeroInit);

        // Using this line to select the module to work on.
        currentPanel = getAnimationPracticePanel();

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
        getContentPane().repaint();
    }

    public void redrawPanel() {
       currentPanel.repaint();

    }

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

