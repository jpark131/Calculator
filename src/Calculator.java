import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

	Label Display;
	Double result;
	String opList[] = {"+", "-", "*", "/", "logleft", "logright"};
	Button eq = new Button("="); 
	TextField left = new TextField();
	TextField right = new TextField();
	ComboBox ops = new ComboBox(FXCollections.observableArrayList(opList));
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception{
		stage.setTitle("Calculator");
		Display = new Label("");
		VBox root = new VBox();
		HBox row1 = new HBox();
		
		eq.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				OpFactory opfac = new OpFactory();
				Operation op = opfac.getOp((String) ops.getValue());
				result = op.calculate(left.getText(), right.getText());
				Display.setText(Double.toString(result));
			}});
		
		
		root.getChildren().add(row1);
		root.getChildren().add(Display);
		row1.getChildren().add(left);
		row1.getChildren().add(ops);
		row1.getChildren().add(right);
		row1.getChildren().add(eq);
		Scene scene = new Scene(root, 600, 600);
		stage.setScene(scene);
		
		
		stage.show();
	}
}
