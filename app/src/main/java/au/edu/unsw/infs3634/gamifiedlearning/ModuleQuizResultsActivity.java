package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ModuleQuizResultsActivity extends AppCompatActivity {
    private static final String TAG = "ModuleQuizResultsActivity";
    private TextView mResults, mXP;
    private Button mContinue;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private String uid;
    private static final String USER = "user";
    private User user;
    boolean updateDone = false;

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_quiz_results);

        mResults = findViewById(R.id.res_results_value);
        mXP = findViewById(R.id.res_xp_gained);
        mContinue = findViewById(R.id.btn_res_continue);

        Intent intent = getIntent();
        String correct = getIntent().getStringExtra("correct");
        int minsLeft = getIntent().getIntExtra("mins_left", 1);
        int secLeft = getIntent().getIntExtra("sec_left",1);
        Log.d(TAG, correct);
        Log.d(TAG, String.valueOf(minsLeft));
        Log.d(TAG, String.valueOf(secLeft));

        mResults.setText(correct + "/10");

        double correctMulti = Double.parseDouble(correct);
        final double xpGained = correctMulti * secLeft;
        mXP.setText(String.valueOf(xpGained));

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance("https://safekeylogin-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();
        uid = mAuth.getCurrentUser().getUid().toString();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists() && !updateDone) {
                    String currentXP = snapshot.child(USER).child(uid).child("xp").getValue().toString();
                    Log.d(TAG, String.valueOf(currentXP));
                    double newXP = Double.parseDouble(currentXP) + xpGained;
                    Log.d(TAG, String.valueOf(newXP));
                    mDatabase.child(USER).child(uid).child("xp").setValue(String.valueOf(newXP));
                    updateDone = true;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        }



}