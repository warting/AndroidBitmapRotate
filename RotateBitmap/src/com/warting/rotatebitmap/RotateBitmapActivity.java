package com.warting.rotatebitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class RotateBitmapActivity extends Activity {
	ImageView iv;
	private Bitmap bitmap;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		iv = (ImageView) findViewById(R.id.ImageView01);

		findViewById(R.id.left).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				rotate(-90F);
			}
		});

		findViewById(R.id.right).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				rotate(90F);
			}
		});
	}

	private void rotate(float f) {

		Matrix rotateMatrix = new Matrix();
		rotateMatrix.postRotate(f);

		if (bitmap != null) {
			bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), rotateMatrix, true);

			iv.setImageBitmap(bitmap);
		}
	}
}