package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ModuleQuizResultsActivity extends AppCompatActivity {
    private static final String TAG = "ModuleQuizResultsActivity";
    private TextView mResults;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private String uid;
    private static final String USER = "user";
    private User user;

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_quiz_results);

        mResults = findViewById(R.id.res_results_value);

        Intent intent = getIntent();
        String correct = getIntent().getStringExtra("correct");
        Log.d(TAG, correct);

        mResults.setText(correct + "/10");

//        mAuth = FirebaseAuth.getInstance();
//        uid = mAuth.getCurrentUser().getUid().toString();
//        mDatabase = FirebaseDatabase.getInstance().getReference(USER + uid);
//        mDatabase.updateChildren();

    }
}