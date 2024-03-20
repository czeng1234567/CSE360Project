package projectPhase2code;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.*;
 
public class projectMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main Menu");
        /*
        Button btn = new Button();
        btn.setText("Display: 'ASU says: Hello World!'");
        btn.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                System.out.println("ASU: Hello World!");
            }
        });
        */
        
        Label homeTitle = new Label("Sunshine Pediatric Center");
        Label newPTitle = new Label("New Patient");
        Label rpTitle = new Label("Returning Patient");
        Label doctorTitle = new Label("Doctor");
        Label nurseTitle = new Label("Nurse");
        Label empty1 = new Label("");
        Label empty2 = new Label("");
        Label empty3 = new Label("");
        
        
        HBox hbox = new HBox(10); 
        HBox rpHbox = new HBox(10);
        HBox npHbox = new HBox(10);
        HBox dHbox = new HBox(10);
        HBox nHbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        Button btnDoctor = new Button("Doctor");
        Button btnNurse = new Button("Nurse");
        Button btnNewPatient = new Button("New Patient");
        Button btnReturnPatient = new Button("Returning Patient");
        
        hbox.getChildren().add(btnDoctor);
        hbox.getChildren().add(btnNurse);
        hbox.getChildren().add(btnNewPatient);
        hbox.getChildren().add(btnReturnPatient);
        
        
        BorderPane homeScreen = new BorderPane(hbox, homeTitle, empty1, empty2, empty3);
        BorderPane rpScreen = new BorderPane(rpHbox, rpTitle, empty1, empty2, empty3);
        BorderPane npScreen = new BorderPane(npHbox, newPTitle, empty1, empty2, empty3);
        BorderPane dScreen = new BorderPane(dHbox, doctorTitle, empty1, empty2, empty3);
        BorderPane nScreen = new BorderPane(nHbox, nurseTitle, empty1, empty2, empty3);
        
        Scene rpScene = new Scene(rpScreen, 800, 300);
        Scene npScene = new Scene(npScreen, 800, 300);
        Scene dScene = new Scene(dScreen, 800, 300);
        Scene nScene = new Scene(nScreen, 800, 300);
        
        btnReturnPatient.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                primaryStage.setScene(rpScene);
            }
        });

        btnNewPatient.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                primaryStage.setScene(npScene);
            }
        });
        
        btnNurse.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                primaryStage.setScene(nScene);
            }
        });
        
        btnDoctor.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                primaryStage.setScene(dScene);
            }
        });
        
        homeScreen.setAlignment(homeTitle, Pos.CENTER);
        primaryStage.setScene(new Scene(homeScreen, 800, 300));

        
       
        primaryStage.show();
    }
}