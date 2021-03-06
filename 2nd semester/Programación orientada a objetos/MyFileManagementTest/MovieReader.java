import java.io.*;

public class MovieReader {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("movies.oop");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Movie v = (Movie)ois.readObject();
        System.out.println(v.getTitle());

        ois.close();
    }
}