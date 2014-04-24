package com.example.cs196game;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class GameChoice extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_choice);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_choice, menu);
		return true;
	}

	public void startGame(View v) {
		// Write the startGame button here

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				this);

		// set title
		alertDialogBuilder.setTitle("Are you sure?");

		// set dialog message
		alertDialogBuilder
				.setMessage(
						"Starting a new game erases your old saved game. Press yes to proceed")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// if this button is clicked, close
								// current activity
								launchNewGame();
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						dialog.cancel();
					}
				});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}

	public void resumeGame(View v) {
		// Write the startGame button here
		// startActivity(new Intent(this, <insert resume game class
		// here>.class));
	}
	
	public void launchNewGame() {
		startActivity(new Intent(this, GameActivity.class));
	}

}
