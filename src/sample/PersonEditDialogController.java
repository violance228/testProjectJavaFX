package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Entity.Person;

public class PersonEditDialogController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField birthdayField;

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    @FXML
    private void initialize() { }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPerson(Person person) {
        this.person = person;

        nameField.setText(person.getName());
        surnameField.setText(person.getSurname());
        streetField.setText(person.getStreet());
        postalCodeField.setText(Integer.toString(person.getPostalCode()));
        birthdayField.setText(String.valueOf(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {

        }
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if ((nameField.getText() == null) || (nameField.getText().length() == 0)) {
            errorMessage += "No valid name!\n";
        } else if (surnameField.getText() == null || surnameField.getText().length() == 0) {
            errorMessage += "No valid name!\n";
    }
}
