import javafx.scene.input.MouseEvent;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class HelloYouFX extends Application {
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello You");
        stage.setWidth(500);
        stage.setHeight(500);

        //1. Create the base/root node
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(20);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0 , 0);
        TextField txtName = new TextField();
        pane.add(txtName, 1, 0);

        Label lblAge = new Label("Age:");
        pane.add(lblAge, 0, 1);
        TextField txtAge = new TextField();
        pane.add(txtAge, 1, 1);

        Button bttnClick = new Button("Click");
        HandleClick handler = new HandleClick();
        handler.txtName = txtName;
        bttnClick.addEventFilter(MouseEvent.MOUSE_CLICKED, handler);
        pane.add(bttnClick, 1, 2);

        //2. Create the main scene
        Scene scene = new Scene(pane);
        stage.setScene(scene);

        //3. Call the show method for the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        
    }
}