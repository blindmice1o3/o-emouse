package CountZeroInit.view;

import CountZeroInit.controller.CountZeroInit;
import CountZeroInit.model.map.Map;

import javax.swing.*;

public class Displayer extends JFrame {
    CountZeroInit countZeroInit;
    Map map;
    JPanel battlePanel;
    JPanel gamePanel;
    JPanel introPanel;
    JPanel itemListPanel;
    JPanel monsterListPanel;
    JPanel myMonsterListPanel;
    JPanel startMenuPanel;

    JPanel currentPanel;

    public Displayer(CountZeroInit countZeroInit, Map map) {
        this.countZeroInit = countZeroInit;
        this.map = map;

        setSize(750, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        battlePanel = new BattlePanel(countZeroInit);
        gamePanel = new GamePanel(countZeroInit);
        introPanel = new IntroPanel(countZeroInit);
        itemListPanel = new ItemListPanel(countZeroInit);
        monsterListPanel = new MonsterListPanel(countZeroInit);
        myMonsterListPanel = new MyMonsterListPanel(countZeroInit);
        startMenuPanel = new StartMenuPanel(countZeroInit);

        //setCurrentPanel("GameState");
        currentPanel = gamePanel;
        getContentPane().add(currentPanel);
        setVisible(true);

    }

    public void setCurrentPanel(String currentState) {
        switch (currentState) {
            case "BattleState":
                currentPanel = getBattlePanel();
                break;
            case "GameState":
                currentPanel = getGamePanel();
                break;
            case "IntroState":
                currentPanel = getIntroPanel();
                break;
            case "ItemListState":
                currentPanel = getItemListPanel();
                break;
            case "MonsterListState":
                currentPanel = getMonsterListPanel();
                break;
            case "MyMonsterListState":
                currentPanel = getMyMonsterListPanel();
                break;
            case "StartMenuState":
                currentPanel = getStartMenuPanel();
                break;
        }

        getContentPane().removeAll();
        getContentPane().add(currentPanel);
        getContentPane().repaint();

        //DISPLAYER NOT DRAWING ITS PANEL!!!!!!!!!!!!!
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

}

