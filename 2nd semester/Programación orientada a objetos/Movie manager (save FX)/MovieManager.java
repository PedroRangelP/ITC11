import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.io.*;

public class MovieManager extends Application {   
    private TextField txtDirector, txtTitle, txtDuration, txtYear, txtClassification;
    private ObservableList<Movie> data;
    private ListView<Movie> lvMovie;

    public void start(Stage stage) throws Exception {
        BorderPane mainPane = new BorderPane();

        FlowPane contentPane = new FlowPane();
        FlowPane controlsPane = new FlowPane();
        mainPane.setCenter(contentPane);
        mainPane.setBottom(controlsPane);

        // Content
        GridPane moviePane = new GridPane();
        Label lblTitle = new Label("Title");
        txtTitle = new TextField();
        moviePane.add(lblTitle, 0, 0);
        moviePane.add(txtTitle, 1, 0);

        Label lblDirector = new Label("Director");
        txtDirector = new TextField();
        moviePane.add(lblDirector, 0, 1);
        moviePane.add(txtDirector, 1, 1);

        Label lblDuration = new Label("Duration");
        txtDuration = new TextField();
        moviePane.add(lblDuration, 0, 2);
        moviePane.add(txtDuration, 1, 2);

        Label lblYear = new Label("Year");
        txtYear = new TextField();
        moviePane.add(lblYear, 0, 3);
        moviePane.add(txtYear, 1, 3);

        Label lblClassification = new Label("Classification");
        txtClassification = new TextField();
        moviePane.add(lblClassification, 0, 4);
        moviePane.add(txtClassification, 1, 4);

        contentPane.getChildren().add(moviePane);

        // List
        data = FXCollections.observableArrayList();
        lvMovie = new ListView<>(data);
        contentPane.getChildren().add(lvMovie);
        getMovie();

        lvMovie.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                displayMovie();
            }
        });

        // Controls
        Button bttnAdd = new Button("Add");
        controlsPane.getChildren().add(bttnAdd);
        bttnAdd.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                addMovie();
            }
        });

        Button bttnDelete = new Button("Delete");
        controlsPane.getChildren().add(bttnDelete);
        bttnDelete.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                deleteMovie();
            }
        });

        Button bttnSave = new Button("Save");
        controlsPane.getChildren().add(bttnSave);
        bttnSave.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                saveMovie();
            }
        });

        // 2. Create the main scene and link it with the stage
        Scene scene = new Scene(mainPane);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(500);
        // 3. Call the show method for the stage
        stage.show();
    }
    
    private void addMovie() {
        try {
            /*
            //Read the information for a movie and create an object
            Movie m = new Movie();
            getMovie(m);
            //Add the object to my list
            data.add(m);
            //Clear the form
            setMovie(new Movie());
            */

            // Read the information for a movie and create an object
            Movie m = new Movie();
            m.setTitle(txtTitle.getText());
            m.setDirector(txtDirector.getText());
            m.setDuration(txtDuration.getText());
            m.setClassification(txtClassification.getText());
            m.setYear(txtYear.getText());

            // Add the object to my list
            data.add(m);

            // Clear the form
            txtTitle.setText("");
            txtDirector.setText("");
            txtDuration.setText("");
            txtClassification.setText("");
            txtYear.setText("");

        } catch (EmptyFieldException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Add a movie");
            alert.setHeaderText("Error while adding a new movie");
            alert.setContentText(e.getMessage());

            alert.showAndWait();
        }
    }

    private void deleteMovie() {
        //Obtain the selected movie
        Movie m = lvMovie.getSelectionModel().getSelectedItem();
        //Remove it from the data
        data.remove(m);
    }

    private void saveMovie() {
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("Success");
        success.setHeaderText("Movies saved successfully");

        try {
            Movie[] movies = new Movie[lvMovie.getItems().size()];
            int i = 0;
            for (Movie m : lvMovie.getItems()) {
                movies[i] = m;
                i++;
            }
            FileOutputStream fos = new FileOutputStream("movies.oop");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(movies);
            oos.close();
            success.showAndWait();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    private void displayMovie() {
        //Obtain the selected movie
        Movie m = lvMovie.getSelectionModel().getSelectedItem();
        txtTitle.setText(m.getTitle());
        txtDuration.setText(m.getDuration());
        txtDirector.setText(m.getDirector());
        txtYear.setText(m.getYear());
        txtClassification.setText(m.getClassification());
    }

    private void getMovie() {
        try {
            FileInputStream fis = new FileInputStream("movies.oop");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Movie[] movies = (Movie[]) ois.readObject();
            for (int i = 0; i < movies.length; i++) {
                data.add(movies[i]);
            }
            ois.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}