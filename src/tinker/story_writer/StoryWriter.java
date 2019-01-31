package tinker.story_writer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoryWriter extends JFrame {

    private MyWritingPanel myWritingPanel;
    private MyWordSuggestionPanel myWordSuggestionPanel;

    private JMenuBar menuBar;
    private JMenu saveAndLoadMenu;
    private JMenuItem saveMenuItem;
    private JMenuItem loadMenuItem;

    public StoryWriter() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1080, 720);
        this.setTitle("Story Writer w Word Suggestion Panel");
        this.setLocationRelativeTo(null);

        init();

    } // **** end StoryWriter() constructor ****

    public void init() {

        myWritingPanel = new MyWritingPanel();
        this.getContentPane().add(myWritingPanel, BorderLayout.CENTER);

        myWordSuggestionPanel = new MyWordSuggestionPanel();
        this.getContentPane().add(myWordSuggestionPanel, BorderLayout.LINE_END);

        menuBar = new JMenuBar();
        saveAndLoadMenu = new JMenu("Save/Load");
        saveMenuItem = new JMenuItem("Save Your Writing");
        loadMenuItem = new JMenuItem("Load Text File");

        saveAndLoadMenu.add(saveMenuItem);
        saveAndLoadMenu.add(loadMenuItem);
        menuBar.add(saveAndLoadMenu);
        this.setJMenuBar(menuBar);

        this.setVisible(true);

    } // **** end init() ****

    public static void main(String[] args) {
        StoryWriter app = new StoryWriter();
        app.init();
    } // **** end main(String[]) ****

    class MyWritingPanel extends JPanel {

        JTextArea textAreaMyWriting;
        JScrollPane scrollerMyWriting;

        public MyWritingPanel() {

            this.setLayout( new BorderLayout() );

            textAreaMyWriting = new JTextArea(40, 60);
            textAreaMyWriting.setLineWrap(true);
            textAreaMyWriting.setFocusable(true);

            scrollerMyWriting = new JScrollPane(textAreaMyWriting);
            scrollerMyWriting.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollerMyWriting.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            this.add(scrollerMyWriting, BorderLayout.CENTER);

        } // **** end MyWritingPanel() constructor ****

    } // **** end MyWritingPanel inner-class ****

    class MyWordSuggestionPanel extends JPanel
            implements ActionListener {

        private JTextArea textAreaWordSuggestion;
        private JScrollPane scrollerWordSuggestion;
        private JButton getWordButton;

        public MyWordSuggestionPanel() {

            this.setLayout( new BoxLayout(this, BoxLayout.PAGE_AXIS) );

            textAreaWordSuggestion = new JTextArea(30, 20);
            textAreaWordSuggestion.setLineWrap(true);
            textAreaWordSuggestion.setFocusable(true);
            textAreaWordSuggestion.setEditable(false);

            scrollerWordSuggestion = new JScrollPane(textAreaWordSuggestion);
            scrollerWordSuggestion.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollerWordSuggestion.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            this.add(scrollerWordSuggestion);

            getWordButton = new JButton("New Word Suggestion");
            getWordButton.addActionListener(this);

            this.add(getWordButton);

        } // **** end MyWordSuggestionPanel() constructor ****


        @Override
        public void actionPerformed(ActionEvent e) {
            textAreaWordSuggestion.append("\n\n" + "+++new word from word bank+++");
        }

    } // **** end MyWordSuggestionPanel inner-class ****

} // **** end StoryWriter class ****
