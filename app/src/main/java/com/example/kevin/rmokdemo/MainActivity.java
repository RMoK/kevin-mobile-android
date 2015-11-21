package com.example.kevin.rmokdemo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.edit_text);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void changeText(View view) {
        try {
            relativeLayout.setBackgroundColor(Color.parseColor(editText.getText().toString()));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            Toast.makeText(this, "This is not a color!!", Toast.LENGTH_LONG).show();
        }
    }

    public void toCalculator(View view) {
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }

    public void toImages(View view) {
        Intent i = new Intent(this, ImagesActivity.class);
        startActivity(i);
    }
}
