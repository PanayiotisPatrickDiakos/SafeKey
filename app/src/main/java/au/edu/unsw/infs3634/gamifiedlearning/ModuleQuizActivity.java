package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ModuleQuizActivity extends AppCompatActivity {
    private static final String TAG = "ModuleQuizActivity";
    private TextView mQuizName;
    public static final String INTENT_MESSAGE = "intent_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_quiz);

        mQuizName = findViewById(R.id.quiz_Name);
        Intent intent = getIntent();
        if (intent.hasExtra(INTENT_MESSAGE)) {
            String moduleSymbol = getIntent().getStringExtra(INTENT_MESSAGE);
            Log.d(TAG, "INTENT_MESSAGE = " + moduleSymbol);
            Module module = Module.getModule(moduleSymbol);

            if (module != null) {
                mQuizName.setText(module.getName());
            }
        }
    }
}