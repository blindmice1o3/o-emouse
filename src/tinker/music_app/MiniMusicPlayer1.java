package tinker.music_app;

import javax.sound.midi.*;

/**
 * Version 3-1: uses a static utility method that makes a message and returns a MidiEvent
 */
public class MiniMusicPlayer1 {

    public static void main(String[] args) {

        try {

            // make (and open) a sequencer
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            // make a sequence and a track
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            // make a bunch of events to make the notes keep going up (from piano note 5 to piano note 61)
            for (int i = 5; i < 61; i += 4) {

                // call our new makeEvent() method to make the message and event, then add the result (the MidiEvent
                // returned from makeEvent()) to the track. These are NOTE ON (144) and NOTES OFF (128) pairs.
                track.add( makeEvent(144, 1, i, 100, i) );
                track.add( makeEvent(128, 1, i, 100, i+2) );

            } // end loop

            // start it running
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception ex) { ex.printStackTrace(); }

    } // **** end main(String[]) ****

    public static MidiEvent makeEvent(int messageType, int channel, int one, int two, int tick) {

        MidiEvent event = null;

        try {

            ShortMessage a = new ShortMessage();
            a.setMessage(messageType, channel, one, two);
            event = new MidiEvent(a, tick);

        } catch (Exception ex) { }

        return event;

    } // **** end makeEvent(int, int, int, int, int) ****

} // **** end MiniMusicPlayer1 class ****
