package com.example.cs196game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Toast is similar to System.out.println();
	// Enable USB Debugging in Developer Options to run app on Android device

	public void startGame(View v) {
		// Write the startGame button here
		startActivity(new Intent(this, GameActivity.class));
	}

	public void highScores(View v) {
		// Write the highScores button here
		startActivity(new Intent(this, HighScoreList.class));
	}

	public void settings(View v) {
		// Write the settings button here
		startActivity(new Intent(this, Settings.class));
	}

	public void credits(View v) {
		// Write the credits button here
		startActivity(new Intent(this, Credits.class));
	}

}
