package dk.easj.anbo.calculatorarithmetic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateButtonClicked(View view) {
        EditText number1Field = findViewById(R.id.mainNumber1EditText);
        EditText number2Field = findViewById(R.id.mainNumber2EditText);
        String number1Str = number1Field.getText().toString();
        String number2Str = number2Field.getText().toString();
        TextView messageField = findViewById(R.id.mainMessageTextView);
        messageField.setText("");
        Spinner spinner = findViewById(R.id.mainOperationSpinner);
        String selectedOperation = (String) spinner.getSelectedItem();
        try {
            Double number1 = Double.parseDouble(number1Str);
            Double number2 = Double.parseDouble(number2Str);
            //double result = number1 + number2;
            double result = 0;
            switch (selectedOperation) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
            }
            Log.d("MINE", "Result " + result);
            EditText resultField = findViewById(R.id.mainResultEditText);
            resultField.setText(Double.toString(result));
        } catch (NumberFormatException ex) {
            messageField.setText("Not a number");
        }
    }
}
