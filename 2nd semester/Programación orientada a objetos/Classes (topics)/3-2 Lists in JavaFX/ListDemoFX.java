import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ListDemoFX extends Application {
	public void start(Stage stage) throws Exception {
		stage.setTitle("Hello You");
		stage.setWidth(500);
		stage.setHeight(500);
		
		//1. Create the base/root node
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(20);
		
		Label lblElem = new Label("Element");
		pane.add(lblElem, 0,0);
		
		TextField txtElem = new TextField();
		pane.add(txtElem, 1,0);
		
		Label lblData = new Label("Elements");
		pane.add(lblData, 0,1);
		
		ObservableList<String> data = FXCollections.observableArrayList();
		ListView<String> lv = new ListView<>(data);
		pane.add(lv, 1,1);
		
		Button bttnAdd = new Button("Add");
		bttnAdd.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				String text = txtElem.getText();
				data.add(text);
			}
		});		
		pane.add(bttnAdd, 2,0);
		
		Button bttnDel = new Button("Delete");
		bttnDel.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				String item = lv.getSelectionModel().getSelectedItem();
				data.remove(item);
			}
		});
		pane.add(bttnDel, 2,1);
		
		//2. Create the main scene and link it with the stage
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		//3. Call the show method for the stage
		stage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}