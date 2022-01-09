package setWindow;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import threads.HoursThread;
import threads.MinutsThread;
import threads.SecondsThread;

public class SetTime {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField hourInput;

    @FXML
    private TextField minutInput;

    @FXML
    private TextField secondInput;

    @FXML
    private Button setIputTimeButton;

    @FXML
    void setTime() {
        if(!isDigit(hourInput.getText())){
            alertMessage("в поле часов");
        }else if(!isDigit(minutInput.getText())){
            alertMessage("в поле минут");
        }else if(!isDigit(secondInput.getText())){
            alertMessage("в поле секунд");
        }else {
            if(!checkHour(hourInput)){
                alertMessage("в поле Часов");
            }else if(!checkSecMin(minutInput)){
                alertMessage("в поле Минут");
            }
            else if(!checkSecMin(secondInput)){
                alertMessage("в поле Секунд");
            }
            else {
                HoursThread.hours = Integer.parseInt(hourInput.getText());
                MinutsThread.minutes = Integer.parseInt(minutInput.getText());
                SecondsThread.seconds = Integer.parseInt(secondInput.getText());
            }
        }
    }

    @FXML
    void initialize() {

    }

    private boolean checkHour(TextField field){
        if(Integer.parseInt(field.getText())<13 && Integer.parseInt(field.getText())>0)
            return true;
        else
            return false;
    }

    private boolean checkSecMin(TextField field){
        if(Integer.parseInt(field.getText())<61 && Integer.parseInt(field.getText())>0)
            return true;
        else
            return false;
    }

    private void alertMessage(String mes){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Введите допустимое значение "+ mes,ButtonType.OK);
        alert.setTitle("Ошибка ввода");
        alert.showAndWait();
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}