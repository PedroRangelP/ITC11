import java.io.File;
import java.io.IOException;

public class MyFileManagementTest {
    public static void main(String[] args) {
        try {
            File f = new File("HelloWorld.opp");
            f.createNewFile();
        }catch(IOException e) {
            System.out.println("Error while creating the file");
        }  
    }
}