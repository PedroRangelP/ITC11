import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class Drugstore extends Application{
    private Client[] clients = new Client[10];
    //private Laboratory[] laboratories = new Laboratory[10];
    private int counter;
    private TextField txtName, txtAge, txtGender, txtDisease, txtMonth, txtSearchMonth;
    private Label lblNumSearch;
    private ObservableList<Client> data;
    private ListView<Client> lvClient;
    

    public void start(Stage stage) throws Exception{
        BorderPane mainPane = new BorderPane();
        FlowPane contentPane = new FlowPane();
        FlowPane buttonsPane = new FlowPane();
        
        mainPane.setCenter(contentPane);
        mainPane.setBottom(buttonsPane);

        GridPane clientPane = new GridPane();

        Label lblName = new Label("Name");
        txtName = new TextField();
        clientPane.add(lblName, 0, 0);
        clientPane.add(txtName, 1, 0);

        Label lblAge = new Label("Age");
        txtAge = new TextField();
        clientPane.add(lblAge, 0, 1);
        clientPane.add(txtAge, 1, 1);

        Label lblGender = new Label("Gender");
        txtGender = new TextField();
        clientPane.add(lblGender, 0, 2);
        clientPane.add(txtGender, 1, 2);

        Label lblDisease = new Label("Disease");
        txtDisease = new TextField();
        clientPane.add(lblDisease, 0, 3);
        clientPane.add(txtDisease, 1, 3);

        Label lblMonth = new Label("Month");
        txtMonth = new TextField();
        clientPane.add(lblMonth, 0, 4);
        clientPane.add(txtMonth, 1, 4);

        contentPane.getChildren().add(clientPane);

        data = FXCollections.observableArrayList();
        lvClient = new ListView<>(data);
        contentPane.getChildren().add(lvClient);

        lvClient.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                displayClient();
            }
        });

        GridPane searchPane = new GridPane();

        Label lblSearch = new Label("Search month: ");
        txtSearchMonth = new TextField();
        Button bttnMonth = new Button("Search");
        lblNumSearch = new Label("Finded: 0");
        searchPane.add(lblSearch, 0, 0);
        searchPane.add(txtSearchMonth, 1, 0);



        clientPane.add(lblName, 0, 0);
        clientPane.add(txtName, 1, 0);


        buttonsPane.getChildren().add(bttnMonth);
        bttnMonth.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                searchMonth();
            }
        });

        Button bttnAge = new Button("Age");
        buttonsPane.getChildren().add(bttnAge);
        bttnAge.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                sortAge();
            }
        });

        Button bttnGender = new Button("Gender");
        buttonsPane.getChildren().add(bttnGender);
        bttnGender.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                sortGender();
            }
        });

        buttonsPane.getChildren().add(searchPane);

        Scene scene = new Scene(mainPane);
        stage.setScene(scene);
        stage.setWidth(1000);
        stage.setHeight(700);
        stage.show();
    }

    private void displayClient(){

    }

    private void searchMonth(){

    }

    private void sortAge(){

    }

    private void sortGender(){

    }

    public static void main(String[] args) {
        launch();
    }
}