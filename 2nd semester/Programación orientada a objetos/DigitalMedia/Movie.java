public class Movie extends DigitalMedia {
    public String director;
    public double duration;
    public int oscarNominations;

    public String toString() {
        return "I'm a movie object";
    }

    public boolean hasOscarNominations() {
        return oscarNominations > 0;
    }
}