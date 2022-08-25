import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private Button calculateButton;

    @FXML
    private Label classificationLabel;

    @FXML
    private TextField heightField;

    @FXML
    private Label imcLabel;

    @FXML
    private Label warningLabel;

    @FXML
    private TextField weightField;

    private double imc;
    private String status;

    @FXML
    public void initialize() {
        calculateButton.setOnMouseClicked((ev) -> {
            calculateImc();
        });

        weightField.setOnKeyTyped((ev) -> {
            hideWarning();
        });

        heightField.setOnKeyTyped((ev) -> {
            hideWarning();
        });
    }

    private void hideWarning() {
        warningLabel.setText("");
    }

    private void calculateImc() {
        var weight = weightField.getText();
        var height = heightField.getText();

        if (weight.trim().isEmpty() || height.trim().isEmpty()) {
            warningLabel.setText("Peso ou altura inválidos");
        } else {
            try {
                Double.parseDouble(weight);
                Double.parseDouble(height);
            } catch (NumberFormatException e) {
                warningLabel.setText("Peso ou altura inválidos");
            }
            
            imc = Double.parseDouble(weight) / (Math.pow(Double.parseDouble(height), 2));

            if (imc < 18.5) {
                status = "Baixo peso";
            } else if (imc < 25.0) {
                status = "Peso normal";
            } else if (imc < 30.0) {
                status = "Excesso de peso";
            } else if (imc < 35.0) {
                status = "Obesidade de Classe 1";
            } else if (imc < 40.0) {
                status = "Obesidade de Classe 2";
            } else {
                status = "Obesidade de Classe 3";
            }
            
            updateUi();
        }
    }

    private void updateUi() {
        imcLabel.setText(String.format("%.2f", imc));
        classificationLabel.setText(status);
    }
}
