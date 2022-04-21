package au.edu.unsw.infs3634.gamifiedlearning;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PersonFragment extends Fragment {
    private ImageView mBadge;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private boolean updateDone = false;
    private String uid;
    private static final String USER = "user";
    private User user;
    private static final String TAG = "PersonFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);

        mBadge = view.findViewById(R.id.iv_badge);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance("https://safekeylogin-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();
        uid = mAuth.getCurrentUser().getUid().toString();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists() && !updateDone) {
                    String currentBadge = snapshot.child(USER).child(uid).child("badge").getValue().toString();
                    Log.d(TAG, String.valueOf(currentBadge));
                    int currentBadgeInt = Integer.parseInt(currentBadge);
                    Log.d(TAG, String.valueOf(currentBadgeInt));
                    String currentXP = snapshot.child(USER).child(uid).child("xp").getValue().toString();
                    Double currentXPInt = Double.parseDouble(currentXP);


                    mBadge.setImageResource(currentBadgeInt);
                    Log.d(TAG, String.valueOf(currentBadge));

                    if(currentXPInt < 100) {
                        mBadge.setImageResource(R.drawable.bronze);
                        currentBadgeInt = R.drawable.bronze;
                        mDatabase.child(USER).child(uid).child("badge").setValue(String.valueOf(currentBadge));
                    }else if(currentXPInt < 200) {
                        mBadge.setImageResource(R.drawable.silver);
                        currentBadgeInt = R.drawable.silver;
                        mDatabase.child(USER).child(uid).child("badge").setValue(String.valueOf(currentBadge));
                    }else if(currentXPInt < 300) {
                        mBadge.setImageResource(R.drawable.gold);
                        currentBadgeInt = R.drawable.gold;
                        mDatabase.child(USER).child(uid).child("badge").setValue(String.valueOf(currentBadge));
                    }else if(currentXPInt < 400) {
                        mBadge.setImageResource(R.drawable.platinum);
                        currentBadgeInt = R.drawable.platinum;
                        mDatabase.child(USER).child(uid).child("badge").setValue(String.valueOf(currentBadge));
                    }else if(currentXPInt < 500) {
                        mBadge.setImageResource(R.drawable.ruby);
                        currentBadgeInt = R.drawable.ruby;
                        mDatabase.child(USER).child(uid).child("badge").setValue(String.valueOf(currentBadge));
                    }else if(currentXPInt < 600) {
                        mBadge.setImageResource(R.drawable.champion);
                        currentBadgeInt = R.drawable.champion;
                        mDatabase.child(USER).child(uid).child("badge").setValue(String.valueOf(currentBadge));
                    }
                    updateDone = true;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;
    }
}
