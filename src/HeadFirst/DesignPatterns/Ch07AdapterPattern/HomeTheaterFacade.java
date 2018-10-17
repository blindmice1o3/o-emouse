package HeadFirst.DesignPatterns.Ch07AdapterPattern;

public class HomeTheaterFacade {
    // Here's the composition; these are all the components of the subsystem we are going to use.
    /*
    Amplifier amp;
    Tuner tuner;
    DvdPlayer dvd;
    CdPlayer cd;
    Projector projector;
    TheaterLights lights;
    Screen screen;
    PopcornPopper popper;

    // The facade is passed a reference to each component of the subsystem in its constructor. The facade then assigns
    // each to the corresponding instance variable.
    public HomeTheaterFacade(Amplifier amp,
                Tuner tuner,
                DvdPlayer dvd,
                CdPlayer cd,
                Projector projector,
                Screen screen,
                TheaterLights lights,
                PopcornPopper popper) {
        this.amp = amp;
        this.tuner = turner;
        this.dvd = dvd;
        this.cd = cd;
        this.projector = projector;
        this.screen = screen;
        this.lights = lights;
        this.popper = popper;
     }

     // watchMovie() follows the same sequence we had to do by hand before, but wraps it up in a handy method that does
     // all the work. Notice that for each task we are delegating the responsibility to the corresponding component in
     // the subsystem.
     public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvd);
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
     }

     // And endMovie() takes care of shutting everything down for us. Again, each task is delegated to the appropriate
     // component in the subsystem.
     public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popper off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
     }

     */
}
