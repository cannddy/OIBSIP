package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    float n1,n2,n;
    boolean add,sub,mul,div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating objects for buttons
        Button b1=findViewById(R.id.b1);
        Button b2=findViewById(R.id.b2);
        Button b3=findViewById(R.id.b3);
        Button b4=findViewById(R.id.b4);
        Button b5=findViewById(R.id.b5);
        Button b6=findViewById(R.id.b6);
        Button b7=findViewById(R.id.b7);
        Button b8=findViewById(R.id.b8);
        Button b9=findViewById(R.id.b9);
        Button b0=findViewById(R.id.b0);
        Button badd=findViewById(R.id.badd);
        Button bsub=findViewById(R.id.bsub);
        Button bmul=findViewById(R.id.bmul);
        Button bdiv=findViewById(R.id.bdiv);
        Button beq=findViewById(R.id.bequals);
        Button bdot=findViewById(R.id.bdot);
        Button bc=findViewById(R.id.bc);
        Button bac=findViewById(R.id.bac);

        //create object for edit text
        EditText et=findViewById(R.id.et1);

        //Onclick for buttons

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(et.getText()+"0");
            }
        });
        bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText("");
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText("");
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et.setText(".");
            }
        });
        //logics for basic operations

        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1=Float.parseFloat(et.getText().toString());
                et.setText("");
                add=true;

            }
        });
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1=Float.parseFloat(et.getText().toString());
                et.setText("");
                sub=true;

            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1=Float.parseFloat(et.getText().toString());
                et.setText("");
                mul=true;

            }
        });

        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1=Float.parseFloat(et.getText().toString());
                et.setText("");
                div=true;

            }
        });

        //logic for =

        beq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(add==true){
                    n2=Float.parseFloat(et.getText().toString());
                    n=n1+n2;           //result will be in number
                    String con=String.valueOf(n);
                    et.setText(con);
                    add=false;

                } else if (sub==true) {
                    n2=Float.parseFloat(et.getText().toString());
                    n=n1-n2;           //result will be in number
                    String con=String.valueOf(n);
                    et.setText(con);
                    sub=false;
                } else if (mul==true) {
                    n2=Float.parseFloat(et.getText().toString());
                    n=n1*n2;           //result will be in number
                    String con=String.valueOf(n);
                    et.setText(con);
                    mul=false;
                } else if (div==true) {
                    n2=Float.parseFloat(et.getText().toString());
                    n=n1/n2;           //result will be in number
                    String con=String.valueOf(n);
                    et.setText(con);
                    div=false;
                }
            }
        });



    }

}