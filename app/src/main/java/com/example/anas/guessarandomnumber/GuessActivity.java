package com.example.anas.guessarandomnumber;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class GuessActivity extends Activity {
    Random rand=new Random();
    private int value=rand.nextInt(1001);
    private Button go,again;
    private EditText enter;
    private void checkvalue(int enteredvalue){
        if(enteredvalue==value){
            Toast.makeText(this,R.string.correct,Toast.LENGTH_SHORT).show();
            again.setVisibility(View.VISIBLE);
        }
        else{
            if(enteredvalue>value)
                Toast.makeText(this,R.string.grater,Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this,R.string.smaller,Toast.LENGTH_SHORT).show();
            if(Math.abs(value-enteredvalue)<=5)
                Toast.makeText(this,R.string.close,Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        go=(Button)findViewById(R.id.go);
        again=(Button)findViewById(R.id.again);
        enter=(EditText)findViewById(R.id.editText);
        go.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int entered=Integer.parseInt(enter.getText().toString());
                checkvalue(entered);
            }
        });
        again.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                again.setVisibility(View.INVISIBLE);
                value=rand.nextInt(1001);
            }
        });
    }
}
