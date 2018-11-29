package CountLegacyInit.GameTemplate;

import javax.swing.*;
import java.awt.*;

public class LayoutManagerBoxLayout extends JFrame {
    JScrollPane listScroller;
    JPanel listPane;
    JLabel label;
    String labelText = "Item Chooser";
    JPanel buttonPane;
    JButton cancelButton;
    JButton setButton;

    public LayoutManagerBoxLayout(List list) {
        this.setSize(250, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listScroller = new JScrollPane(list);
        listScroller.setAlignmentX(LEFT_ALIGNMENT);
        listScroller.setVisible(true);

        listPane = new JPanel();
        listPane.setLayout( new BoxLayout(listPane, BoxLayout.PAGE_AXIS) );
        label = new JLabel(labelText);
        listPane.add(label);
        listPane.add(Box.createRigidArea( new Dimension(0,5) ));
        listPane.add(listScroller);
        listPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        listPane.setVisible(true);

        cancelButton = new JButton("cancel");
        setButton = new JButton("set");
        buttonPane = new JPanel();
        buttonPane.setLayout( new BoxLayout(buttonPane, BoxLayout.LINE_AXIS) );
        buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPane.add(Box.createHorizontalGlue());
        buttonPane.add(cancelButton);
        buttonPane.add(Box.createRigidArea( new Dimension(10, 0) ));
        buttonPane.add(setButton);
        buttonPane.setVisible(true);

        this.getContentPane().add(listPane, BorderLayout.CENTER);
        this.getContentPane().add(buttonPane, BorderLayout.PAGE_END);
    }

    public void init() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        List characterList = new List();
        characterList.add("Timon");
        characterList.add("Pumba");
        characterList.add("Simba");
        characterList.add("Zazuu");
        characterList.add("Mufasa");

        LayoutManagerBoxLayout boxLayout = new LayoutManagerBoxLayout(characterList);
        boxLayout.init();
    }
}
