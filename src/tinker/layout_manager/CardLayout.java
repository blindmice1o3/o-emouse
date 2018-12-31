package tinker.layout_manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CardLayout extends JPanel
        implements ItemListener {
    JPanel comboBoxPane;
    JPanel cardsPane;

    JPanel cardMonsterList = new JPanel();
    JPanel cardMyMonsterList = new JPanel();
    JPanel cardItemList = new JPanel();
    JPanel cardPlayerInfo = new JPanel();
    JPanel cardOption = new JPanel();

    public CardLayout() {
        initiateComboBoxPane();
        initiateCardPane();

        this.setLayout(new BorderLayout());
        this.setSize(600, 400);

        this.add(comboBoxPane, BorderLayout.PAGE_START);
        this.add(cardsPane, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public String[] createStringArray() {
        String[] mainMenuList = new String[MainMenu.values().length];
        for (int i = 0; i < MainMenu.values().length; i++) {
            mainMenuList[i] = MainMenu.values()[i].getName();
        }
        return mainMenuList;
    }

    public void initiateCardPane() {
        cardsPane = new JPanel(new java.awt.CardLayout());
        cardsPane.add(cardMonsterList, MainMenu.MONSTER_LIST.getName());
        cardsPane.add(cardMyMonsterList, MainMenu.MY_MONSTER_LIST.getName());
        cardsPane.add(cardItemList, MainMenu.ITEM_LIST.getName());
        cardsPane.add(cardPlayerInfo, MainMenu.PLAYER_INFO.getName());
        cardsPane.add(cardOption, MainMenu.OPTION.getName());
    }
    public void initiateComboBoxPane() {
        comboBoxPane = new JPanel();
        JComboBox<String> cb = new JComboBox<String>(createStringArray());
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
    }

    public static void main(String[] args) {
        JPanel cardLayoutPanel = new CardLayout();
        JFrame frame = new JFrame("CardLayout Layout Manager");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(cardLayoutPanel);
        frame.setVisible(true);
    }

    // Method came from the ItemListener class implementation,
    // contains functionality to process the combo box item selecting
    @Override
    public void itemStateChanged(ItemEvent evt) {
        java.awt.CardLayout c1 = (java.awt.CardLayout)(cardsPane.getLayout());
        c1.show(cardsPane, (String)evt.getItem());
    }
}
