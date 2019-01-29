package tinker.music_app;

import javax.sound.midi.*;

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
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
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