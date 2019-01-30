package tinker.music_app;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The full BeatBox.
 *
 * Build a GUI that has 256 checkboxes (JCheckBox) that start out unchecked, 16 labels (JLabel) for the instrument names,
 * and four buttons.
 *
 * Register an ActionListener for each of the four buttons. We don't need listeners for the individual checkboxes,
 * because we aren't trying to change the pattern sound dynamically (i.e. as soon as the user checks a box). Instead, we
 * wait until the user hits the 'start' button, and then walk through all 256 checkboxes to get their state and make a
 * MIDI track.
 *
 * Set-up the MIDI system (you've done this before) including getting a Sequencer, making a Sequence, and creating a
 * track. We are using a sequencer method that's new to Java 5.0, setLoopCount(). This method allows you to specify how
 * many times you want a sequence to loop. We're also using the sequence's tempo factor to adjust the tempo up or down,
 * and maintain the new tempo from one iteration of the loop to the next.
 *
 * When the user hits 'start', the real action begins. The event-handling method for the 'start' button calls the
 * buildTrackAndStart() method. In that method, we walk through all 256 checkboxes (one row at a time, a single
 * instrument across all 16 beats) to get their state, then use the information to build a MIDI track (using the handy
 * makeEvent() method we used in the previous chapter). Once the track is built, we start the sequencer, which keeps
 * playing (because we're looping it) until the user hits 'stop'.
 */
public class BeatBox {

    JFrame theFrame;
    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList;  // We store the checkboxes in an ArrayList<JCheckBox>
    Sequencer sequencer;
    Sequence sequence;
    Track track;

    // These are the names of the instruments, as a String array, for building the GUI labels (on each row).
    String[] instrumentNames = { "Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
            "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap",
            "Low-mid Tom", "High Agogo", "Open Hi Conga" };
    // These represent the actual drum 'keys'. The drum channel is like a piano, except each 'key' on the piano is a
    // different drum. So the number '35' is the key for the Bass drum, '42' is Closed Hit-Hat, etc.
    int[] instruments = { 35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63 };


    public static void main(String[] args) {

        new BeatBox().buildGUI();

    } // **** end main(String[]) ****

    public void buildGUI() {

        theFrame = new JFrame("BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout borderLayout = new BorderLayout();

        JPanel background = new JPanel(borderLayout);
        background.setBorder( BorderFactory.createEmptyBorder(10, 10, 10, 10) );

        // --------------------------------------------------------------

        checkboxList = new ArrayList<JCheckBox>();

        // --------------------------------------------------------------

        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener( new MyStartListener() );
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener( new MyStopListener() );
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener( new MyUpTempoListener() );
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener( new MyDownTempoListener() );
        buttonBox.add(downTempo);

        // ------------------------------------------------------------------

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add( new Label(instrumentNames[i]) );
        }

        // ------------------------------------------------------------------

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);

        GridLayout gridLayout = new GridLayout(16, 16);
        gridLayout.setVgap(1);
        gridLayout.setHgap(2);

        mainPanel = new JPanel(gridLayout);

        background.add(BorderLayout.CENTER, mainPanel);

        // ------------------------------------------------------------------

        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();

        theFrame.setBounds(50, 50, 300, 300);
        theFrame.pack();
        theFrame.setVisible(true);

    } // **** end buildGUI() ****

    public void setUpMidi() {

        try {

            sequencer = MidiSystem.getSequencer();
            sequencer.open();

            sequence = new Sequence(Sequence.PPQ, 4);

            track = sequence.createTrack();

            sequencer.setTempoInBPM(120);

        } catch(Exception ex) { ex.printStackTrace(); }

    } // **** end setUpMidi() ****

    /**
     * This is where it all happens! Where we turn checkbox state into MIDI events, and add them to the Track.
     *
     * We'll make a 16-element array to hold the values for one instrument, across all 16 beats. If the instrument is
     * supposed to play on that beat, the value at that element will be the key. If that instrument is NOT suppose to
     * play on that beat, put in a zero.
     */
    public void buildTrackAndStart() {
        int[] trackList = null;

        // Get rid of the old track, make a fresh one.
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        // ----------------------------------------

        // Do this for each of the 16 ROWS (i.e. Bass, Congo, etc.).
        for (int i = 0; i < 16; i++) {
            trackList = new int[16];

            // Set the 'key' that represents which instrument this is (Bass, Hi-Hat, etc).
            // The instruments array holds the actual MIDI numbers for each instrument.
            int key = instruments[i];

            // Do this for each of the BEATS for this row.
            for (int j = 0; j < 16; j++) {
                JCheckBox jc = (JCheckBox) checkboxList.get(j + (16*i));

                // Is the checkbox at this beat selected? If yes, put the key value in this slow in the array (the slot
                // that represents this beat). Otherwise, the instrument is NOT supposed to play at this beat, so set it
                // to zero.
                if ( jc.isSelected() ) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            } // **** end inner for-loop ****

            // For this instrument, and for all 16 beats, make events and add them to the track.
            makeTracks(trackList);
            track.add( makeEvent(176, 1, 127, 0, 16) );
        } // **** end outer for-loop ****

        // !!!!
        // We always want to make sure that there IS an event at beat 16 (it goes 0 to 15). Otherwise, the BeatBox
        // might not go to the full 16 beats before it starts over.
        // !!!!
        track.add( makeEvent(192, 9, 1, 0, 15) );

        try {
            sequencer.setSequence(sequence);

            // Let's you specify the number of loop iterations, or in this case, continuous looping.
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);

            // NOW PLAY THE THING!!!
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch(Exception ex) { ex.printStackTrace(); }

    } // **** end buildTrackAndStart() ****

    // *****************************************************************************************************************

    public class MyStartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            buildTrackAndStart();
        }
    } // **** end MyStartListener inner-class ****

    public class MyStopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            sequencer.stop();
        }
    } // **** end MyStopListener inner-class ****

    /**
     * The Tempo Factor scales the sequencer's tempo by the factor provided.
     *
     * The default is 1.0, so we're adjusting +/- 3% per click.
     */
    public class MyUpTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor( (float)(tempoFactor * 1.03) );
        }
    } // **** end MyUpTempoListener inner-class ****

    /**
     * The Tempo Factor scales the sequencer's tempo by the factor provided.
     *
     * The default is 1.0, so we're adjusting +/- 3% per click.
     */
    public class MyDownTempoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor( (float)(tempoFactor * 0.97) );
        }
    } // **** end MyDownTempoListener inner-class ****

    // *****************************************************************************************************************

    /**
     * This makes events for one instrument at a time, for all 16 beats.
     *
     * So it might get an int[] for the Bass drum, and each index in the array will hold either the key of that
     * instrument, or a zero. If it's a zero, the instrument isn't supposed to play at that beat. Otherwise, make an
     * event and add it to the track.
     */
    public void makeTracks(int[] list) {

        for (int i = 0; i < 16; i++) {
            int key = list[i];

            // Make the NOTE ON and NOTE OFF events, and add them to the Track.
            if (key != 0) {
                track.add( makeEvent(144, 9, key, 100, i) );
                track.add( makeEvent(128, 9, key, 100, i+1) );
            }
        }

    } // **** end makeTracks(int[]) ****

    public MidiEvent makeEvent(int messageType, int channel, int one, int two, int tick) {

        MidiEvent event = null;

        try {

            ShortMessage a = new ShortMessage();
            a.setMessage(messageType, channel, one, two);
            event = new MidiEvent(a, tick);

        } catch(Exception ex) { ex.printStackTrace(); }

        return event;

    } // **** end makeEvent(int, int, int, int, int) ****

} // **** end BeatBox class ****
