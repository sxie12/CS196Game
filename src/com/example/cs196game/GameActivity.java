package com.example.cs196game;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class GameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	public void onPause() {
		// Add the small pop up menu here
		super.onPause();
	}
	
	public void onResume() {
		// Add the resume features here if any
		super.onResume();
	}

	// Not sure if this is the right step
	private class myView extends View {
		public myView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
	}

}
