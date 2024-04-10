package cse360Phase3;

//public class cse360Phase3 
//{
	//package application;


	import javafx.application.Application;
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;

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
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextField;
	import javafx.scene.paint.Color;
	import javafx.scene.shape.Rectangle;
	import javafx.stage.Stage;
	import javafx.scene.layout.*;


	public class cse360Phase3 extends Application {
		public static void main(String[] args) {
	        launch(args);
	    }
	    
	    public void start(Stage primaryStage) {
	        primaryStage.setTitle("Main Menu");
	        
	        
	        //Creates Layout
	        Label homeTitle = new Label("Welcome to Sunshine Pediatric Center");
	        homeTitle.setStyle("-fx-font-size: 24px; -fx-alignment: center;");
	        //StackPane stackPane = new StackPane(homeTitle);
	        //stackPane.setAlignment(Pos.CENTER);
	        //StackPane stackPane = new StackPane(homeTitle);
	        //stackPane.setAlignment(Pos.CENTER);
	        //stackPane.setPrefSize(800, 300);
	        Label empty1 = new Label("");
	        Label empty2 = new Label("");
	        Label empty3 = new Label("");
	        
	        //Buttons for Layout
	        HBox hbox = new HBox(10); 
	        hbox.setAlignment(Pos.CENTER);
	        Button btnNP = new Button("New Patient");
	        Button btnNS = new Button("Nurse");
	        Button btnRP = new Button("Returning Patient");
	        Button btnDR = new Button("Doctor");
	        
	        String buttonStyle = "-fx-padding: 10px 20px; -fx-background-color: #007bff; -fx-text-fill: white;";
	        
	        btnNP.setStyle(buttonStyle);
	        btnNS.setStyle(buttonStyle);
	        btnRP.setStyle(buttonStyle);
	        btnDR.setStyle(buttonStyle);
	        
	        hbox.getChildren().add(btnNP);
	        hbox.getChildren().add(btnNS);
	        hbox.getChildren().add(btnRP);
	        hbox.getChildren().add(btnDR); 
	        
	        //---------------------------------------------------------------------
	        /*
	         * This part is designated for the New Patient Creation Screen
	         */
	        
	        Random rand = new Random();
	        
	        //Labels
	        //Label npTitle = new Label("New Patient Login");
	        //npTitle.setStyle("-fx-font-size: 18px; -fx-alignment: center;");
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
	        Button back = new Button("Back");
	        

	        //textVbox.getChildren().add(npTitle);
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
	        taVbox.getChildren().add(back);
	        
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
	        //Scene homeScene = new Scene(homeScreen, 800, 300);
	        
	        
	        
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
	        Button btnLogin = new Button("");
	        Button backRP = new Button("Back");
	        
	        HBox hboxLogin = new HBox();
	        hboxLogin.getChildren().addAll(pid3, pidField2, btnLogin, warning, backRP);
	        
	        
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
	        
	        //THIS part is NURSE - shania
	        ObservableList<String> patientNames = FXCollections.observableArrayList(); //a place to store each patient's name
	        btnSave.setOnAction(new EventHandler<>() //each time save is clicked on patient intake it is added to the array list so it can be accessed on nurse view
	        {
	            public void handle(ActionEvent event) {
	                String fullName = fn.getText() + " " + ln.getText(); //gets appropriate information
	                patientNames.add(fullName); //adds it
	            }
	        });
	        ComboBox<String> patientDropdown = new ComboBox<>();//combo box/drop down
	        patientDropdown.setItems(patientNames);
	        
	        
	        
	        Label pageNurse = new Label("Nurse Dashboard");
	        Button backN = new Button("Back");
	        VBox nurseLayout = new VBox(10);
	        nurseLayout.setAlignment(Pos.CENTER);
	        
	        //Rectangle rectangle = new Rectangle(100, 50);
	        //rectangle.setFill(Color.BLUE);
	        Label patientNamesL = new Label("Patients: ");
	        Rectangle rectangle = new Rectangle(200, 100); // Width, Height
	        rectangle.setFill(null); // No fill color
	        rectangle.setStroke(Color.BLACK); // Outline color
	        rectangle.setStrokeWidth(2);
	        
	        VBox num1 = new VBox();
	        num1.getChildren().addAll(patientNamesL, rectangle);
	        
	        Label patientNamesM = new Label("Messages: ");
	        Rectangle rectangle2 = new Rectangle(200, 100); // Width, Height
	        rectangle2.setFill(null); // No fill color
	        rectangle2.setStroke(Color.BLACK); // Outline color
	        rectangle2.setStrokeWidth(2);
	        
	        VBox num2 = new VBox();
	        num2.getChildren().addAll(patientNamesM, rectangle2);
	        
	        Label patientVisits = new Label("Upcoming visists");
	        Rectangle rectangle3 = new Rectangle(200, 100); // Width, Height
	        rectangle3.setFill(null); // No fill color
	        rectangle3.setStroke(Color.BLACK); // Outline color
	        rectangle3.setStrokeWidth(2);
	        
	        VBox num3 = new VBox();
	        num3.getChildren().addAll(patientVisits, rectangle3); 

	        StackPane stackPane = new StackPane();
	        stackPane.getChildren().addAll(num1, patientDropdown);

	        HBox hboxPanes = new HBox();
	        hboxPanes.setSpacing(10);
	        hboxPanes.getChildren().addAll(stackPane, num2, num3);
	        hboxPanes.setAlignment(Pos.CENTER);

	        
	        
	        
	        //nurseLayout.getChildren().addAll(pageNurse, backN);
	        Scene nurseScene = new Scene(nurseLayout, 800, 300);
	        btnNS.setOnAction(new EventHandler<ActionEvent>() 
	        {
	            public void handle(ActionEvent event) {
	                primaryStage.setScene(nurseScene);
	            }
	        });
	        
	        nurseLayout.getChildren().addAll(pageNurse, hboxPanes, backN);
	        
	        //implement back to home even handling
	        
	        
	        
	        //---------------------------------------------------------------------
	        
	        //Formatting the app
	        //BorderPane homeScreen = new BorderPane(hbox, homeTitle, empty1, empty2, empty3);
	        VBox homeLayout = new VBox(10); // 10 pixels spacing between nodes
	        homeLayout.setAlignment(Pos.CENTER); // Center alignment
	        homeLayout.getChildren().addAll(homeTitle, hbox, empty1, empty2, empty3);

	        Scene homeScene = new Scene(homeLayout, 800, 300);
	        
	        Scene piScene = new Scene(piStack, 800, 300);
	        Scene pvScene = new Scene(hboxLogin, 800, 300);
	        
	        btnNP.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
	                primaryStage.setScene(piScene);
	            }
	        });
	        
	        //set on actions being declared after proper scene declarations
	        
	        btnRP.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) 
	            {
	                primaryStage.setScene(pvScene);
	            }
	        });
	        
	        back.setOnAction(new EventHandler<>() 
	        {
	            public void handle(ActionEvent event) 
	            {
	                primaryStage.setScene(homeScene);
	            }
	        });
	        
	        backN.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) 
	            {
	                primaryStage.setScene(homeScene);
	            }
	        });
	        
	        backRP.setOnAction(new EventHandler<>() 
	        {
	            public void handle(ActionEvent event) 
	            {
	                primaryStage.setScene(homeScene);
	            }
	        });
	        
	        //primaryStage.setScene(new Scene(homeScene, 800, 300));
	        primaryStage.setScene(homeScene);


	        
	       
	        primaryStage.show();
	    }
	}

