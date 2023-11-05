package com.example.calcluladora2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    Modelo modelo = new Modelo();


    @FXML
    private Label textField;

    @FXML
    void procesarEventoNumero(ActionEvent event) {
        Button botonPulsado= (Button) event.getSource();
        String numeroPulsado = botonPulsado.getText();

        modelo.constructorNumeros(numeroPulsado);
        textField.setText(modelo.numeroMostrar());
    }

    @FXML
    void botonBorrar(ActionEvent event) {
        modelo.borrarNumero();
        textField.setText("0");
    }

    @FXML
    void botonOperacion(ActionEvent event){
        Button botonPulsado= (Button) event.getSource();
        String operadorPulsado = botonPulsado.getText();
        textField.setText(modelo.numeroMostrar() + operadorPulsado);
            modelo.queOperador(operadorPulsado);

    }

    @FXML
    void ponerComa(ActionEvent event){
        Button botonPulsado= (Button) event.getSource();

        modelo.ponerDecimal();
        textField.setText(modelo.numeroMostrar());
    }

    @FXML
    void botonIgual(ActionEvent event){
        modelo.realizarOperacion();
        textField.setText(modelo.resultadoForm());
    }

}
