package com.iescarrillo.calculatorjcpr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializa los TextView que muestran resultados
        TextView textResult = findViewById(R.id.textResult);
        TextView textAuxResult = findViewById(R.id.textAuxResult);

        // Inicializa el botón CE que resetea el resultado principal a 0
        Button btnCE = findViewById(R.id.btnCE);
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText("0");
            }
        });

        // Inicializa el botón C que resetea toda la calculadora
        Button btnC = findViewById(R.id.btnC);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText("0");

                textAuxResult.setText("");
            }
        });

        // Inicializa el botón Delete que elimina el último dígito o resetea si el resultado auxiliar contiene "="
        ImageButton btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = String.valueOf(textResult.getText());
                String numAux = String.valueOf(textAuxResult.getText());

                if (numAux.contains("=")){
                    textResult.setText("0");

                    textAuxResult.setText("");
                }else{
                    if (num.length() > 1){
                        textResult.setText(num.substring(0, num.length() - 1));
                    }else{
                        textResult.setText("0");
                    }
                }
            }
        });

        // Inicializa el botón que cambia de signo para cambiar el signo del número actual mientras no sea 0
        Button btnChangeSign = findViewById(R.id.btnChangeSign);
        btnChangeSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = String.valueOf(textResult.getText());
                String numChanged;

                if (!num.equals("0")){
                    if (num.contains("-")){
                        numChanged = num.substring(1);
                    }else{
                        numChanged = "-".concat(num);
                    }

                    textResult.setText(numChanged);
                }
            }
        });

        // Inicializa el botón de la coma decimal que añade la coma si no está ya puesta
        Button btnDecimal = findViewById(R.id.btnDecimal);
        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = String.valueOf(textResult.getText());

                if (!num.contains(",")){
                    textResult.setText(num.concat(","));
                }
            }
        });

        // Inicializo todos los botones de los números llamando a un mismo método que los añade

        Button btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnNum = btn9.getText().toString();
                String num = String.valueOf(textResult.getText());

                textResult.setText(addNum(btnNum, num));
            }
        });

        Button btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnNum = btn8.getText().toString();
                String num = String.valueOf(textResult.getText());

                textResult.setText(addNum(btnNum, num));
            }
        });

        Button btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnNum = btn7.getText().toString();
                String num = String.valueOf(textResult.getText());

                textResult.setText(addNum(btnNum, num));
            }
        });

        Button btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnNum = btn6.getText().toString();
                String num = String.valueOf(textResult.getText());

                textResult.setText(addNum(btnNum, num));
            }
        });


        Button btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnNum = btn5.getText().toString();
                String num = String.valueOf(textResult.getText());

                textResult.setText(addNum(btnNum, num));
            }
        });

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnNum = btn4.getText().toString();
                String num = String.valueOf(textResult.getText());

                textResult.setText(addNum(btnNum, num));
            }
        });

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnNum = btn3.getText().toString();
                String num = String.valueOf(textResult.getText());

                textResult.setText(addNum(btnNum, num));
            }
        });

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnNum = btn2.getText().toString();
                String num = String.valueOf(textResult.getText());

                textResult.setText(addNum(btnNum, num));
            }
        });

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnNum = btn1.getText().toString();
                String num = String.valueOf(textResult.getText());

                textResult.setText(addNum(btnNum, num));
            }
        });

        Button btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String btnNum = btn0.getText().toString();
                String num = String.valueOf(textResult.getText());

                textResult.setText(addNum(btnNum, num));
            }
        });

        // Todos los botones operacionales se comportan igual con la diferencia del signo
        // Inicializa y hace la operación usando varios métodos y comprobaciones
        Button btnPlus = findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sign = btnPlus.getText().toString(); // Guardo el símbolo de suma ("+") en una variable
                String num = String.valueOf(textResult.getText()).trim(); // Obtengo el texto principal y elimino espacios
                String numAux = String.valueOf(textAuxResult.getText()).trim(); // Obtengo el texto auxiliar y elimino espacios

                // Verifica que el texto principal no esté vacío
                if (!num.isEmpty()) {
                    // Si ya había una operación pendiente en el auxiliar pues elimino el operador anterior si existe
                    // Esto permite actualizar el signo si el usuario cambia de operador sin introducir un nuevo número
                    if (!numAux.isEmpty() && isOperator(lastLetter(numAux))) {
                        numAux = numAux.substring(0, numAux.length() - 1);
                    }

                    // Si el texto auxiliar está vacío significa que no había ninguna operación pendiente
                    if (numAux.isEmpty()) {
                        // Se concatena el número actual con el signo y se actualiza el texto auxiliar para que muestre la operación pendiente
                        textAuxResult.setText(num + " " + sign);
                    } else {
                        // Esta parte da fallo ya que intenta calcular lo que hay ya en el auxiliar y añadirle el signo para seguir operando pero no funciona
                        textAuxResult.setText(calculate(numAux + " " + num) + " " + sign);
                    }

                    // Limpia el texto principal para que el usuario introduzca otro número
                    textResult.setText("");
                }
            }
        });

        Button btnMinus = findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sign = btnMinus.getText().toString();
                String num = String.valueOf(textResult.getText()).trim();
                String numAux = String.valueOf(textAuxResult.getText()).trim();

                if (!num.isEmpty()) {
                    if (!numAux.isEmpty() && isOperator(lastLetter(numAux))) {
                        numAux = numAux.substring(0, numAux.length() - 1);
                    }

                    if (numAux.isEmpty()) {
                        textAuxResult.setText(num + " " + sign);
                    } else {
                        textAuxResult.setText(calculate(numAux + " " + num) + " " + sign);
                    }

                    textResult.setText("");
                }
            }
        });

        Button btnMultiplication = findViewById(R.id.btnMultiplication);
        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sign = btnMultiplication.getText().toString();
                String num = String.valueOf(textResult.getText()).trim();
                String numAux = String.valueOf(textAuxResult.getText()).trim();

                if (!num.isEmpty()) {
                    if (!numAux.isEmpty() && isOperator(lastLetter(numAux))) {
                        numAux = numAux.substring(0, numAux.length() - 1);
                    }

                    if (numAux.isEmpty()) {
                        textAuxResult.setText(num + " " + sign);
                    } else {
                        textAuxResult.setText(calculate(numAux + " " + num) + " " + sign);
                    }

                    textResult.setText("");
                }
            }
        });

        Button btnDivision = findViewById(R.id.btnDivision);
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sign = btnDivision.getText().toString();
                String num = String.valueOf(textResult.getText()).trim();
                String numAux = String.valueOf(textAuxResult.getText()).trim();

                if (!num.isEmpty()) {
                    if (!numAux.isEmpty() && isOperator(lastLetter(numAux))) {
                        numAux = numAux.substring(0, numAux.length() - 1);
                    }

                    if (numAux.isEmpty()) {
                        textAuxResult.setText(num + " " + sign);
                    } else {
                        textAuxResult.setText(calculate(numAux + " " + num) + " " + sign);
                    }

                    textResult.setText("");
                }
            }
        });

        // Inicializa el botón "=" y realiza el cálculo final
        Button btnEqual = findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = String.valueOf(textResult.getText()).trim();
                String numAux = String.valueOf(textAuxResult.getText()).trim();

                if (!numAux.isEmpty() && !num.isEmpty()) {
                    // Evalúa la expresión completa
                    String expression = numAux + " " + num;
                    String result = calculate(expression);

                    // Muestra el resultado final y limpia el auxiliar
                    textResult.setText(result);
                    textAuxResult.setText("");
                }
            }
        });
    }

    // Añade un número al resultado actual y maneja casos con coma, números negativos o 0
    private static String addNum(String num, String textResult) {
        if (num.equals(",")) {
            if (textResult.contains(",")) {
                return textResult;
            }

            if (textResult.isEmpty() || textResult.equals("0")) {
                return "0,";
            }
        }

        if (num.equals("0")) {
            if (textResult.equals("0")) {
                return textResult;
            }

            if (textResult.equals("-0")) {
                return textResult;
            }
        }

        if (textResult.equals("0")) {
            return num;
        }

        if (textResult.equals("-0") && !num.equals(",")) {
            return "-" + num;
        }

        return textResult.concat(num);
    }

    // Obtiene el último carácter de una cadena
    private static char lastLetter(String numAux) {
        if (numAux.isEmpty()) {
            return ' ';
        }

        return numAux.charAt(numAux.length() - 1);
    }

    // Método que hace un cálculo dividiendo el String que pasa por parámetros en 3 trozos
    private static String calculate(String numAux) {
        String[] parts = numAux.split(" ");

        if (parts.length < 3) {
            return "Error";
        }

        // Convierte las 2 partes con números que son String a números decimales remplazando si la hay la , por el .
        double num1 = Double.parseDouble(parts[0].replace(',', '.'));
        double num2 = Double.parseDouble(parts[2].replace(',', '.'));
        String operator = parts[1];

        // Realiza la operación dependiendo del operador
        switch (operator){
            case "+":
                return formatResult(num1 + num2);
            case "-":
                return formatResult(num1 - num2);
            case "X":
                return formatResult(num1 * num2);
            case "/":
                if (checkDivisionBy0(num2)){
                    return formatResult(num1 / num2);
                }else {
                    return "Error";
                }
            default:
                return "Error";
        }
    }

    // Da formato al resultado eliminando decimales innecesarios o cambiando el . por la , para mostrarse
    private static String formatResult(double result){
        if (result % 1 == 0) {
            return String.valueOf((int) result);
        }else {
            return String.valueOf(result).replace('.', ',');
        }
    }

    // Verifica si el divisor es 0 para evitar división por cero
    private static boolean checkDivisionBy0(double num2) {
        return num2 != 0;
    }

    // Verifica si un carácter es un operador (+, -, X, /)
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == 'X' || c == '/';
    }
}