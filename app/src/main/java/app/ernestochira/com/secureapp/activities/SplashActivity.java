package app.ernestochira.com.secureapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import java.security.MessageDigest;

import app.ernestochira.com.secureapp.GoogleMapsActivity;
import app.ernestochira.com.secureapp.R;

public class SplashActivity extends Activity {

    final static int SPLASH_OUT_TIMEOUT = 2000;
    final static int SLEEP_INTERVAL = 100;
    final static String TAG = "SecureApp";

    TextView logoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread splashDelayer = new Thread() {
            int wait = 0;
            @Override
            public void run() {
                try {
                    super.run();
                    while(wait < SPLASH_OUT_TIMEOUT){
                        sleep(SLEEP_INTERVAL);
                        wait += SLEEP_INTERVAL;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Log.d(TAG, "Error on Splash Screen");
                } finally {
                    startActivity(new Intent(SplashActivity.this, GoogleMapsActivity.class));
                    finish();
                }
            }
        };
        splashDelayer.start();

        logoTextView = (TextView)findViewById(R.id.logoTextView);
        String logoFontPath = "font/tribalBox.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(),logoFontPath);
        logoTextView.setTypeface(typeface);
    }
}
