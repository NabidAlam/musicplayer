package com.sdlabaust.sopranomusicplayer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_animation);

		// get the view
		ImageView splashimg = (ImageView) findViewById(R.id.splashscreen_animation);
		// set the animation drawable as background
		splashimg.setBackgroundResource(R.drawable.animation_resource_splashscreen);
		// create an animation drawable using the background
		AnimationDrawable animedraw = (AnimationDrawable) splashimg
				.getBackground();
		// start the animation
		animedraw.start();

		Thread SplashTimer = new Thread() {
			public void run() {
				try {
					sleep(3000);
					startActivity(new Intent(getApplicationContext(),
							MusicPlayerActivity.class));
				} catch (Exception e) {
				} finally {
					finish();
				}
			}
		};

		SplashTimer.start();

	}

}