import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MovieFX extends Application {
	private TextField txtDirector, txtTitle, txtDuration, txtYear, txtClassification;
	private ObservableList<Movie> data;
	private ListView<Movie> lvMovie;
	
	public void start(Stage stage) throws Exception {
		//1. Create the main node
		BorderPane mainPane = new BorderPane();
		
		FlowPane contentPane = new FlowPane();
		FlowPane controlsPane = new FlowPane();
		mainPane.setCenter(contentPane);
		mainPane.setBottom(controlsPane);
		
		//Content
		GridPane moviePane = new GridPane();
		Label lblTitle = new Label("Title");
		txtTitle = new TextField();
		moviePane.add(lblTitle, 0,0);
		moviePane.add(txtTitle, 1,0);
		
		Label lblDirector = new Label("Director");
		txtDirector = new TextField();
		moviePane.add(lblDirector, 0,1);
		moviePane.add(txtDirector, 1,1);
		
		Label lblDuration = new Label("Duration");
		txtDuration = new TextField();
		moviePane.add(lblDuration, 0,2);
		moviePane.add(txtDuration, 1,2);
		
		Label lblYear = new Label("Year");
		txtYear = new TextField();
		moviePane.add(lblYear, 0,3);
		moviePane.add(txtYear, 1,3);
		
		Label lblClassification = new Label("Classification");
		txtClassification = new TextField();
		moviePane.add(lblClassification, 0,4);
		moviePane.add(txtClassification, 1,4);
		
		contentPane.getChildren().add(moviePane);
		
		//List
		data = FXCollections.observableArrayList();
		lvMovie = new ListView<>(data);
		contentPane.getChildren().add(lvMovie);
		
		//Controls
		Button bttnAdd = new Button("Add");
		controlsPane.getChildren().add(bttnAdd);
		
		Button bttnDelete = new Button("Delete");
		controlsPane.getChildren().add(bttnDelete);
		
		Button bttnSave = new Button("Save");
		controlsPane.getChildren().add(bttnSave);
		
		//2. Create the main scene and link it with the stage
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setWidth(500);
		stage.setHeight(500);
		//3. Call the show method for the stage
		stage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}