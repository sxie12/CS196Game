package com.example.cs196game;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;

public class HighScoreList extends Activity {

	/*
	 * String score_one = ""; String score_two = ""; String score_three = "";
	 * String score_four = ""; String score_five = ""; String name_one = "";
	 * String name_two = ""; String name_three = ""; String name_four = "";
	 * String name_five = "";
	 */
	public String[] highScoreList = new String[5];
	public String[] highScoreNameList = new String[5];
	SharedPreferences pref;
	Editor editor;

	// Use SharedPreferences to get the Strings and then add them to the arrays
	// above

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_high_score_list);
		pref = getApplicationContext().getSharedPreferences("MyPrefs",
				MODE_PRIVATE);
		editor = pref.edit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.high_score_list, menu);
		return true;
	}

	private void fillArrays() {
		highScoreList[1] = pref.getString("highScores_1", "0"); // Returns highScores or the empty string
		highScoreList[2] = pref.getString("highScores_2", "0");
		highScoreList[3] = pref.getString("highScores_3", "0");
		highScoreList[4] = pref.getString("highScores_4", "0");
		highScoreList[5] = pref.getString("highScores_5", "0");
		highScoreNameList[1] = pref.getString("highNames_1", "None");
		highScoreNameList[2] = pref.getString("highNames_2", "None");
		highScoreNameList[3] = pref.getString("highNames_3", "None");
		highScoreNameList[4] = pref.getString("highNames_4", "None");
		highScoreNameList[5] = pref.getString("highNames_5", "None");
	}

	private boolean isHighScore(int score) {
		if (highScoreList[4].equals("0"))
			return true;
		return score > Integer.parseInt(highScoreList[4]);
	}

	private int getHighScoreIndex(int score) {
		for (int i = 0; i < 5; i++) {
			if (highScoreList[i].equals("0"))
				return i;
			if (score > Integer.parseInt(highScoreList[i]))
				return i;
		}
		return 6;
	}

	private void setHighScore(String name, String score) {
		fillArrays();
		int s = Integer.parseInt(score);
		if (isHighScore(s)) {
			String[] tempScore = new String[5];
			String[] tempName = new String[5];
			int index = getHighScoreIndex(s);
			for (int i = 0; i < 5; i++) {
				if (i < index) {
					tempScore[i] = highScoreList[i];
					tempName[i] = highScoreNameList[i];
				} else if (i > index) {
					tempScore[i] = highScoreList[i - 1];
					tempName[i] = highScoreNameList[i - 1];
				} else {
					tempScore[i] = score;
					tempName[i] = name;
				}
			}
			highScoreList = tempScore;
			highScoreNameList = tempName;
		}
		editor.putString("highScores_1", highScoreList[1]);
		editor.putString("highScores_2", highScoreList[2]);
		editor.putString("highScores_3", highScoreList[3]);
		editor.putString("highScores_4", highScoreList[4]);
		editor.putString("highScores_5", highScoreList[5]);
		editor.putString("highNames_1", highScoreNameList[1]);
		editor.putString("highNames_2", highScoreNameList[2]);
		editor.putString("highNames_3", highScoreNameList[3]);
		editor.putString("highNames_4", highScoreNameList[4]);
		editor.putString("highNames_5", highScoreNameList[5]);
		editor.commit();
	}

}
