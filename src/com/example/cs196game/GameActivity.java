package com.example.cs196game;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

public class GameActivity extends Activity {

	GameView gameView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		gameView = new GameView(this);
		gameView.setBackgroundColor(Color.WHITE);
		setContentView(R.layout.activity_game);
		setContentView(gameView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	/**
	 * The next two methods block the back button when you are in the game
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (Integer.valueOf(android.os.Build.VERSION.SDK) < 7 // Instead use
																// android.os.Build.VERSION.SDK_INT
																// <
																// android.os.Build.VERSION_CODES.ECLAIR
				&& keyCode == KeyEvent.KEYCODE_BACK
				&& event.getRepeatCount() == 0) {
			// Take care of calling this method on earlier versions of
			// the platform where it doesn't exist.
			onBackPressed();
		}

		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onBackPressed() {
		// This will be called either automatically for you on 2.0
		// or later, or by the code above on earlier versions of the
		// platform.
		return;
	}

	public void onPause() {
		// Add the small pop up menu here
		super.onPause();
	}

	public void onResume() {
		// Add the resume features here if any
		super.onResume();
	}
	
	public void jump(View v) {
		// Make the jump command here
	}
	
	public void menu(View v) {
		// Make the menu popup here
	}

	// Not sure if this is the right step
	private class myView extends View {
		public myView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
	}

}
