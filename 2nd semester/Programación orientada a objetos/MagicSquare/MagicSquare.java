import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class MagicSquare extends Application {
    private TextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9;
    private Label lblResult;

    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        Label lblTitle = new Label("MAGIC SQUARE");
        txt1 = new TextField();
        txt2 = new TextField();
        txt3 = new TextField();
        txt4 = new TextField();
        txt5 = new TextField();
        txt6 = new TextField();
        txt7 = new TextField();
        txt8 = new TextField();
        txt9 = new TextField();
        lblResult = new Label("");
        Button bttnCheck = new Button("Check");
        Button bttnReset = new Button("Reset");

        pane.setHgap(30);
        pane.setVgap(30);

        pane.add(lblTitle, 1, 0);
        pane.add(txt1, 0, 1);
        pane.add(txt2, 1, 1);
        pane.add(txt3, 2, 1);
        pane.add(txt4, 0, 2);
        pane.add(txt5, 1, 2);
        pane.add(txt6, 2, 2);
        pane.add(txt7, 0, 3);
        pane.add(txt8, 1, 3);
        pane.add(txt9, 2, 3);
        pane.add(lblResult, 0, 4);
        pane.add(bttnCheck, 1, 4);
        pane.add(bttnReset, 2, 4);

        bttnCheck.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                check();
            }
        });
        bttnReset.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                reset();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Magic Square");
        stage.setWidth(500);
        stage.setHeight(300);
        stage.show();
    }

    private void check() {
        int[] input = new int[9];
        input[0] = Integer.parseInt(txt1.getText());
        input[1] = Integer.parseInt(txt2.getText());
        input[2] = Integer.parseInt(txt3.getText());
        input[3] = Integer.parseInt(txt4.getText());
        input[4] = Integer.parseInt(txt5.getText());
        input[5] = Integer.parseInt(txt6.getText());
        input[6] = Integer.parseInt(txt7.getText());
        input[7] = Integer.parseInt(txt8.getText());
        input[8] = Integer.parseInt(txt9.getText());

        int num = 0, row1 = 0, row2 = 0, row3 = 0, col1 = 0, col2 = 0, col3 = 0;
        Boolean repeated = false, magicSquare = false;

        // Check repeated num
        for (int i=0; i<input.length; i++) {
            repeated = num == input[i];
            num = input[i];
            if (repeated == true) {
                lblResult.setText("Repeated numbers\nTry again");
                break;
            }
        }

        if (repeated == false) {
            // Rows
            for (int i = 0; i < 3; i++) {
                row1 += input[i];
                row2 += input[i+3];
                row3 += input[i+6];
            }

            // Cols
            for (int i = 0; i < 7; i+=3) {
                col1 += input[i];
                col2 += input[i+1];
                col3 += input[i+2];
            }

            magicSquare = row1==row2 && row2==row3 && col1==col2 && col2==col3;

            if (magicSquare == true)
                lblResult.setText("It's a magic square\nCongrats!");
            else
                lblResult.setText("It's not a magic square\nTry again");
        }
    }

    private void reset() {
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        txt6.setText("");
        txt7.setText("");
        txt8.setText("");
        txt9.setText("");
        lblResult.setText("");
    }

    public static void main(String[] args) {
        launch();
    }

}