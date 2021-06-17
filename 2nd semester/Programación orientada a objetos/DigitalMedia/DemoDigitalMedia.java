import java.util.GregorianCalendar;

public class DemoDigitalMedia {
    public static void main(String[] args) {
        Videogame v = new Videogame();
        v.publisher = "Nintendo";
        v.platform = "Nintendo Switch";
        v.region = "North America";
        v.title = "Mario Bros.";
        v.genre = "Platforms";
        v.classification = "E";
        v.language = "English";
        v.releaseDate = new GregorianCalendar(2019, 2, 22).getGregorianChange();

        Movie m = new Movie();
        m.title = "Seven";
        m.director = "David Fincher";
        m.duration = 120;
        m.oscarNominations = 3;
        m.genre = "Thriller";
        m.classification = "+18";

        DigitalMedia[] dm = new DigitalMedia[10];
        dm[0] = v;
        dm[1] = m;

        System.out.println(dm[0]);
        System.out.println(dm[1]);

        Videogame v2 = (Videogame)dm[0]; //Access to Videogame attributes
    }
}