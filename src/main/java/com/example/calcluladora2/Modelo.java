package com.example.calcluladora2;

import java.text.DecimalFormat;


public class Modelo {
    private final static String NUM_DEFAULT = "0.0";

    private final static String PATRON_RESULTADO = "#0.00";

    private final static double NUM_CERO = 0.0;
    private final static String VACIO = "";
    private final static String ADD_COMA = ".";
    private static String num1String = VACIO;
    private static String num2String = VACIO;
    // private static String resultString = VACIO;
    private double resul = NUM_CERO;
    private static String operador;
    private static boolean esNum1 = true;
    private static boolean esNum2 = false;

    private static boolean comaPuesta = false;
    //  private static boolean operadorPuesto = false;

    public Modelo() {
    }

    public static String getNum1String() {
        return num1String;
    }

    public void ponerDecimal() {
        if (!comaPuesta) {
            constructorNumeros(ADD_COMA);
            comaPuesta = true;

        }
    }

    public static void queOperador(String ope) {
        if (num1String.equals("") && ope.equals("-")) {
            num1String = ope + num1String;
        } else {
            operador = ope;
            esNum1 = false;
            esNum2 = true;
            comaPuesta = false;
        }
    }


    public static void constructorNumeros(String add) {
        if (esNum1) {
            num1String = num1String + add;

        } else {
            num2String = num2String + add;

        }
    }

    public void realizarOperacion() {
        if (!esNum1 && esNum2) {
            num1String = eliminarVacios(num1String);
            num2String = eliminarVacios(num2String);
            double num1 = Double.parseDouble(num1String);
            double num2 = Double.parseDouble(num2String);

            switch (operador) {
                case "+":
                    resul = num1 + num2;
                    break;
                case "-":
                    resul = num1 - num2;
                    break;
                case "*":
                    resul = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0.0) {
                        resul = num1 / num2;
                    } else {
                        resul = NUM_CERO;
                        //  resultString= String.valueOf(NUM_CERO);
                    }
                    break;


            }
            // Restablecer valores para nueva operacion o continuar
            //  String resulFormat=  formatearNum(resul);
            restablecer();
            num1String = String.valueOf(resul);
            num2String = VACIO;


        }
    }

    public String resultadoForm() {
        DecimalFormat df = new DecimalFormat(PATRON_RESULTADO);

        String resultadoFormateado = df.format(resul);
        return resultadoFormateado;

    }

    public void borrarNumero() {
        num1String = VACIO;
        num2String = VACIO;
        restablecer();
    }

    public String numeroMostrar() {
        if (esNum1)
            return num1String;

        return num2String;

    }


    private String eliminarVacios(String numeroComprobar) {

        if (numeroComprobar.equals(VACIO) || numeroComprobar.equals(ADD_COMA) || numeroComprobar.equals("-") || numeroComprobar.equals("-.")) {
            numeroComprobar = NUM_DEFAULT;
        }
        return numeroComprobar;
    }

    private static void restablecer() {
        esNum2 = false;
        esNum1 = true;
        comaPuesta = false;
        //  operadorPuesto=false;

    }

    public void borrarUno() {
        String borrarUno;
        if (esNum1) {
            borrarUno = num1String;

        } else {
            borrarUno = num2String;
        }
        if (!borrarUno.equals(VACIO)) {
            if (borrarUno.charAt(borrarUno.length() - 1) == '.') {
                comaPuesta = false;
            }
            borrarUno = borrarUno.substring(0, borrarUno.length() - 1);

        }
        if (esNum1) {
            num1String = borrarUno;

        } else {
            num2String = borrarUno;
        }

    }


}
