package cse360Phase3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	    
	    public void start(Stage primaryStage) throws SQLException {
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
	        Label npTitle = new Label("New Patient Login");
	        npTitle.setStyle("-fx-font-size: 18px; -fx-alignment: center;");
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
	        
	        //fn.setPrefWidth(150);
	        
	        //Formatted into Vbox
	        VBox textVbox = new VBox(15); 
	        VBox taVbox = new VBox(7); 
	        
	        Button btnSave = new Button("Save");
	        Button back = new Button("Back");
	        
	        //VBox totalTNP = new VBox();
	        
	        

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
	            	
	            }
	        });
	        
	        //totalTNP.getChildren().addAll();
	        
	       
	        
	        //---------------------------------------------------------------------
	        
	        /*
	         * This part is designated for the Patient View Screen
	         */
	        Label titleT = new Label("Welcome new patient!");
	        Label empty = new Label("");
	        Label editProfile = new Label("Edit Profile: ");
	        Label firstN = new Label("First Name: ");
	        Label lastN = new Label("Last Name: ");
	        Label birthD = new Label("Birthday: ");
	        Label phoneN = new Label("Phone Number: ");
	        Label emai = new Label("Email: ");
	        Label addr = new Label("Address: ");
	        Label sms = new Label("SMS: ");
	        Label sentMessages = new Label("");
	        Label errorOccurence = new Label("");
	        
	        TextField firstNField = new TextField();
	        TextField lastNField = new TextField();
	        TextField birthDField = new TextField();
	        TextField phoneNField = new TextField();
	        TextField emaiField = new TextField();
	        TextField addrField = new TextField();
	        TextField smsField = new TextField();
	        
	        
	        Button backToHome = new Button("Back");
	        Button updateInfo = new Button("Update");
	        Button smsSend = new Button("Send");
	        
	        StringBuilder sentString = new StringBuilder("");
	        
	        //Formatted into vboxes
	        VBox textVbox3 = new VBox(7); 
	        VBox taVbox3 = new VBox(); 
	        
	        textVbox3.getChildren().addAll(editProfile, firstN, lastN, birthD, phoneN, emai, addr, sms);
	        
	        taVbox3.getChildren().add(empty);
	        taVbox3.getChildren().addAll(firstNField, lastNField, birthDField, phoneNField, emaiField, addrField, smsField, updateInfo, smsSend, backToHome, sentMessages, errorOccurence);
	        
	        BorderPane pvStack = new BorderPane();
	        pvStack.setLeft(textVbox3);
	        pvStack.setCenter(taVbox3);
	        
	        
	        Scene pvScene2 = new Scene(pvStack, 800, 300);
	        
	      //Getting and reading from file comes here. When clicking the login button
	        
	        
	        
	        //---------------------------------------------------------------------
	        
	        /*
	         * This part is designated for the Patient Login Screen
	         */
	        Label namePID = new Label("Welcome returning patient!");
	        namePID.setStyle("-fx-font-size: 24px; -fx-alignment: center;");
	        
	        Label warning = new Label("");
	        Label pid3 = new Label("Patient ID: ");
	        TextField pidField2 = new TextField();
	        pidField2.setMaxWidth(250);
	        Button btnLogin = new Button("Login");
	        Button backRP = new Button("Back");
	        
	        VBox verticalUsage = new VBox();
	        verticalUsage.setAlignment(Pos.CENTER);
	        verticalUsage.getChildren().addAll(namePID, pid3, pidField2, warning);
	        
	        HBox hboxLogin = new HBox();
	        hboxLogin.setAlignment(Pos.CENTER);
	        hboxLogin.getChildren().addAll(backRP,btnLogin);
	        
	        VBox htotal = new VBox();
	        htotal.setAlignment(Pos.CENTER);
	        htotal.getChildren().addAll(verticalUsage, hboxLogin); 
	        
	        
	        String idGet = pidField2.getText();
	        
	        //Deletes old text file and rebuilds it from the ground up with updated info
	        updateInfo.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
					StringBuilder filenameSB4 = new StringBuilder("");
	                filenameSB4.append(pidField2.getText());
	                filenameSB4.append("_PatientInfo.txt");
	                String filename4 = filenameSB4.toString();
	                try {
						FileWriter fileWriter2 = new FileWriter(filename4);
						File myObj = new File(filename4);
						myObj.delete();
						File patientInfo = new File(filename4);
						System.out.println("File rebuilt: " + patientInfo.getName());
	        	        if(firstNField.getText().equals("")) {
	        	        	fileWriter2.write(" \n");
	        	        } else {
	        	        	fileWriter2.write(firstNField.getText() + "\n");
	        	        }
	        	        if(lastNField.getText().equals("")) {
	        	        	fileWriter2.write(" \n");
	        	        } else {
	        	        	fileWriter2.write(lastNField.getText() + "\n");
	        	        }
	        	        if(birthD.getText().equals("")) {
	        	        	fileWriter2.write(" \n");
	        	        } else {
	        	        	fileWriter2.write(birthD.getText() + "\n");
	        	        }
	        	        if(phoneNField.getText().equals("")) {
	        	        	fileWriter2.write(" \n");
	        	        } else {
	        	        	fileWriter2.write(phoneNField.getText() + "\n");
	        	        }
	        	        if(emaiField.getText().equals("")) {
	        	        	fileWriter2.write(" \n");
	        	        } else {
	        	        	fileWriter2.write(emaiField.getText() + "\n");
	        	        }
	        	        if(addrField.getText().equals("")) {
	        	        	fileWriter2.write(" \n");
	        	        } else {
	        	        	fileWriter2.write(addrField.getText() + "\n");
	        	        }
	        	        fileWriter2.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
	                primaryStage.setScene(pvScene2);
	                
	            }
	            
	        });
	        
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
	        
	        //THIS part is NURSE
	        ObservableList<String> patientNames = FXCollections.observableArrayList(); //a place to store each patient's name
	        btnSave.setOnAction(new EventHandler<>() //each time save is clicked on patient intake it is added to the array list so it can be accessed on nurse view
	        {
	            public void handle(ActionEvent event) {
	                String fullName = fn.getText() + " " + ln.getText(); //gets appropriate information
	                patientNames.add(fullName); //adds it
	                try {
		        	      File patientInfo = new File(filename); //When the save button is clicked, it saves all info to a text file labeled with ID
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
	        
	        StackPane messageStackPane = new StackPane();
	        Label messagesReceived = new Label("");
	        messageStackPane.getChildren().addAll(num2, messagesReceived);
	        
	        Label patientVisits = new Label("Upcoming visists");
	        Rectangle rectangle3 = new Rectangle(200, 100); // Width, Height
	        rectangle3.setFill(null); // No fill color
	        rectangle3.setStroke(Color.BLACK); // Outline color
	        rectangle3.setStrokeWidth(2);
	        
	        VBox num3 = new VBox();
	        num3.getChildren().addAll(patientVisits, rectangle3); 
	        
	        ComboBox<String> upcomingVisits = new ComboBox<>();
	        StackPane stackPane2 = new StackPane();
	        stackPane2.getChildren().addAll(num3, upcomingVisits);
	        

	        StackPane stackPane = new StackPane();
	        stackPane.getChildren().addAll(num1, patientDropdown);

	        HBox hboxPanes = new HBox();
	        hboxPanes.setSpacing(10);
	        hboxPanes.getChildren().addAll(stackPane, messageStackPane, stackPane2);
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
	        
	      //Getting and reading from file comes here. When clicking the login button
	        smsSend.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
					StringBuilder filenameSB4 = new StringBuilder("");
	                filenameSB4.append(pidField2.getText());
	                filenameSB4.append("_SMS.txt");
	                String filename4 = filenameSB4.toString();
		            try {
		            	FileWriter filewriter = new FileWriter(filename4);
		            	sentString.append(smsField.getText() + "\n");
		            	String convertedSentString = sentString.toString();
		            	sentMessages.setText(convertedSentString); // Attaches messages to both the patient login as well as the nurse view
		            	messagesReceived.setText(convertedSentString);
		            	filewriter.write(convertedSentString);
		            	filewriter.close();
					} catch (FileNotFoundException e) {
						errorOccurence.setText("Patient ID not found!");
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                primaryStage.setScene(pvScene2);
	                
	            }
	            
	        });
	        
	        
	        
	        //---------------------------------------------------------------------
	        
	        
	        //implementing doctor
	        
	        Label doctorTitle = new Label("Welcome doctor!");
	        doctorTitle.setStyle("-fx-font-size: 24px;");
	        doctorTitle.setAlignment(Pos.CENTER); // Center the text within the label
	        
	        Label appointmentD = new Label("Appointments");
	        Button scheduleApp = new Button("Schedule");
	        Button manageApp = new Button("Manage");
	        
	        
	        

	        Rectangle rectangle4 = new Rectangle(200, 100); // Width, Height
	        rectangle4.setFill(null); // No fill color
	        rectangle4.setStroke(Color.BLACK); // Outline color
	        rectangle4.setStrokeWidth(2);
	        
	        StackPane stackPane5 = new StackPane();
	        stackPane5.getChildren().addAll(rectangle4, appointmentD, scheduleApp, manageApp);

	        // Align the labels and buttons within the StackPane
	        stackPane5.setAlignment(appointmentD, Pos.CENTER);
	        stackPane5.setAlignment(scheduleApp, Pos.BOTTOM_LEFT);
	        stackPane5.setAlignment(manageApp, Pos.BOTTOM_RIGHT); 

	        Rectangle rectangle5 = new Rectangle(200, 100); // Width, Height
	        rectangle5.setFill(null); // No fill color
	        rectangle5.setStroke(Color.BLACK); // Outline color
	        rectangle5.setStrokeWidth(2);
	        
	        Label medicalHistoryL = new Label("Patient Medical History");
	        StackPane stackPane6 = new StackPane();
	        stackPane6.getChildren().addAll(rectangle5, medicalHistoryL); 
	        
	        stackPane6.setAlignment(medicalHistoryL, Pos.TOP_CENTER);

	        Rectangle rectangle6 = new Rectangle(200, 100); // Width, Height
	        rectangle6.setFill(null); // No fill color
	        rectangle6.setStroke(Color.BLACK); // Outline color
	        rectangle6.setStrokeWidth(2);
	        
	        Label patientFindingsL = new Label("Patient Findings");
	        StackPane stackPane7 = new StackPane();
	        stackPane7.getChildren().addAll(rectangle6, patientFindingsL); 
	        
	        stackPane7.setAlignment(patientFindingsL, Pos.TOP_CENTER);

	        Rectangle rectangle7 = new Rectangle(200, 100); // Width, Height
	        rectangle7.setFill(null); // No fill color
	        rectangle7.setStroke(Color.BLACK); // Outline color
	        rectangle7.setStrokeWidth(2);
	        
	        Label prescribeMedicineL = new Label("PrescribeMedicine");
	        StackPane stackPane8 = new StackPane();
	        stackPane8.getChildren().addAll(rectangle7, prescribeMedicineL); 
	        
	        stackPane8.setAlignment(prescribeMedicineL, Pos.TOP_CENTER);

	        HBox doctorRectangles = new HBox();
	        doctorRectangles.setSpacing(10);
	        doctorRectangles.getChildren().addAll(stackPane5, stackPane6, stackPane7, stackPane8); 
	        
	        Button backD = new Button("Back");

	        VBox doctorSetup = new VBox();
	        doctorSetup.setAlignment(Pos.CENTER);
	        doctorSetup.setSpacing(20);
	        doctorSetup.getChildren().addAll(doctorRectangles, backD); 

	        BorderPane root = new BorderPane();
	        root.setTop(doctorTitle);
	        root.setAlignment(doctorTitle, Pos.CENTER); // Center the title horizontally
	        root.setCenter(doctorSetup);

	        Scene doctorScene = new Scene(root, 800, 300);

	        btnDR.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
	                primaryStage.setScene(doctorScene);
	            }
	        });
	        
	        //Formatting the app
	        //BorderPane homeScreen = new BorderPane(hbox, homeTitle, empty1, empty2, empty3);
	        VBox homeLayout = new VBox(10); // 10 pixels spacing between nodes
	        homeLayout.setAlignment(Pos.CENTER); // Center alignment
	        homeLayout.getChildren().addAll(homeTitle, hbox, empty1, empty2, empty3);

	        Scene homeScene = new Scene(homeLayout, 800, 300);
	        
	        Scene piScene = new Scene(piStack, 800, 300);
	        Scene pvScene = new Scene(htotal, 800, 300);
	        
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
	        
	        backToHome.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
	                primaryStage.setScene(homeScene);
	            }
	            
	        });
	        
	        backD.setOnAction(new EventHandler<>() 
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
	    
	    void createConnection(int uniqueID, String firstName, String lastName, String email, String phoneNumber, String address, String birthday) throws SQLException {
	    	try {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
	    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "blueangels");	
	    		Statement stmt = con.createStatement();
	    		//ResultSet rs = stmt.executeQuery("INSERT INTO Patients(idpatients, firstName, lastName, email, phoneNumber, address, birthday) VALUES (?, ?, ?, ?, ?, ?, ?)");
	    		stmt.executeQuery("INSERT INTO Patients(idpatients, firstName, lastName, email, phoneNumber, address, birthday) VALUES (?, ?, ?, ?, ?, ?, ?)");
	    		System.out.println("Database connection sucess");
	    	} catch(ClassNotFoundException ex){
	    		Logger.getLogger(cse360Phase3.class.getName()).log(Level.SEVERE, null, ex);
	    	}
	    }
	    
	   
	}

