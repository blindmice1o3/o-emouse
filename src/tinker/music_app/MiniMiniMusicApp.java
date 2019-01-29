package tinker.music_app;

import javax.sound.midi.*;

/**
 * Version 1:
 *
 */
public class MiniMiniMusicApp {

    public static void main(String[] args) {

        MiniMiniMusicApp musicApp = new MiniMiniMusicApp();
        musicApp.play();

    } // **** end main(String[]) ****

    public void play() {

        try {
            // Get a Sequencer and open it (so we can use it... a Sequencer doesn't come already open).
            Sequencer musicCdPlayer = MidiSystem.getSequencer();
            musicCdPlayer.open();

            // Don't worry about the arguments to the Sequence constructor. Just copy these (think of 'em as Ready-bake arguments).
            Sequence cd = new Sequence(Sequence.PPQ, 4);

            // Ask the Sequence for a Track. Remember, the Track lives in the Sequence, and the MIDI data lives in the Track.
            Track track = cd.createTrack();

            // Put some MidiEvents into the Track. This part is mostly Ready-bake code. The only thing you'll have to
            // care about are the arguments to the setMessage() method, and the arguments to the MidiEvent constructor.
            // We'll look at those arguments on the next page.
            ShortMessage a = new ShortMessage();
                // This message says, "start playing note 44" (we'll look at the other numbers on the next page).
                    // a.setMessage(message type, channel, note to play, velocity);
                    // The last 3 args vary depending on the message type. This is a NOTE ON message, so the other args
                        // are for things the Sequencer needs to know in order to play a note.

                        // MESSAGE TYPE: 144 means NOTE ON (start playing)
                            // 128 means NOTE OFF (stop playing)
                            // 192 means change-instrument (last 3 args vary depending on message type:
                                // first.setMessage(192, 1, 102, 0);
                                    // 1 means in channel 1 (musician 1)
                                    // 102 means to instrument 102
                                    // 0 probably still means VELOCITY
                        // CHANNEL: think of a channel like a musician in a band. Channel 1 is musician 1 (the keyboard
                            // player), channel 9 is the drummer, etc.
                        // NOTE TO PLAY: a number from 0 to 127, going from low to high notes
                        // VELOCITY: how fast and hard did you press the key? 0 is so soft you probably won't hear
                            // anything, but 100 is a good default.

            a.setMessage(144, 1, 44, 100);
                // The instructions are in the message, but the MidiEvent adds the moment in time when the instruction
                // should be triggered. This MidiEvent says to trigger message 'a' at the first beat (beat 1).
            MidiEvent noteOn = new MidiEvent(a, 1);
                // A Track holds all the MidiEvent objects. The Sequence organizes them according to when each event is
                // supposed to happen, and then the Sequencer plays them back in that order. You can have lots of events
                // happening at the exact same moment in time. For example, you might want two notes played simultaneously,
                // or even different instruments playing different sounds at the same time.
            track.add(noteOn);

            ShortMessage b = new ShortMessage();

            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            // Give the Sequence to the Sequencer (like putting the CD into the CD player).
            musicCdPlayer.setSequence(cd);

            // Start() the Sequencer (like pushing PLAY).
            musicCdPlayer.start();

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    } // **** end play() ****

} // **** end MiniMiniMusicApp class ****