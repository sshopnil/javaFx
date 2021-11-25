package simpleForm;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.xml.namespace.QName;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

final public class LogInController extends MainController
{

    public TextField loginId;
    public PasswordField loginPass;
    public TextField loginName;
    public Button backtoRegisterBtn;
    public Label failedMsg;
    public Label successMsg;

    void submitAction()
    {
        try
        {
            File file = new File("users.txt");

            FileReader read = new FileReader(file);
            BufferedReader readFromFile = new BufferedReader(read);

            String name = loginName.getText().trim();
            String id = loginId.getText().trim();
            String pass = loginPass.getText().trim();

            int i = 0;
            while (true)
            {
                String nameFromFile = readFromFile.readLine();
                String idFromFile = readFromFile.readLine();
                String passFromFile = readFromFile.readLine();

                System.out.println(nameFromFile);
                System.out.println(idFromFile);
                System.out.println(passFromFile);

                if(name.equals(nameFromFile) && id.equals(idFromFile) && pass.equals(passFromFile))
                {
                    i++;
                    break;
                }
                if (nameFromFile == null)
                {
                    System.out.println("found nulll");
                    break;
                }
            }
            if (i > 0)
            {
                failedMsg.setVisible(false);
                successMsg.setVisible(true);
            }
            else
            {
                successMsg.setVisible(false);
                failedMsg.setVisible(true);
            }
        }
        catch (IOException e1)
        {
            failedMsg.setVisible(true);
        }
    }
    public void submitClicked(MouseEvent mouseEvent)
    {
        submitAction();
    }


    //back to the main page
    public void backtoReg(MouseEvent mouseEvent)
    {
        Stage mainStage = (Stage) backtoRegisterBtn.getScene().getWindow();

        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            mainStage.setScene(new Scene(root));
            mainStage.setTitle("Welcome To the form!");
            mainStage.show();
        }
        catch (IOException e)
        {
            failedMsg.setVisible(true);
        }
    }

    public void whenKeyisPressed(KeyEvent keyEvent)
    {
        if (keyEvent.getCode().equals(KeyCode.ENTER))
        {
            submitAction();
        }
    }
}
