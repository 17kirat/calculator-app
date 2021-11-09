package com.jaskirat.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText Display;
    String op = "+";
    boolean new_op =true;
    String old_number="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display = findViewById(R.id.input);


    }
    @SuppressLint("NonConstantResourceId")
    public void numberEvent(View view){

        if(new_op)
            Display.setText("");
        new_op = false;
        String number = Display.getText().toString();
        switch(view.getId()){
            case R.id.ZeroBtn:
                number +="0"; break;
            case R.id.OneBtn:
                number+="1"; break;
            case R.id.TwoBtn:
                number+="2"; break;
            case R.id.ThreeBtn:
                number+="3"; break;
            case R.id.fourBtn:
                number+="4"; break;
            case R.id.FiveBtn:
                number+="5"; break;
            case R.id.SixBtn:
                number+="6"; break;
            case R.id.SevenBtn:
                number+="7"; break;
            case R.id.EightBtn:
                number+="8"; break;
            case R.id.NineBtn:
                number+="9"; break;
            case R.id.DecimalBtn:
                number+="."; break;

            case R.id.plusMinusBtn:
                number = "-"+number;
                break;



        }
        Display.setText(number);
    }

    @SuppressLint("NonConstantResourceId")
    public void operatorEvent(View view) {
        new_op=true;
        old_number =Display.getText().toString();
        switch (view.getId()){
            case R.id.AddBtn:op ="+" ;break;
            case R.id.SubtractBtn:op ="-" ;break;
            case R.id.MultiplyBtn:op ="*" ;break;
            case R.id.DivisionBtn:op ="/" ;break;
            case R.id.SquareRootBtn:op ="√" ;break;

        }
    }

    @SuppressLint("SetTextI18n")
    public void EqualBtn(View view) {
        String newNum=Display.getText().toString();
        double result =0.0;
        switch(op){
            case"+":
                result =Double.parseDouble(old_number) + Double.parseDouble(newNum);break;
            case"-":
                result =Double.parseDouble(old_number) - Double.parseDouble(newNum);break;
            case"*":
                result =Double.parseDouble(old_number) * Double.parseDouble(newNum);break;
            case"/":
                result =Double.parseDouble(old_number) / Double.parseDouble(newNum);break;


        }
        Display.setText(result+"");
    }

    public void ClearBtn(View view) {
        Display.setText("0");
        new_op=true;

    }

    @SuppressLint("SetTextI18n")
    public void PercentBtn(View view) {
        double num =Double.parseDouble(Display.getText().toString())/100;
        Display.setText (num +"");
        new_op=true;
    }

    public void BackspaceBtn(View view) {
        String str = Display.getText().toString();
        if(str.length()==0)
            return;
        str = str.substring(0,str.length()-1);
        Display.setText(str);

    }


    public void squareRootBtn(View view) {
        String val = Display.getText().toString();
        double sq = Math.sqrt(Double.parseDouble(val));
        Display.setText(String.valueOf(sq));
        new_op=true;
    }

    public void cubeRootBtn(View view) {
        String v = Display.getText().toString();
        double cube = Math.cbrt(Double.parseDouble(v));
        Display.setText(String.valueOf(cube));
        new_op=true;

    }


}