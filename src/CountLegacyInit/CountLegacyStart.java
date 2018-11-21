package CountLegacyInit;

import javax.swing.*;
import java.awt.*;

public class CountLegacyStart extends JFrame {
    Player player1;

    JPanel framePanel;
    Toolkit awt;
    int width;
    int height;

    JPanel mainDisplayPanel;
    JPanel secondaryDisplayPanel;
    JPanel textInputPanel;

    JScrollPane textOutputScrollPane;
    JTextArea textOutput;
    JTextField textInput;
    String inputMessage = "player1's request: ";
    String player1SetNameMessage = "player1, please input your handle: ";

    public CountLegacyStart() {
        Player player1 = new Player();

        awt = Toolkit.getDefaultToolkit();
        width = (int)awt.getScreenSize().getWidth();
        height = (int)awt.getScreenSize().getHeight()-38;

        framePanel = new JPanel();
        framePanel.setPreferredSize(new Dimension(width, height));
        framePanel.setLayout(new BorderLayout());

        mainDisplayPanel = new BackgroundDisplayPanel((width-(int)(width*0.25)), height-15);
        mainDisplayPanel.setPreferredSize( new Dimension((width-(int)(width*0.25)), height-15));

        secondaryDisplayPanel = new JPanel();
        secondaryDisplayPanel.setPreferredSize( new Dimension((width-(int)(width*0.75)), height));
        secondaryDisplayPanel.setLayout(new FlowLayout());
        textOutput = new JTextArea("",41, 30);
        textOutput.setSize((width-(int)(width*0.75)), height-15);
        textOutput.setLineWrap(true);
        textOutput.setEditable(false);
        textOutputScrollPane = new JScrollPane(textOutput);
        secondaryDisplayPanel.add(textOutputScrollPane);

        textInputPanel = new JPanel();
        textInputPanel.setLayout(new GridLayout());
        textInput = new JTextField(inputMessage, 30);
        textInput.setFocusable(true);
        textInputPanel.add(textInput);

        framePanel.add(mainDisplayPanel, BorderLayout.CENTER);
        framePanel.add(secondaryDisplayPanel, BorderLayout.EAST);
        framePanel.add(textInputPanel, BorderLayout.SOUTH);
        framePanel.setVisible(true);

        this.setContentPane(framePanel);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textInput.requestFocusInWindow();
        this.setVisible(true);

        textOutput.append(player1SetNameMessage);
        player1.setName(JOptionPane.showInputDialog(this, player1SetNameMessage));
        textOutput.append(player1.getName() + "\n\n");

        inputMessage = player1.getName() + inputMessage.substring(7);
        textInput.setText(inputMessage);

        textOutput.append(player1.getName() + ", if you wish to enter THE GRID...\n\n"
                + "Socket your device, then request entry...\n\n" +
                "To request entry, type \"" + player1.getName() + ".init();\" followed by ENTER \n"
                        + "(at which point you will be jacked into THE GRID.\n\n");

        textInput.requestFocus();
        textInput.setCaretPosition(inputMessage.length());
    }


    public static void main(String[] args) {
        CountLegacyStart countLegacyStart = new CountLegacyStart();
    }
}
