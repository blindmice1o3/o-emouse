package tinker.music_app;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

/**
 * Version 3-3: uses a utility method that makes a message and returns a MidiEvent (no longer static in this version).
 *
 *              Register and listen for the events (but without graphics).
 *              Prints a message at the command-line with each beat.
 *
 *              Also, add GUI parts (build a frame, add a drawing panel to it, and each time we get an event, we draw a
 *              new rectangle and repaint the screen. The only other change from version two is that the notes play
 *              randomly as opposed to simply moving up the scale.
 *              -We make the drawing panel implement the ControllerEventListener interface rather than the program
 *              itself. So when the drawing panel (an inner class) gets the event, it knows how to take care of itself
 *              by drawing the rectangle.
 */
public class MiniMusicPlayer3 {

    static JFrame frame = new JFrame("My First Music Video");
    static MyDrawPanel myPanel;

    public static void main(String[] args) {

        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();

    } // **** end main(String[]) ****

    /**
      * init method for the GUI, instantiates a custom panel (the inner-class called MyDrawPanel), adds the panel to the JFrame.
      */
    public void setUpGui() {

        myPanel = new MyDrawPanel();
        frame.setContentPane(myPanel);
        frame.setBounds(30, 30, 300, 300);
        frame.setVisible(true);

    } // **** end setUpGui() ****

    /**
     * -Calls the method that init the GUI.
     * -Asks for the Sequencer and opens it.
     * -Register the newly instantiated custom panel to the Sequencer as a ControllerEvent listener (one that cares only
     *     about ControllerEvent #127).
     * -Instantiates a Sequence (which is composed of [HAS-A] a track).
     * -Calls a method ( createTrack() ) so we can add a bunch of MidiEvents (using a for-loop) to the Sequence's
     *     Track instance variable.
     *
     * The MidiEvents added to the Sequence's Track are:
     *     (1) NOTE ON events who's note to play is represented by a randomly chosen int.
     *     (2) A ControllerEvent represented by messageType 176 with a ControllerEvent #127 (being the only
     *             ControllerEvent we care about) firing simultaneous to (uses the same int tick [representing the
     *             beat #]) the NOTE ON MidiEvent.
     *     (3) NOTE OFF events.
     *
     * Afterward, the Sequence containing the newly crafted Track is added to the Sequencer (by calling the
     * setSequence(Sequence) method) and the Sequencer calls its start() method.
     */
    public void go() {

        setUpGui();

        try {

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            sequencer.addControllerEventListener( myPanel, new int[] { 127 } );

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            // Add a bunch of different notes (selected randomly using local variable "r"),
            // also creates a triggerable MidiEvent (the ControllerEvent [176]) that's simultaneously fired when
            // NOTE ON MidiEvent is fired.
            int r = 0;
            for (int i = 0; i < 60; i += 4) {

                r = (int) ( (Math.random() * 50) + 1 );

                track.add( makeEvent(144, 1, r, 100, i) );
                track.add( makeEvent(176, 1, 127, 0, i) );
                track.add( makeEvent(128, 1, r, 100, i+2) );

            } // end loop

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(120);
            sequencer.start();

        } catch (Exception ex) { ex.printStackTrace(); }

    } // **** end go() ****

    public MidiEvent makeEvent(int messageType, int channel, int one, int two, int tick) {

        MidiEvent event = null;

        try {

            ShortMessage a = new ShortMessage();
            a.setMessage(messageType, channel, one, two);
            event = new MidiEvent(a, tick);

        } catch (Exception ex) { ex.printStackTrace(); }

        return event;

    } // **** end makeEvent(int, int, int, int, int) ****

    /**
     * The custom JPanel is an inner-class that is registered as the ControllerEvent listener to the Sequencer.
     *
     * It uses a flag called boolean msg to determine whether or not to draw a filledRect of random color, of random
     * height/width, at random x, y.
     *
     * The flag is set to false by default.
     *
     * It is set to true only when the ControllerEvent handler method ( the overriden controlChange(ShortMessage) ) is
     * triggered (which is tracked by a MidiEvent with messageType 176 representing a ControllerEvent [#127] that is
     * called simultaneous to NOTE ON MidiEvents (they both use the same int tick [which represents beat#]).
     *
     * Its paintComponent(Graphics) uses randomly generated ints to represent r, g, b to select a random color for
     * drawing a filledRect that is placed on the panel at a randomly selected x and y with its height and width also
     * being randomly selected. It sets the boolean msg flag back to false.
     */
    class MyDrawPanel extends JPanel
        implements ControllerEventListener {

        boolean msg = false;

        @Override
        public void controlChange(ShortMessage event) {

            msg = true;
            repaint();

        } // **** end controlChange(ShortMessage) method => ControllerEvent handler method
          //                                                (called when ControllerEvent #127 is triggered). ****

        public void paintComponent(Graphics g) {

            if (msg) {

                Graphics2D g2d = (Graphics2D) g;

                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);
                g.setColor( new Color(r, gr, b) );


                int x = (int) ( (Math.random() * 40) + 10 );
                int y = (int) ( (Math.random() * 40) + 10 );
                int ht = (int) ( (Math.random() * 120) + 10 );
                int width = (int) ( (Math.random() * 120) + 10 );
                g.fillRect(x, y, ht, width);


                msg = false;

            } // **** end if-statement utilizing a flag (boolean msg) ****

        } // **** end paintComponent(Graphics) ****

    } // **** end MyDrawPanel inner-class ****

} // **** end MiniMusicPlayer3 class ****
