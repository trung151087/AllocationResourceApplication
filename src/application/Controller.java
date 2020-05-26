package application;

import java.awt.Desktop;
import java.awt.TextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.sound.midi.Soundbank;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class Controller implements Initializable {
	@FXML
	 private Label labMultiFile;
	@FXML
	 private Label labSingleFile;
	@FXML
	 private Button btnSingleFileChooser = new Button();
	@FXML
	 private Button btnMultiFileChoose = new Button();
		
	 //private TextField textField = new TextField();
	 List<String> lstFile;
	 
	 public void btnMultiFileChoose(ActionEvent event) throws Exception {
		 try {
		 FileChooser fc = new FileChooser();
		 fc.getExtensionFilters().add(new ExtensionFilter("TXT File", lstFile));
		 List<File> f = fc.showOpenMultipleDialog(null);
		 for (File file : f) {
			 System.out.println(file.getAbsolutePath());
			 labMultiFile.setText(file.getAbsolutePath());
		 }} catch (NullPointerException n) {
			 
		 }
	 }
	 public void click(ActionEvent event)
	 {
		 FileChooser fc = new FileChooser();
		 //fc.getExtensionFilters().add(new ExtensionFilter("TXT File", lstFile));
		 fc.getExtensionFilters().add(new ExtensionFilter("Txt", lstFile));
		 File f = fc.showOpenDialog(null);
		 
		 if (f != null) {
			 labSingleFile.setText("Selected file: " + f.getAbsolutePath());
		 }
		 
	 }
	 public void initialize(URL location, ResourceBundle resources) {
		 
	       lstFile = new ArrayList<>();
	       lstFile.add("*.txt");
	       lstFile.add("*.TXT");
	       
	   }
}
