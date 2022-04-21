package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SubscriptionActivity extends AppCompatActivity {
    private Button mOptionA, mOptionB, mOptionC, mChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_settings);
        mOptionA = findViewById(R.id.subscriptionOptionA);
        mOptionB = findViewById(R.id.subscriptionOptionB);
        mOptionC = findViewById(R.id.subscriptionOptionC);
        mChoose = findViewById(R.id.subscriptionButton);
    }
}