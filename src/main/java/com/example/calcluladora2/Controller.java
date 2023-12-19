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
    private Label mostrarOperaciones;

    @FXML
    void procesarEventoNumero(ActionEvent event) {
        Button botonPulsado = (Button) event.getSource();
        String numeroPulsado = botonPulsado.getText();

        modelo.constructorNumeros(numeroPulsado);
        textField.setText(modelo.numeroMostrar());
    }

    @FXML
    void botonBorrar(ActionEvent event) {
        modelo.borrarNumero();
        textField.setText("0");
        mostrarOperaciones.setText("");
    }

    @FXML
    void botonOperacion(ActionEvent event) {
        Button botonPulsado = (Button) event.getSource();
        String operadorPulsado = botonPulsado.getText();
        mostrarOperaciones.setText(modelo.numeroMostrar() + operadorPulsado);
        textField.setText(modelo.numeroMostrar());
        modelo.queOperador(operadorPulsado);


    }

    @FXML
    void ponerComa(ActionEvent event) {
        Button botonPulsado = (Button) event.getSource();

        modelo.ponerDecimal();
        textField.setText(modelo.numeroMostrar());
    }

    @FXML
    void botonIgual(ActionEvent event) {
        mostrarOperaciones.setText(mostrarOperaciones.getText() + modelo.numeroMostrar());
        modelo.realizarOperacion();
        textField.setText(modelo.resultadoForm());
    }

    @FXML
    void borrarUno(ActionEvent event) {
        modelo.borrarUno();
        textField.setText(modelo.numeroMostrar());
    }

}
