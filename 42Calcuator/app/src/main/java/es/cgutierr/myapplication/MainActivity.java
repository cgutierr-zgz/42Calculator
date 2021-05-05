package es.cgutierr.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // We declare the Views, vars, and everything we'll end up needing
    private Button bu0, bu1, bu2, bu3, bu4, bu5, bu6, bu7, bu8, bu9;
    private Button buC, buPlusMinus, buPercentage, buDivide, buMultiply, buMinus, buPlus, buEquals, buDot;
    private TextView tvResult, tvPreviousResult;

    private String result;
    private String previousResult;

    private Character operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // We assign Views, vars, etc...
        tvResult = findViewById(R.id.tvResult);
        tvPreviousResult = findViewById(R.id.tvPreviousResult);
        bu0 = findViewById(R.id.bu0);
        bu1 = findViewById(R.id.bu1);
        bu2 = findViewById(R.id.bu2);
        bu3 = findViewById(R.id.bu3);
        bu4 = findViewById(R.id.bu4);
        bu5 = findViewById(R.id.bu5);
        bu6 = findViewById(R.id.bu6);
        bu7 = findViewById(R.id.bu7);
        bu8 = findViewById(R.id.bu8);
        bu9 = findViewById(R.id.bu9);
        buC = findViewById(R.id.buC);
        buPlusMinus = findViewById(R.id.buPlusMinus);
        buPercentage = findViewById(R.id.buPercentage);
        buDivide = findViewById(R.id.buDivide);
        buMultiply = findViewById(R.id.buMultiply);
        buMinus = findViewById(R.id.buMinus);
        buPlus = findViewById(R.id.buPlus);
        buEquals = findViewById(R.id.buEquals);
        buDot = findViewById(R.id.buDot);
    }

    public void setValue(View v)
    {
        result = "0";
        if(v.getId() == R.id.buC)
        {
            result = "0";
        }
        // TODO: Check this with 0's . and % and +/-

        // Handle 0 equals
        if(!tvResult.getText().toString().contains(".") && Integer.parseInt(tvResult.getText().toString()) == 0)
        {
            tvResult.setText("");
        }

        if(v.getId() == R.id.buPlusMinus && !tvResult.getText().toString().equals(""))
        {
            if(tvResult.getText().toString().contains("-"))
                result = tvResult.getText().toString().substring(1);
            else
                result = "-" + tvResult.getText().toString();
        }
        if(v.getId() == R.id.bu0)
        {
            result = tvResult.getText().toString() + "0";
        }
        if(v.getId() == R.id.bu1)
        {
            result = tvResult.getText().toString() + "1";
        }
        if(v.getId() == R.id.bu2)
        {
            result = tvResult.getText().toString() + "2";
        }
        if(v.getId() == R.id.bu3)
        {
            result = tvResult.getText().toString() + "3";
        }
        if(v.getId() == R.id.bu4)
        {
            result = tvResult.getText().toString() + "4";
        }
        if(v.getId() == R.id.bu5)
        {
            result = tvResult.getText().toString() + "5";
        }
        if(v.getId() == R.id.bu6)
        {
            result = tvResult.getText().toString() + "6";
        }
        if(v.getId() == R.id.bu7)
        {
            result = tvResult.getText().toString() + "7";
        }
        if(v.getId() == R.id.bu8)
        {
            result = tvResult.getText().toString() + "8";
        }
        if(v.getId() == R.id.bu9)
        {
            result = tvResult.getText().toString() + "9";
        }
        if(v.getId() == R.id.buDot && !tvResult.getText().toString().contains("."))
        {
            if(tvResult.getText().toString().equals(""))
                tvResult.setText("0");
            result = tvResult.getText().toString() + ".";
        }
        if(v.getId() == R.id.buPercentage)
        {
            float resultOperation;
            if(tvResult.getText().toString().equals(""))
                tvResult.setText("0");
            resultOperation = Float.parseFloat(tvResult.getText().toString()) / 100;
            result = "" + resultOperation;
        }
        tvResult.setText(result);
        Log.d("SetValue:", result);
    }

    public void makeOperations(View v)
    {
        previousResult = tvResult.getText().toString();
        tvPreviousResult.setText(previousResult);
        tvResult.setText("0");
        if(v.getId() == R.id.buDivide)
        {
            operator = '/';
        }
        if(v.getId() == R.id.buMultiply)
        {
            operator = '*';
        }
        if(v.getId() == R.id.buPlus)
        {
            operator = '+';
        }
        if(v.getId() == R.id.buMinus)
        {
            operator = '-';
        }
        Log.d("Operations:", "Selected operator = " + operator);
    }

    public void calculateResult(View v)
    {
        if(previousResult == null)
        {
            Toast.makeText(this, "You need two values to make an operation", Toast.LENGTH_SHORT).show();
            Log.d("Result:", "Previous result is null");
            return;
        }
        if(result.contains(".") || previousResult.contains("."))
        {
            float second = Float.parseFloat(result);
            float first = Float.parseFloat(previousResult);
            float resultOperation = 0;

            if(operator == '/')
            {
                resultOperation = (first) / (second);
            }
            if(operator == '*')
            {
                resultOperation = (first) * (second);
            }
            if(operator == '+')
            {
                resultOperation = (first) + (second);
            }
            if(operator == '-')
            {
                resultOperation = (first) - (second);
            }
            Log.d("Result:", first + " " + operator+ " " + second + " = " + resultOperation);
            result = "" + resultOperation;
            previousResult = null;
            tvPreviousResult.setText("");
            tvResult.setText(result);
        }
        else
        {
            int second = Integer.parseInt(result);
            int first = Integer.parseInt(previousResult);
            int resultOperation = 0;

            if(operator == '/')
            {
                resultOperation = (first) / (second);
            }
            if(operator == '*')
            {
                resultOperation = (first) * (second);
            }
            if(operator == '+')
            {
                resultOperation = (first) + (second);
            }
            if(operator == '-')
            {
                resultOperation = (first) - (second);
            }
            Log.d("Result:", first + " " + operator+ " " + second + " = " + resultOperation);
            result = "" + resultOperation;
            previousResult = null;
            tvPreviousResult.setText("");
            tvResult.setText(result);
        }
    }

}
