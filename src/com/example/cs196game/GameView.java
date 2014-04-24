package com.example.cs196game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;

public class GameView extends SurfaceView {
	Paint paint = new Paint();
	
	public GameView(Context context) {
		super(context);
		paint.setColor(Color.BLACK);
	}
	
	public void onDraw(Canvas canvas) {
		paint.setStrokeWidth(10);
		canvas.drawRect(50, 250, 70, 270, paint);
	}

}
