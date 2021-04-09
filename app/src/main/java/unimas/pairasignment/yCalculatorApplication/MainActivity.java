package unimas.pairasignment.yCalculatorApplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText input;
    boolean isNewOp =true;
    String Op= "+";
    String oldNumber="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
    }

/*let the button know their function
* numberEvent= function to insert number in the editText
* while operatorEvent = allow buttons to operates its function to add, subtract,multiply,or divide
* equalEvent = allow the equal button solve all types of calculations.
* clearEvent = allow button to clear any Value in the EditText area.  */
    public void numberEvent(View view) {
        if (isNewOp)
            input.setText("");
        isNewOp = false;
        String number = input.getText().toString();
        switch (view.getId()) {
            case R.id.oneBTN:
                number += "1";
                break;
            case R.id.twoBTN:
                number += "2";
                break;
            case R.id.threeBTN:
                number += "3";
                break;
            case R.id.fourBTN:
                number += "4";
                break;
            case R.id.fiveBTN:
                number += "5";
                break;
            case R.id.sixBTN:
                number += "6";
                break;
            case R.id.sevenBTN:
                number += "7";
                break;
            case R.id.eightBTN:
                number += "8";
                break;
            case R.id.nineBTN:
                number += "9";
                break;
            case R.id.zeroBTN:
                number += "0";
                break;
            case R.id.pointBTN:
                number += ".";
                break;
        }
        input.setText(number);
    }


    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = input.getText().toString();
        switch (view.getId()) {
            case R.id.addBTN:
                Op = "+";
                break;
            case R.id.subtractBTN:
                Op = "-";
                break;
            case R.id.multiplyBTN:
                Op = "*";
                break;
            case R.id.divideBTN:
                Op = "/";
                break;
        }
    }

    public void equalEvent (View view) {
        String newNumber = input.getText().toString();
        double result = 0.0;
        switch (Op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        input.setText(result+"");
    }

    public void clearEvent (View view) {
        input.setText ("0");
        isNewOp = true;
    }
}