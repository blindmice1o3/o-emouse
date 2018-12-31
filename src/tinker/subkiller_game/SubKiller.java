package tinker.subkiller_game;

import javax.swing.*;

public class SubKiller extends JPanel {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Submarine Killer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 480);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        SubKiller panel = new SubKiller();
        frame.setContentPane(panel);

        frame.setVisible(true);

    } // **** end main(String[]) ****

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    private Timer timer;

    private int width, height;

    


    public SubKiller() {



    }

} // **** end SubKiller class ****