package com.gectaurus.calculatordam;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	
		
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    	final TextView bottomtext = (TextView) findViewById(R.id.textView1);

    	
    	bottomtext.setText("0");
    	
    	OnClickListener ocl = new OnClickListener() {
    		String number= "0";
			@Override
			public void onClick(View v) {
				Button b = (Button) v;
				String ac = bottomtext.getText().toString();
				char c = 0;
				switch(b.getId()){
					case R.id.button0:
						c = '0';
						break;
					case R.id.button1:
						c = '1';
						break;
					case R.id.button2:
						c = '2';
						break;
					case R.id.button3:
						c = '3';
						break;
					case R.id.button4:
						c = '4';
						break;
					case R.id.button5:
						c = '5';
						break;
					case R.id.button6:
						c = '6';
						break;
					case R.id.button7:
						c = '7';
						break;
					case R.id.button8:
						c = '8';
						break;
					case R.id.button9:
						c = '9';
						break;
					case R.id.buttonDot:
						c = '.';
						break;
					case R.id.buttonDel:
						if (ac.length()==1) {
							ac = "0";
							number = "0";
						} else {
							ac = ac.substring(0, ac.length()-1);
							if (number.length()==1) {
								number = "";
							}else if (number.length() == 0) {
								if (endsWithNumber(ac)) {
									for(int i = ac.length()-1; i>=0; i--){
										char ch = ac.charAt(i);
										if ( (ch>='0' && ch<='9') 
												|| ch=='.' 
												|| (ch=='-' && i ==0)) {
											number = ch + number;
										}
									}
								}
							} else {
								number = number.substring(0, number.length()-1);
							}
						}
						break;
					case R.id.buttonClear:
						ac = "0";
						number="0";
						break;
					case R.id.buttonAdd:
						c='+';
						break;
					case R.id.buttonSubtract:
						c='-';
						break;
					case R.id.buttonMultiply:
						c='x';
						break;
					case R.id.buttonDivide:
						c = '/';
						break;
					case R.id.buttonEquals:
						if (endsWithNumber(ac)) {
							try {
								ac = String.valueOf(Calculator.calculate(ac).doubleValue());
								number = ac;
							} catch(Exception e) {
								AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
								a.setTitle("Error");
								a.setMessage("Incorrect Expression");
								a.setPositiveButton("OK", null);
								a.show();
							}
						}
						break;
				}
				
				if (c!=0) {
					if (c=='0'){
						if (!number.equals("0")) {
							number += c;
							ac += c;
						}
					}else if (c>='1' && c<='9') {
						if (number.equals("0")) {
							ac = number = String.valueOf(c);
						} else {
							number += c;
							ac += c;
						}
					} else if(c == '.') {
						if (number.isEmpty()) {
							number = "0.";
							ac += "0.";
						} else if(!number.contains(".")) {
							number += c;
							ac += c;
						}
					} else if (c == '-' && ac.equals("0")){
						ac="-";
						number="-";
					} else if (c=='-' && number.isEmpty() && !(ac.endsWith("+") || ac.endsWith("-"))){
						ac+="-";
						number="-";
					}else {
						if (!endsWithNumber(ac)) {
							ac = ac.substring(0, ac.length()-1) + c;
						} else if (!ac.endsWith(String.valueOf(c))){
							ac += c;
						}
						number = "";
					}
				}
				
				bottomtext.setText(ac);
				
			}
    	};
    	
    	ViewGroup root = (ViewGroup) findViewById(R.id.Root);
    	
    	addListeners(root, ocl);
    }

    static boolean endsWithNumber(String s) {
    	if (s.isEmpty()) return false;
    	String last = s.substring(s.length()-1);
    	return Character.isDigit(last.charAt(0)) || last.equals(".");
    }

    
   

    private void addListeners(ViewGroup v, OnClickListener ocl) {
    	for (int i = 0; i < v.getChildCount(); i++) {
    		View b = v.getChildAt(i);
    		if (b instanceof ViewGroup) {
    			addListeners((ViewGroup) b, ocl);
    		} else if(b instanceof Button) {
    			((Button) b).setOnClickListener(ocl);
    		}
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }   
    
}
