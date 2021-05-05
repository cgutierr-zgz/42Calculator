package es.cgutierr.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // We declare the Views and everything we'll end up needing
    private TextView tvResult, tvPreviousResult;
    private String result, previousResult;
    private Character operator;
    private ImageView bu42;
    private int counter = 0;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the Views
        context = this;
        tvResult = findViewById(R.id.tvResult);
        tvPreviousResult = findViewById(R.id.tvPreviousResult);
        bu42 = findViewById(R.id.bu42);

        bu42.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        counter++;
                        if(counter == 42)
                        {
                            Toast.makeText(context, "Te quiero Santana", Toast.LENGTH_SHORT).show();
                            Log.d("42", "Te quiero Santana");
                            counter = 0;
                        }
                        Log.d("42", "Counter = " + counter);
                    }
                }
        );
    }

    // We change the main TextViews/results strings
    public void setValue(View v) {
        result = "0";
        if (v.getId() == R.id.buC) {
            result = "0";
        }
        if (!tvResult.getText().toString().contains(".") && Integer.parseInt(tvResult.getText().toString()) == 0) {
            tvResult.setText("");
        }
        if (v.getId() == R.id.buPlusMinus && !tvResult.getText().toString().equals("")) {
            if (tvResult.getText().toString().contains("-")) {
                result = tvResult.getText().toString().substring(1);
            } else {
                result = "-" + tvResult.getText().toString();
            }
        }
        if (v.getId() == R.id.bu0) {
            result = tvResult.getText().toString() + "0";
        }
        if (v.getId() == R.id.bu1) {
            result = tvResult.getText().toString() + "1";
        }
        if (v.getId() == R.id.bu2) {
            result = tvResult.getText().toString() + "2";
        }
        if (v.getId() == R.id.bu3) {
            result = tvResult.getText().toString() + "3";
        }
        if (v.getId() == R.id.bu4) {
            result = tvResult.getText().toString() + "4";
        }
        if (v.getId() == R.id.bu5) {
            result = tvResult.getText().toString() + "5";
        }
        if (v.getId() == R.id.bu6) {
            result = tvResult.getText().toString() + "6";
        }
        if (v.getId() == R.id.bu7) {
            result = tvResult.getText().toString() + "7";
        }
        if (v.getId() == R.id.bu8) {
            result = tvResult.getText().toString() + "8";
        }
        if (v.getId() == R.id.bu9) {
            result = tvResult.getText().toString() + "9";
        }
        if (v.getId() == R.id.buDot && !tvResult.getText().toString().contains(".")) {
            if (tvResult.getText().toString().equals("")) {
                tvResult.setText("0");
            }
            result = tvResult.getText().toString() + ".";
        }
        if (v.getId() == R.id.buPercentage) {
            float resultOperation;
            if (tvResult.getText().toString().equals("")) {
                tvResult.setText("0");
            }
            resultOperation = Float.parseFloat(tvResult.getText().toString()) / 100;
            result = "" + resultOperation;
        }
        tvResult.setText(result);
        Log.d("SetValue:", result);
    }

    // Store the different operands
    public void makeOperations(View v) {
        previousResult = tvResult.getText().toString();
        tvPreviousResult.setText(previousResult);
        tvResult.setText("0");
        if (v.getId() == R.id.buDivide) {
            operator = '/';
        }
        if (v.getId() == R.id.buMultiply) {
            operator = '*';
        }
        if (v.getId() == R.id.buPlus) {
            operator = '+';
        }
        if (v.getId() == R.id.buMinus) {
            operator = '-';
        }
        Log.d("Operations:", "Selected operator = " + operator);
    }

    // Pretty self explanatory
    public void calculateResult(View v) {
        if (previousResult == null) {
            Toast.makeText(context, "You need two values to make an operation", Toast.LENGTH_SHORT).show();
            Log.d("Result:", "Previous result is null");
            return;
        }
        if (result.contains(".") || previousResult.contains(".")) {
            float second = Float.parseFloat(result);
            float first = Float.parseFloat(previousResult);
            float resultOperation = 0;

            if(second != 0 && first != 0)
            {
                if (operator == '/') {
                    resultOperation = (first) / (second);
                }
                if (operator == '*') {
                    resultOperation = (first) * (second);
                }
                if (operator == '+') {
                    resultOperation = (first) + (second);
                }
                if (operator == '-') {
                    resultOperation = (first) - (second);
                }
            }
            Log.d("Result:", first + " " + operator + " " + second + " = " + resultOperation);
            result = "" + resultOperation;
            previousResult = null;
            tvPreviousResult.setText("");
            tvResult.setText(result);
        } else {
            int second = Integer.parseInt(result);
            int first = Integer.parseInt(previousResult);
            int resultOperation = 0;

            if(second != 0 && first != 0)
            {
                if (operator == '/') {
                    resultOperation = (first) / (second);
                }
                if (operator == '*') {
                    resultOperation = (first) * (second);
                }
                if (operator == '+') {
                    resultOperation = (first) + (second);
                }
                if (operator == '-') {
                    resultOperation = (first) - (second);
                }
            }
            Log.d("Result:", first + " " + operator + " " + second + " = " + resultOperation);
            result = "" + resultOperation;
            previousResult = null;
            tvPreviousResult.setText("");
            tvResult.setText(result);
        }
    }
}
