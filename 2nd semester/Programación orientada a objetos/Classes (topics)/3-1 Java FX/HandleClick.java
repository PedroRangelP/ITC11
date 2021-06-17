import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;

public class HandleClick implements EventHandler<MouseEvent> {
	public TextField txtName;
	
	public void handle(MouseEvent event) {
		System.out.println("Hello " + txtName.getText());
	}
}