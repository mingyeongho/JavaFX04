package test;



import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{
	TableView<Person> table = new TableView<Person>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		VBox root = new VBox();
		root.setPadding(new Insets(10));
		root.setSpacing(5);
		
		Label label = new Label("Address Book");
		label.setFont(new Font("Arial",20));
		
		table.setEditable(true);
		TableColumn firstNameCol = new TableColumn("First Name");
		TableColumn lastNameCol = new TableColumn("Last Name");
		TableColumn emailCol = new TableColumn("Email");
		
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		
		table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
		
		root.getChildren().addAll(label, table);
		
		Scene scene = new Scene(root, 350, 300);
		
		primaryStage.setTitle("Test");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public class Person{
		private SimpleStringProperty firstName;
		private SimpleStringProperty lastName;
		private SimpleStringProperty email;
		
		public Person(String firstName, String lastName, String email) {
			this.firstName = new SimpleStringProperty(firstName);
			this.lastName = new SimpleStringProperty(lastName);
			this.email = new SimpleStringProperty(email);
		}
		
		public String getFirstName() {
			return this.firstName.get();
		}
		public void setFirstName(String firstName) {
			this.firstName.set(firstName);
		}
		public String getLastName() {
			return this.lastName.get();
		}
		public void setLastName(String lastName) {
			this.lastName.set(lastName);
		}
		public String getEmail() {
			return this.email.get();
		}
		public void setEmail(String email) {
			this.email.set(email);
		}
	}
	public static void main(String[] args) {
		launch(args);

	}

}
