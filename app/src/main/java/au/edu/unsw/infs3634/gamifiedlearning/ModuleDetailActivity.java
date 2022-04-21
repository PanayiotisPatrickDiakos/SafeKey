package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class ModuleDetailActivity extends AppCompatActivity {
    private static final String TAG = "ModuleDetailActivity";
    public static final String INTENT_MESSAGE = "intent_message";
    private TextView mName;
    private Button mStartQuiz;
    private TextView mDescription, mTheory;
    private ImageView mImage;
    private RatingBar mDifficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_detail);

        mName = findViewById(R.id.detail_Name);
        mDescription = findViewById(R.id.description_Name);
        mStartQuiz = findViewById(R.id.detail_startQuiz);
        mTheory = findViewById(R.id.txt_detail_theory);
        Intent intent = getIntent();
        if (intent.hasExtra(INTENT_MESSAGE)) {
            String moduleSymbol = getIntent().getStringExtra(INTENT_MESSAGE);
            Log.d(TAG, "INTENT_MESSAGE = " + moduleSymbol);
            Module module = Module.getModule(moduleSymbol);

            mStartQuiz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    launchQuizActivity(moduleSymbol);
                }
            });

            if (module != null) {
                mName.setText(module.getName());
                mDescription.setText(module.getDescription());
                mTheory.setText(module.getTheory());
            }
        }
    }

    protected void launchQuizActivity (String symbol) {
        Log.d(TAG, "Detail Activity Launched");
        Intent intent = new Intent(this, ModuleQuizActivity.class);
        intent.putExtra(ModuleDetailActivity.INTENT_MESSAGE, symbol);
        startActivity(intent);
    }
}