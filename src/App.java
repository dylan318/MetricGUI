import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        
        Label inputLabel = new Label("Enter Value:");
        Label resultLabel = new Label("Result:");

        
        TextField inputField = new TextField();

        
        ComboBox<String> conversionType = new ComboBox<>();
        conversionType.getItems().addAll("Meters to Feet", "Feet to Meters", "Kilograms to Pounds", "Pounds to Kilograms");
        conversionType.setValue("Meters to Feet");

        
        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> {
            try {
                double inputValue = Double.parseDouble(inputField.getText());
                String selectedConversion = conversionType.getValue();
                double result = performConversion(inputValue, selectedConversion);
                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input. Please enter a valid number.");
            }
        });

        
        gridPane.add(inputLabel, 0, 0);
        gridPane.add(inputField, 1, 0);
        gridPane.add(conversionType, 0, 1);
        gridPane.add(convertButton, 1, 1);
        gridPane.add(resultLabel, 0, 2, 2, 1);

        
        Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setScene(scene);

        
        primaryStage.show();
    }

    private double performConversion(double inputValue, String conversionType) {
        
        switch (conversionType) {
            case "Meters to Feet":
                return inputValue * 3.28084;
            case "Feet to Meters":
                return inputValue / 3.28084;
            case "Kilograms to Pounds":
                return inputValue * 2.20462;
            case "Pounds to Kilograms":
                return inputValue / 2.20462;
            default:
                return 0.0;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

