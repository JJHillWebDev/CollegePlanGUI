import java.util.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class DormAndMealPlan extends Application
{

	private final double ALLENHALL = 1800.0;
	private final double PIKEHALL = 2200.0;
	private final double FARTHINGHALL = 2800.0;
	private final double UNIVERSITYSUITES = 3000.0;
	private final double SEVENMEALS = 600.0;
	private final double FOURTEENMEALS = 1100.0;
	private final double UNLIMITEDMEALS = 1800.0;
	private double costDorm;
	private double costMeal;
	private double totalCost;

	public static void main(String[] args)
	{
		launch(args);
	}   

	@Override
	public void start(Stage primaryStage)
	{
		Label dormLabel = new Label("Select a Dorm");
		Label mealLabel = new Label("Select a Meal Plan");

		ComboBox<String> dormComboBox = new ComboBox<>();
		dormComboBox.getItems().addAll("Allen Hall", 
									   "Pike Hall",
									   "Farthing Hall", 
									   "University Suites");

		ComboBox<String> mealComboBox = new ComboBox<>();
		mealComboBox.getItems().addAll("7 meals per week", 
									   "14 meals per week",
									   "Unlimited meals");

		VBox dormVbox = new VBox(10, dormLabel, dormComboBox);
		dormVbox.setPadding(new Insets(10));
		dormVbox.setAlignment(Pos.CENTER_LEFT);

		VBox mealVbox = new VBox(10, mealLabel, mealComboBox);
		mealVbox.setPadding(new Insets(10));
		mealVbox.setAlignment(Pos.CENTER_LEFT);

		HBox comboHbox = new HBox(dormVbox, mealVbox);
		comboHbox.setAlignment(Pos.CENTER);

		Label totalCostLabel = new Label("Cost: ");
		Button calcButton = new Button("Calculate");

		VBox costVbox = new VBox(10, totalCostLabel, calcButton);
		costVbox.setPadding(new Insets(10));
		costVbox.setAlignment(Pos.CENTER);
		
		calcButton.setOnAction(e ->
		{
			String dormSelection = 
					dormComboBox.getSelectionModel().getSelectedItem();
			if (dormSelection == "Allen Hall")
			{
				costDorm = ALLENHALL;
			}
			else if (dormSelection == "Pike Hall")
			{
				costDorm = PIKEHALL;
			}
			else if (dormSelection == "Farthing Hall")
			{
				costDorm = FARTHINGHALL;
			}
			else if (dormSelection == "University Suites")
			{
				costDorm = UNIVERSITYSUITES;
			}
			
			String mealSelection = 
					mealComboBox.getSelectionModel().getSelectedItem();
			if (mealSelection == "7 meals per week")
			{
				costMeal = SEVENMEALS;
			}
			else if (mealSelection == "14 meals per week")
			{
				costMeal = FOURTEENMEALS;
			}
			else if (mealSelection == "Unlimited meals")
			{
				costMeal = UNLIMITEDMEALS;
			}

			totalCost = costDorm + costMeal;
			totalCostLabel.setText(String.format("Cost:   $%,.2f",totalCost));
		});
		  
		VBox rootVbox = new VBox(comboHbox, costVbox);
		rootVbox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(rootVbox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}