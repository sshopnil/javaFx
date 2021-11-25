package simpleForm;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainController
{
    public Button regFromMain;
    public Button logInFromMain;
    public Label messageBoxMain;

    public static int users_count = 1;

    public void logInClicked(MouseEvent mouseEvent)
    {
        try
        {
            Stage loginStage = (Stage) logInFromMain.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
            loginStage.setTitle("Sign in");
            loginStage.setScene(new Scene(root));
            loginStage.show();
        }
        catch (IOException e1)
        {
            messageBoxMain.setText("Error!! Invalid registration process....");
        }
    }

    public void RegClicked(MouseEvent mouseEvent)
    {
        try
        {
            Stage regStage = (Stage) regFromMain.getScene().getWindow();

            Parent root = FXMLLoader.load(getClass().getResource("RegisterPage.fxml"));
            regStage.setTitle("Register yourself!");
            regStage.setScene(new Scene(root));
            regStage.show();
        }
        catch (IOException e)
        {
            messageBoxMain.setText("Error!! Invalid registration process....");
        }
    }
}
