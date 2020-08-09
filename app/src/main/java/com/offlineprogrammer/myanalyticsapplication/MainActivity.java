package com.offlineprogrammer.myanalyticsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amplifyframework.analytics.AnalyticsEvent;
import com.amplifyframework.core.Amplify;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button clickMeButton;
    TextView helloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickMeButton = findViewById(R.id.clickMeButton);
        helloTextView = findViewById(R.id.helloTextView);

        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnalyticsEvent event = AnalyticsEvent.builder()
                        .name("clickMeButton")
                        .addProperty("timeClicked", Calendar.getInstance().getTime().toString())
                        .build();
                Amplify.Analytics.recordEvent(event);
                helloTextView.setText("Button Clicked");
            }
        });

    }
}