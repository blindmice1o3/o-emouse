package tinker.music_app;

import javax.sound.midi.*;

/**
 * Version 3-2: uses a utility method that makes a message and returns a MidiEvent (no longer static in this version).
 *
 *              Also, register and listen for the events (but without graphics).
 *              Prints a message at the command-line with each beat.
 */
public class MiniMusicPlayer2
        // We need to listen for ControllerEvents, so we implement the listener interface.
        implements ControllerEventListener {

    public static void main(String[] args) {

        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();

    } // **** end main(String[]) ****

    public void go() {

        try {

            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            // Register for events with the sequencer.
                // The event registration method takes the listener AND an int array representing the list of
                // ControllerEvents you want. We want only one event, #127.
            int[] eventsIWant = { 127 };
            sequencer.addControllerEventListener(this, eventsIWant);

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 5; i < 60; i += 4) {

                track.add( makeEvent(144, 1, i, 100, i) );

                // Here's how we pick up the beat --
                    // we insert our OWN ControllerEvent (176 says the event type is ControllerEvent)
                    // with an argument for event number #127.
                // This event will do NOTHING! We put it in JUST so that we can get an event each time a note is played.
                // In other words, its SOLE purpose is so that something will fire that we CAN listen for (we can't
                // listen for NOTE ON/OFF events).
                // Note that we're making this event happen at the SAME tick as the NOTE ON.
                // So when the NOTE ON event happens, we'll know about it because OUR event will fire at the same time.
                track.add( makeEvent(176, 1, 127, 0, i) );

                track.add( makeEvent(128, 1, i, 100, i+2) );

            } // end loop

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception ex) { ex.printStackTrace(); }

    } // **** end go() ****

    /**
     * The event handler method (from the ControllerEventListener interface).
     * Each time we get the event, we'll print "la" to the command-line.
     */
    @Override
    public void controlChange(ShortMessage event) {

        System.out.println("la");

    } // *** end controlChange(ShortMessage) ****

    public MidiEvent makeEvent(int messageType, int channel, int one, int two, int tick) {

        MidiEvent event = null;

        try {

            ShortMessage a = new ShortMessage();
            a.setMessage(messageType, channel, one, two);
            event = new MidiEvent(a, tick);

        } catch (Exception ex) { }

        return event;

    } // **** end makeEvent(int, int, int, int, int) ****

} // **** end MiniMusicPlayer2 class ****
