package simpleForm;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;

public class RegistryController extends MainController
{

    public Button backFromReg; //back to main page
    public Label regLabel;

    public TextField name;
    public TextField id;
    public PasswordField pass;

    //action when register button is pressed
    public void regFromReg(MouseEvent mouseEvent)
    {
        try
        {
            File file = new File("users.txt");
            PrintWriter writeToFile = new PrintWriter(new FileWriter(file, true));

            writeToFile.append(name.getText().trim() + "\n");
            writeToFile.append(id.getText().trim() + "\n");
            writeToFile.append(pass.getText().trim() + "\n");

            regLabel.setText("Registered successfully!");
            users_count++;

            writeToFile.close();
        }
        catch (IOException e)
        {
            regLabel.setText("Error! in registration process, come back later!");
        }
    }

    public void backToMain(MouseEvent mouseEvent)
    {
        Stage mainStage = (Stage) backFromReg.getScene().getWindow();
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            mainStage.setScene(new Scene(root));
            mainStage.setTitle("Welcome To the form!");
            mainStage.show();
        }
        catch (IOException e)
        {
            regLabel.setText("Main file not found");
        }
    }
}
