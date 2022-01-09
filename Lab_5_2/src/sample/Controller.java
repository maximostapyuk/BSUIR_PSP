package sample;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    private ArrayList<Person> library=new ArrayList<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private CheckBox firstCheck;

    @FXML
    private CheckBox forthCheck;

    @FXML
    private TextArea hobbyField;

    @FXML
    private TextField nameField;

    @FXML
    private CheckBox secondCheck;

    @FXML
    private RadioButton sexMRadio;

    @FXML
    private RadioButton sexWRadio;

    @FXML
    private TextField surnameField;

    @FXML
    private CheckBox thirdCheck;

    @FXML
    void initialize() {
        ToggleGroup group = new ToggleGroup();
        sexMRadio.setToggleGroup(group);
        sexWRadio.setToggleGroup(group);

        addButton.setOnAction(actionEvent -> {addInfo();});


        printInfo();
    }

    private void addInfo(){
        Person person = new Person();
        person.setName(nameField.getText());
        person.setSurname(surnameField.getText());
        if(sexMRadio.isSelected()){
            person.setSex("Мужской");
        }else if(sexWRadio.isSelected()){
            person.setSex("Женский");
        }
        else
            person.setSex("Неопределено");
        String study=new String();
        if(firstCheck.isSelected())
            study+="Гимназия ";
        if(secondCheck.isSelected())
            study+="Лицей ";
        if(thirdCheck.isSelected())
            study+="Школа ";
        if(forthCheck.isSelected())
            study+="Университет ";
        person.setStudy(study);
        person.setHobby(hobbyField.getText());
        library.add(person);
    }
    private void printInfo(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt")))
        {
            oos.writeObject(library);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }


}
