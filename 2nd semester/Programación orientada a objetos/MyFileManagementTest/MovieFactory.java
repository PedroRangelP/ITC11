import java.io.*;

public class MovieFactory {
    public static void main(String[] args) {
        try{
            Movie m = new Movie(m);
            m.setTitle("Avengers Endgame");
            m.setDirector("Russo Brothers");
            m.setYear("2019");
            m.setDuration("3:01");
            m.setClassification("G");

            FileOutputStream fos = new FileOutputStream("movie.opp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(m);
            oos.close();
        }catch(EmptyFieldException e) {
            System.out.println(e.getMessage());
        }catch(FileNotFoundException fe) {
            System.out.println("File not found");
        }catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        } 
    }
}