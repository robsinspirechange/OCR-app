package com.datumdroid.android.ocr.simple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class CalculationResult extends Activity {
	private static final String DEBUG_TAG = "My OCR";
	String expression;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(DEBUG_TAG, "Entered Calculation");

		Intent intent = getIntent();
		expression=intent.getStringExtra(SimpleAndroidOCRActivity.EXPRESSION);
		setContentView(R.layout.activity_calulation);
		printResult();
		
		
	}

	

	private void printResult() {
		// TODO Auto-generated method stub
		String result=""+EvaluateString.evaluate(expression);
		TextView textView=(TextView) findViewById(R.id.textViewResult);
		textView.setText(result);
		Log.d(DEBUG_TAG, "Result :" + result);

		
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manual_search, menu);
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
