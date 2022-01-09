package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    private static ObservableList<Student> students=FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<Student> choiceBox;

    @FXML
    private CheckBox firstCheckBox;

    @FXML
    private CheckBox secondCheckBox;

    @FXML
    private TableColumn<Student, Integer> studentGroup;

    @FXML
    private TableColumn<Student, String> studentName;

    @FXML
    private TableColumn<Student, String> studentSurname;

    @FXML
    private Button viewButton;

    @FXML
    private TableView<Student> tableOfStudents;

    @FXML
    void initialize() {
        createInfo();
        viewButton.setOnAction(actionEvent -> {printInfo();});
    }
    private void printInfo(){
        ObservableList<Student> stud=FXCollections.observableArrayList();

        if(firstCheckBox.isSelected() && secondCheckBox.isSelected()){
            choiceBox.setItems(students);
        }else if(firstCheckBox.isSelected()){
            for(int i=0;i<students.size();i++){
                if(i%2==0){
                    stud.add(students.get(i));
                }
            }
            choiceBox.setItems(stud);
        }else if(secondCheckBox.isSelected()){
            for(int i=0;i<students.size();i++){
                if(i%2==1){
                    stud.add(students.get(i));
                }
            }
            choiceBox.setItems(stud);
        }else{
            choiceBox.show();
        }
    }

    private void createInfo(){
        students.add(new Student("Иван","Сергеев" ,972302));
        students.add(new Student("Илья", "Букин",964604));
        students.add(new Student("Александр", "Минченков",174003));
        students.add(new Student("Матвей", "Лисницкий",179603));

        studentSurname.setCellValueFactory(new PropertyValueFactory<Student, String>("surname"));
        studentName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        studentGroup.setCellValueFactory(new PropertyValueFactory<Student, Integer>("group"));
        tableOfStudents.setItems(students);
    }

}