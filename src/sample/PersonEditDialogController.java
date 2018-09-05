package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Entity.Person;

import java.time.LocalDate;

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
            person.setName(nameField.getText());
            person.setSurname(surnameField.getText());
            person.setStreet(streetField.getText());
            person.setPostalCode(Integer.parseInt(postalCodeField.getText()));
            person.setCity(cityField.getText());
            person.setBirthday(LocalDate.parse(birthdayField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if ((nameField.getText() == null) || (nameField.getText().length() == 0)) {
            errorMessage += "No valid name!\n";
        } else if (surnameField.getText() == null || surnameField.getText().length() == 0) {
            errorMessage += "No valid surname!\n";
        } else if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        } else if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "No valid postalCode!\n";
        }  else if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }  else if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            return false;
        }
    }
}
