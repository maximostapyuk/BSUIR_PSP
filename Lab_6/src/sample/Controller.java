package sample;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import setWindow.SetTime;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Controller {
    private boolean startFlag = false;
    private boolean realFirst = true;
    private Thread hoursThread;
    private Thread minutesThread;
    private Thread secondsThread;
    private double delta;
    private double r;
    private double angle = Math.PI / 2;
    private int minutes=15;

    @FXML
    private Text alarm;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Line hourLine;

    @FXML
    private Line minuteLine;

    @FXML
    private Line secondLine;

    @FXML
    private Button setAlarmTimeButton;

    @FXML
    private Button setTimeButton;

    @FXML
    void initialize() {
        setTimeButton.setVisible(false);
        setAlarmTimeButton.setVisible(false);
        alarm.setVisible(false);
        hourLine.setVisible(false);
        delta=Math.PI/30;
        r=(Math.abs(Math.abs(secondLine.getStartY()) + Math.abs(secondLine.getEndY())));
        secondsThread = new Thread(() -> {
            double temp= angle;
            while (true) {
                temp -= delta;
                secondLine.setStartX(secondLine.getEndX() + r*Math.cos(temp));
                secondLine.setStartY(secondLine.getEndY() - r*Math.sin(temp));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        minutesThread = new Thread(() -> {
            double temp= 0;
            while (true) {
                minuteLine.setEndX(minuteLine.getStartX() + (r-38)*Math.cos(temp));
                minuteLine.setEndY(minuteLine.getStartY() - (r-38)*Math.sin(temp));
                temp -= delta;
                if(minutes==Time.alarmMinutes){
                    alarm.setVisible(true);
//                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Сработал будильник!", ButtonType.OK);
//                    alert.setTitle("Будильник");
//                    alert.showAndWait();
                }
                minutes++;
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        /*hoursThread = new Thread(() -> {
            double temp= -angle;
            while (true) {
                hourLine.setEndX(hourLine.getStartX() + (r-38)*Math.cos(temp));
                hourLine.setEndY(hourLine.getStartY() - (r-38)*Math.sin(temp));
                temp -= delta;
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });*/
        secondsThread.start();
        minutesThread.start();
        //hoursThread.start();
    }
    private void alertMessage(String mes){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Сработал будильник!"+ mes,ButtonType.OK);
        alert.setTitle("Будильник");
        alert.showAndWait();
    }

    @FXML
    void setAlarmWindow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../alarm/alarm.fxml"));
        try {
            loader.load();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Установка будильника");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    void setTimeWindow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../setWindow/setTime.fxml"));
        try {
            loader.load();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Установка времени");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }


}