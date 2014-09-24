package com.gectaurus.calculatordam;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
	
	EditText toptext = (EditText) findViewById(R.id.editText1);
	EditText bottomtext = (EditText) findViewById(R.id.EditText01);

	Button button0 = (Button) findViewById(R.id.Button02);
	Button button1 = (Button) findViewById(R.id.button11);
	Button button2 = (Button) findViewById(R.id.button10);
	Button button3 = (Button) findViewById(R.id.button9);
	Button button4 = (Button) findViewById(R.id.button7);
	Button button5 = (Button) findViewById(R.id.button6);
	Button button6 = (Button) findViewById(R.id.button5);
	Button button7 = (Button) findViewById(R.id.button1);
	Button button8 = (Button) findViewById(R.id.button2);
	Button button9 = (Button) findViewById(R.id.button3);
	Button buttondot = (Button) findViewById(R.id.Button01);
	Button buttondel = (Button) findViewById(R.id.Button03);
	Button buttonadd = (Button) findViewById(R.id.Button04);
	Button buttonsubtract = (Button) findViewById(R.id.button12);
	Button buttonmultiply = (Button) findViewById(R.id.button8);
	Button buttondivide = (Button) findViewById(R.id.button4);
	Button buttonequal = (Button) findViewById(R.id.button13);	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button0.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bottomtext.setText("0");	
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
