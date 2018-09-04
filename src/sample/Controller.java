package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import sample.Entity.Person;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class Controller {

    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> nameColunmn;
    @FXML
    private TableColumn<Person, String> surnameColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label surnameLable;
    @FXML
    private Label streetLable;
    @FXML
    private Label postalCodeLable;
    @FXML
    private Label cityLable;
    @FXML
    private Label birthdayLable;

    private Main main;

    public Controller() { }

    @FXML
    private void initialize() {
        nameColunmn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        surnameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        showPersonDetails(null);

        personTable.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> showPersonDetails(newValue)));

    }

    public void setMain(Main main) {
        this.main = main;

        personTable.setItems(main.getPersonData());
    }

    public void showPersonDetails(Person person) {
        if(person != null) {
            nameLabel.setText(person.getName());
            surnameLable.setText(person.getSurname());
            streetLable.setText(person.getStreet());
            postalCodeLable.setText(Integer.toString(person.getPostalCode()));
            cityLable.setText(person.getCity());
            birthdayLable.setText(String.valueOf(person.getBirthday()));
        } else {
            nameLabel.setText("");
            surnameLable.setText("");
            streetLable.setText("");
            postalCodeLable.setText("");
            cityLable.setText("");
            birthdayLable.setText("");
        }
    }

    @FXML
    private void handleDeletePerson() {

        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        try {
            if (selectedIndex >= 0) {
                personTable.getItems().remove(selectedIndex);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(main.getPrimaryStage());
                alert.setTitle("No selection");
                alert.setHeaderText("No Person Selected");
                alert.setContentText("Please select a person in the table.");

                alert.showAndWait();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }
}
