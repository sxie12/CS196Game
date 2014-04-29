package com.example.cs196game;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends Activity {

	SurfaceView gameView;
	SurfaceHolder holder;
	Thread thread;
	HighScoreList highScoreList;
	Boolean gameRun = true;
	int jump;
	int score;
	String name;
	SharedPreferences pref;
	Editor editor;
	TextView thisScore;
	TextView thisDiff;
	long start, end;
	Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		pref = getApplicationContext().getSharedPreferences("MyPrefs",
				MODE_PRIVATE);
		editor = pref.edit();
		thisScore = (TextView) findViewById(R.id.textView4);
		thisDiff = (TextView) findViewById(R.id.textView3);
		handler = new Handler();

		gameView = (SurfaceView) findViewById(R.id.surfaceView1);

		holder = gameView.getHolder();

		start = System.currentTimeMillis();

		thread = new Thread(new Runnable() {
			public void run() {
				while (gameRun) { //
					if (!holder.getSurface().isValid()) {
						continue;
					}
					jump = 0;
					Canvas canvas = holder.lockCanvas();
					Paint paint = new Paint();
					paint.setColor(Color.BLUE);
					paint.setStrokeWidth(5);
					canvas.drawRect(100, 350 - jump / 2, 160, 410 - jump / 2,
							paint);
					paint.setColor(Color.BLACK);
					canvas.drawRect(100, 380 - jump / 2, 160, 410 - jump / 2,
							paint);
					paint.setColor(Color.BLUE);
					canvas.drawRect(100, 350 - jump, 160, 410 - jump, paint);

					holder.unlockCanvasAndPost(canvas);
					handler.post(new Runnable() {
						public void run() {
							score = (int) (System.currentTimeMillis() - start) / 1000;
							editor.putString("score", Integer.toString(score));
							editor.commit();
							thisScore.setText(pref.getString("score", "0"));
						}
					});
				}
			}
		});
		thread.start();
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

	public void gameOver() {
		highScoreList = new HighScoreList();
		if (highScoreList.isHighScore(score)) {
			// Ask for name here
			highScoreList.setHighScore(name, Integer.toString(score));
		}
	}

	public void onPause() {
		// Add the small pop up menu here
		super.onPause();
		end = System.currentTimeMillis();
		gameRun = false;
	}

	public void onResume() {
		// Add the resume features here if any
		super.onResume();
	}

	public void onDestroy() {
		super.onDestroy();
		end = System.currentTimeMillis();
		gameRun = false;

	}

	public void jump(View v) {
		// Make the jump command here
		jump += 100;
	}

	public void menu(View v) {
		// Make the menu popup here
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

		// set title
		alertDialogBuilder.setTitle("Are you sure?");

		// set dialog message
		alertDialogBuilder
				.setMessage("The game will be saved if you exit.")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								// if this button is clicked, close
								// current activity
								// Make it save game here

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

}
