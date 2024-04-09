package projectPhase2code.CSE360Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.*;


public class projectMain extends Application {
	public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main Menu");
        
        
        //Creates Layout
        Label homeTitle = new Label("Welcome to Sunshine Pediatric Center");
        Label empty1 = new Label("");
        Label empty2 = new Label("");
        Label empty3 = new Label("");
        
        //Buttons for Layout
        HBox hbox = new HBox(10); 
        hbox.setAlignment(Pos.CENTER);
        Button btnNP = new Button("New Patient");
        Button btnNS = new Button("Nurse");
        Button btnRP = new Button("Returning Patient");
        
        hbox.getChildren().add(btnNP);
        hbox.getChildren().add(btnNS);
        hbox.getChildren().add(btnRP);
        
        //---------------------------------------------------------------------
        /*
         * This part is designated for the New Patient Creation Screen
         */
        
        Random rand = new Random();
        
        //Labels
        Label firstName = new Label("First Name");
        Label lastName = new Label("Last Name");
        Label email = new Label("email");
        Label phoneNumber = new Label("Phone Number");
        Label address = new Label("Address");
        Label birthday = new Label("Birthday");
        
        //Text fields
        TextField fn = new TextField();
        TextField ln = new TextField();
        TextField em = new TextField();
        TextField pn = new TextField();
        TextField ad = new TextField();
        TextField bd = new TextField();
        
        //Formatted into Vbox
        VBox textVbox = new VBox(15); 
        VBox taVbox = new VBox(7); 
        
        Button btnSave = new Button("Save");
        
        textVbox.getChildren().add(firstName);
        textVbox.getChildren().add(lastName);
        textVbox.getChildren().add(email);
        textVbox.getChildren().add(phoneNumber);
        textVbox.getChildren().add(address);
        textVbox.getChildren().add(birthday);
        
        taVbox.getChildren().add(fn);
        taVbox.getChildren().add(ln);
        taVbox.getChildren().add(em);
        taVbox.getChildren().add(pn);
        taVbox.getChildren().add(ad);
        taVbox.getChildren().add(bd);
        taVbox.getChildren().add(btnSave);
        
        //Formatted into borderpane (originally was a stackpane)
        BorderPane piStack = new BorderPane();
        piStack.setLeft(textVbox);
        piStack.setCenter(taVbox);
        
        //ID creation
        int pID = rand.nextInt(99999);
        
        //Making sure to get file name correct
        StringBuilder filenameSB = new StringBuilder("");
        filenameSB.append(pID);
        filenameSB.append("_PatientInfo.txt");
        
        String filename = new String(filenameSB.toString());
        
        btnSave.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	try {
        	      File patientInfo = new File(filename);
        	      FileWriter fileWriter = new FileWriter(filename);
        	        System.out.println("File created: " + patientInfo.getName());
        	        if(fn.getText().equals("")) {
        	        	fileWriter.write(" \n");
        	        } else {
        	        	fileWriter.write(fn.getText() + "\n");
        	        }
        	        if(ln.getText().equals("")) {
        	        	fileWriter.write(" \n");
        	        } else {
        	        	fileWriter.write(ln.getText() + "\n");
        	        }
        	        if(em.getText().equals("")) {
        	        	fileWriter.write(" \n");
        	        } else {
        	        	fileWriter.write(em.getText() + "\n");
        	        }
        	        if(pn.getText().equals("")) {
        	        	fileWriter.write(" \n");
        	        } else {
        	        	fileWriter.write(pn.getText() + "\n");
        	        }
        	        if(ad.getText().equals("")) {
        	        	fileWriter.write(" \n");
        	        } else {
        	        	fileWriter.write(ad.getText() + "\n");
        	        }
        	        if(bd.getText().equals("")) {
        	        	fileWriter.write(" \n");
        	        } else {
        	        	fileWriter.write(ad.getText() + "\n");
        	        }
        	        fileWriter.close(); 
        	    } catch (IOException e) {
        	      System.out.println("An error occurred.");
        	      e.printStackTrace();
        	    }
            }
        });
        
       
        
        //---------------------------------------------------------------------
        
        /*
         * This part is designated for the Patient View Screen
         */
        Label empty = new Label("");
        Label editProfile = new Label("Edit Profile: ");
        Label firstN = new Label("First Name: ");
        Label lastN = new Label("Last Name: ");
        Label birthD = new Label("Birthday: ");
        Label phoneN = new Label("Phone Number: ");
        Label emai = new Label("Email: ");
        Label addr = new Label("Address: ");
        Label errorOccurence = new Label("");
        
        TextField firstNField = new TextField();
        TextField lastNField = new TextField();
        TextField birthDField = new TextField();
        TextField phoneNField = new TextField();
        TextField emaiField = new TextField();
        TextField addrField = new TextField();
        
        
        //Formatted into vboxes
        VBox textVbox3 = new VBox(7); 
        VBox taVbox3 = new VBox(); 
        
        textVbox3.getChildren().addAll(editProfile, firstN, lastN, birthD, phoneN, emai, addr);
        
        taVbox3.getChildren().add(empty);
        taVbox3.getChildren().addAll(firstNField, lastNField, birthDField, phoneNField, emaiField, addrField, errorOccurence);
        
        BorderPane pvStack = new BorderPane();
        pvStack.setLeft(textVbox3);
        pvStack.setCenter(taVbox3);
        
        
        Scene pvScene2 = new Scene(pvStack, 800, 300);
        
        
        //---------------------------------------------------------------------
        
        /*
         * This part is designated for the Patient Login Screen
         */
        Label warning = new Label("");
        Label pid3 = new Label("Patient ID: ");
        TextField pidField2 = new TextField();
        Button btnLogin = new Button("Login");
        
        HBox hboxLogin = new HBox();
        hboxLogin.getChildren().addAll(pid3, pidField2, btnLogin, warning);
        
        //Getting and reading from file comes here. When clicking the login button
        btnLogin.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
				StringBuilder filenameSB4 = new StringBuilder("");
                filenameSB4.append(pidField2.getText());
                filenameSB4.append("_PatientInfo.txt");
                String filename4 = filenameSB4.toString();
	            try {
					FileReader fileReader = new FileReader(filename4);
				} catch (FileNotFoundException e) {
					errorOccurence.setText("Patient ID not found!");
					e.printStackTrace();
				}
                primaryStage.setScene(pvScene2);
                
            }
            
        });
        
        
        //---------------------------------------------------------------------
        
        //Formatting the app
        BorderPane homeScreen = new BorderPane(hbox, homeTitle, empty1, empty2, empty3);
        
        Scene piScene = new Scene(piStack, 800, 300);
        Scene pvScene = new Scene(hboxLogin, 800, 300);
        
        btnNP.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                primaryStage.setScene(piScene);
            }
        });
        
        btnRP.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                primaryStage.setScene(pvScene);
            }
        });
        
        primaryStage.setScene(new Scene(homeScreen, 800, 300));

        
       
        primaryStage.show();
    }
}