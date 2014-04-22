package com.example.cs196game;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;

public class HighScoreList extends Activity {

	/*
	String score_one = "";
	String score_two = "";
	String score_three = "";
	String score_four = "";
	String score_five = "";
	String name_one = "";
	String name_two = "";
	String name_three = "";
	String name_four = "";
	String name_five = "";
	*/
	public String[] highScoreList = new String[5];
	public String[] highScoreNameList = new String[5];
	SharedPreferences pref;
	Editor editor;
	
	// Use SharedPreferences to get the Strings and then add them to the arrays above
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_high_score_list);
		pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE); 
		editor = pref.edit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.high_score_list, menu);
		return true;
	}
	
	private boolean isHighScore(int score) {
		if(highScoreList[4].equals(""))
			return true;
		return score > Integer.parseInt(highScoreList[4]);
	}
	
	private int getHighScoreIndex(int score) {
		for(int i = 0; i < 5; i++) {
			if(highScoreList[i].equals(""))
				return i;
			if(score > Integer.parseInt(highScoreList[i]))
				return i;
		}
		return 6;
	}
	
	private void setHighScore(String name, String score) {
		int s = Integer.parseInt(score);
		if(isHighScore(s)) {
			String[] tempScore = new String[5];
			String[] tempName = new String[5];
			int index = getHighScoreIndex(s);
			for(int i = 0; i < 5; i++) {
				if(i < index) {
					tempScore[i] = highScoreList[i];
					tempName[i] = highScoreNameList[i];
				} else if(i > index) {
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
	}

}
