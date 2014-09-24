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
	
		
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText toptext = (EditText) findViewById(R.id.editText1);
    	final EditText bottomtext = (EditText) findViewById(R.id.EditText01);

    	final Button button0 = (Button) findViewById(R.id.Button02);
    	final Button button1 = (Button) findViewById(R.id.button11);
    	final Button button2 = (Button) findViewById(R.id.button10);
    	final Button button3 = (Button) findViewById(R.id.button9);
    	final Button button4 = (Button) findViewById(R.id.button7);
    	final Button button5 = (Button) findViewById(R.id.button6);
    	final Button button6 = (Button) findViewById(R.id.button5);
    	final Button button7 = (Button) findViewById(R.id.button1);
    	final Button button8 = (Button) findViewById(R.id.button2);
    	final Button button9 = (Button) findViewById(R.id.button3);
    	final Button buttondot = (Button) findViewById(R.id.Button01);
    	final Button buttondel = (Button) findViewById(R.id.Button03);
    	final Button buttonadd = (Button) findViewById(R.id.Button04);
    	final Button buttonsubtract = (Button) findViewById(R.id.button12);
    	final Button buttonmultiply = (Button) findViewById(R.id.button8);
    	final Button buttondivide = (Button) findViewById(R.id.button4);
    	final Button buttonequal = (Button) findViewById(R.id.button13);
        
        button0.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bottomtext.setText(bottomtext.getText() + "0");	
			}
		});
        button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bottomtext.setText(bottomtext.getText() + "1");	
			}
		});
        button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bottomtext.setText(bottomtext.getText() + "2");	
			}
		});
        button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bottomtext.setText(bottomtext.getText() + "3");	
			}
		});
        button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bottomtext.setText(bottomtext.getText() + "4");	
			}
		});
        button5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bottomtext.setText(bottomtext.getText() + "5");	
			}
		});
        button6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bottomtext.setText(bottomtext.getText() + "6");	
			}
		});
        button7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bottomtext.setText(bottomtext.getText() + "7");	
			}
		});
        button8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bottomtext.setText(bottomtext.getText() + "8");	
			}
		});
        button9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bottomtext.setText(bottomtext.getText() + "9");	
			}
		});
        buttondot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bottomtext.setText(bottomtext.getText() + ",");	
			}
		});
        buttondel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int length = bottomtext.getText().length();
				if (length > 0) {
				    bottomtext.getText().delete(length - 1, length);
				}					
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
