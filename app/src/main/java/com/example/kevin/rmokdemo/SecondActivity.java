package com.example.kevin.rmokdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Map;

public class SecondActivity extends AppCompatActivity {

    private String firstNumber = "";
    private String secondNumber = "";
    private boolean operatorClicked = false;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getNumber(View view) {
        Button button = (Button) view;

        if (operatorClicked == true) {
            secondNumber = secondNumber + button.getText();
        } else {
            firstNumber = firstNumber + button.getText();
        }
        Log.i("calc", "number clicked " + button.getText());
        Log.i("calc", "first number is " + firstNumber);
        Log.i("calc", "second number is " + secondNumber);
    }

    public void equals(View view) {
        int first = Integer.parseInt(firstNumber);
        int second = Integer.parseInt(secondNumber);
        if (operator.equals("x")) {
            Toast.makeText(this, "" + (first * second), Toast.LENGTH_LONG).show();
        } else if (operator.equals("/")) {
            if (second == 0) {
                Toast.makeText(this, "you can't divide by zero", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "" + (first / second), Toast.LENGTH_LONG).show();
            }

        } else if (operator.equals("+")){
            Toast.makeText(this, "" + (first + second), Toast.LENGTH_LONG).show();
        } else if (operator.equals("-")){
            Toast.makeText(this, "" + (first - second), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Oops", Toast.LENGTH_LONG).show();
        }
        firstNumber = "";
        secondNumber = "";
        operatorClicked = false;
    }

    public void operatorClicked(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        operatorClicked = true;
    }
}
