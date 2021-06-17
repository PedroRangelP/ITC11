import javafx.application.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloWorldFX extends Application {
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello World");
        //1. Create the base/root node
        Group group = new Group();
        //2. Create the main scene
        Scene scene = new Scene(group);
        stage.setScene(scene);
        //3. Call the show method for the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        
    }
}