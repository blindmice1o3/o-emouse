package CountLegacyInit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountLegacyInit extends JFrame
        implements ActionListener {
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

    public CountLegacyInit() {
        Player player1 = new Player();

        awt = Toolkit.getDefaultToolkit();
        width = (int)awt.getScreenSize().getWidth();
        height = (int)awt.getScreenSize().getHeight()-38;

        framePanel = new JPanel();
        framePanel.setPreferredSize(new Dimension(width, height));
        framePanel.setLayout(new BorderLayout());

        mainDisplayPanel = new BackgroundDisplayPanel((width-(int)(width*0.25)), height-15);
        mainDisplayPanel.setPreferredSize( new Dimension((width-(int)(width*0.25)), height-15));
        mainDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3, false));

        secondaryDisplayPanel = new JPanel();
        secondaryDisplayPanel.setPreferredSize( new Dimension((width-(int)(width*0.75)), height));
        secondaryDisplayPanel.setBackground(Color.LIGHT_GRAY);
        secondaryDisplayPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, false));
        secondaryDisplayPanel.setLayout(new FlowLayout());
        textOutput = new JTextArea(player1SetNameMessage,41, 28);
        textOutput.setSize((width-(int)(width*0.75)), height-15);
        textOutput.setMargin(new Insets(0, 3, 0, 0));
        textOutput.setLineWrap(true);
        textOutput.setWrapStyleWord(true);
        textOutput.setEditable(false);
        textOutputScrollPane = new JScrollPane(textOutput);
        textOutputScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        secondaryDisplayPanel.add(textOutputScrollPane);

        textInputPanel = new JPanel();
        textInputPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, false));
        textInputPanel.setLayout(new GridLayout());
        textInput = new JTextField(inputMessage, 30);
        textInput.setMargin(new Insets(0, 3, 0, 0));
        textInput.setEditable(true);
        textInput.setFocusable(true);
        textInput.addActionListener(this);
        textInputPanel.add(textInput);

        framePanel.add(mainDisplayPanel, BorderLayout.CENTER);
        framePanel.add(secondaryDisplayPanel, BorderLayout.EAST);
        framePanel.add(textInputPanel, BorderLayout.SOUTH);
        framePanel.setVisible(true);

        this.setTitle("Moon Rocks - It's NOT What You're Thinking");
        this.setContentPane(framePanel);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textInput.requestFocusInWindow();
        this.setVisible(true);

        player1.setName(JOptionPane.showInputDialog(this, player1SetNameMessage));
        textOutput.append(player1.getName() + "\n\n\n");

        inputMessage = player1.getName() + inputMessage.substring(7);
        textInput.setText(inputMessage);

        textOutput.append(player1.getName() + ", if you wish to enter THE GRID...\n"
                + "Socket your device, then request entry...\n\n\n" +
                "To request entry, type \"" + player1.getName() + ".init();\" followed by ENTER \n"
                        + "(at which point you will be jacked into THE GRID.\n\n\n");

        textInput.requestFocus();
        textInput.setCaretPosition(inputMessage.length());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textOutput.append(textInput.getText().substring(inputMessage.length()) + "\n\n\n");

        textInput.setText(inputMessage);
        textInput.requestFocus();
        textInput.setCaretPosition(inputMessage.length());
    }

    public static void main(String[] args) {
        CountLegacyInit countLegacyInit = new CountLegacyInit();
    }

}
