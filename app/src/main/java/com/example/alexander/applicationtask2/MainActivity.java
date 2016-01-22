package com.example.alexander.applicationtask2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
FloatingActionButton fab;
EditText editText_income;
EditText editText_outcome;
TextView textView_balance;
TextView textView_val;
Button btn_1;
Button btn_2;
Button btn_3;
Button btn_4;
Button btn_5;
Button btn_6;
Button btn_7;
Button btn_8;
Button btn_9;
Button btn_0;
Button btn_clr;
Button btn_d;
String evaluate;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton)findViewById(R.id.fab);

        editText_income = (EditText)findViewById(R.id.editText_income);
        editText_outcome = (EditText)findViewById(R.id.editText_outcome);

        textView_balance = (TextView)findViewById(R.id.textView_balance);
        textView_val = (TextView)findViewById(R.id.textView_val);

        btn_0 = (Button)findViewById(R.id.zero);
        btn_1 = (Button)findViewById(R.id.one);
        btn_2 = (Button)findViewById(R.id.two);
        btn_3 = (Button)findViewById(R.id.three);
        btn_4 = (Button)findViewById(R.id.four);
        btn_5 = (Button)findViewById(R.id.five);
        btn_6 = (Button)findViewById(R.id.btn_six);
        btn_7 = (Button)findViewById(R.id.seven);
        btn_8 = (Button)findViewById(R.id.eight);
        btn_9 = (Button)findViewById(R.id.nine);
        btn_clr=(Button)findViewById(R.id.clear);
        btn_d=(Button)findViewById(R.id.delete);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_clr.setOnClickListener(this);
        btn_d.setOnClickListener(this);



        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double hasilVal = (Double.parseDouble(String.valueOf(editText_income.getText())) - Double.parseDouble(String.valueOf(editText_outcome.getText())));
textView_val.setText(String.valueOf(hasilVal));
            }
        });
    }
public void set_value_to_input(final String number){
    Toast.makeText(MainActivity.this, number, Toast.LENGTH_SHORT).show();
    editText_income.setOnTouchListener(new View.OnTouchListener() {
        public boolean onTouch(View arg0, MotionEvent arg1) {

            evaluate="1";

return true;

        }
    });

    editText_outcome.setOnTouchListener(new View.OnTouchListener()
    {
        public boolean onTouch(View arg0, MotionEvent arg1)
        {

            evaluate="2";

            return true;
        }
    });
    if(evaluate=="1")
    {
        editText_income.append(number);
    }
    if(evaluate=="2")
    {
        editText_outcome.append(number);
    }
}

    public void backspace(){
        editText_income.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                evaluate="1";

                return false;
            }
        });

        editText_outcome.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View arg0, MotionEvent arg1)
            {

                evaluate="2";
                return false;
            }
        });
        if(evaluate=="1")
        {
            String str=editText_income.getText().toString();
            if (str.length() >=1 ) {
                str = str.substring(0, str.length() - 1);
                editText_income.setText(str);
            };
            if (str.length() <1 ) {
                editText_income.setText("0");
            }
        }
        if(evaluate=="2")
        {
            String str=editText_outcome.getText().toString();
            if (str.length() >=1 ) {

                str = str.substring(0, str.length() - 1);
                editText_outcome.setText(str);
            };
            if (str.length() <1 ) {
                editText_outcome.setText("0");
            }
        }
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

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.zero:
        this.set_value_to_input("0");
        break;
    case R.id.one:
        this.set_value_to_input("1");
        break;
    case R.id.two:
        this.set_value_to_input("2");
        break;
    case R.id.three:
        this.set_value_to_input("3");
        break;
    case R.id.four:
        this.set_value_to_input("4");
        break;
    case R.id.five:
        this.set_value_to_input("5");
        break;
    case R.id.btn_six:
        this.set_value_to_input("6");
        break;
    case R.id.seven:
        this.set_value_to_input("7");
        break;
    case R.id.eight:
        this.set_value_to_input("8");
        break;
    case R.id.nine:
        this.set_value_to_input("9");
        break;
    case R.id.clear:
        editText_income.setText("");
        editText_outcome.setText("");
        textView_val.setText("");
        break;
    case R.id.delete:
       this.backspace();
        break;



}
    }
}
