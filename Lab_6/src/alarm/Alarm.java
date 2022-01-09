package alarm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import threads.HoursThread;
import threads.MinutsThread;

public class Alarm {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField hourInput;

    @FXML
    private TextField minutInput;

    @FXML
    private Button setAlarmButton;

    @FXML
    void setTime() {
        if(!isDigit(hourInput.getText())){
            alertMessage("в поле часов");
        }else if(!isDigit(minutInput.getText())){
            alertMessage("в поле минут");
        }else {
            if(!checkHour(hourInput)){
                alertMessage("в поле Часов");
            }else if(!checkMin(minutInput)){
                alertMessage("в поле Минут");
            }
            else {
                HoursThread.alarmHours = Integer.parseInt(hourInput.getText());
                MinutsThread.alarmMinutes = Integer.parseInt(minutInput.getText());
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

    private boolean checkMin(TextField field){
        if(Integer.parseInt(field.getText())<61 && Integer.parseInt(field.getText())>0)
            return true;
        else
            return false;
    }

    private void alertMessage(String mes){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Введите допустимое значение "+ mes, ButtonType.OK);
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