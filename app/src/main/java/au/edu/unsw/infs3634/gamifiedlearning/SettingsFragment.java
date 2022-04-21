package au.edu.unsw.infs3634.gamifiedlearning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SettingsFragment extends Fragment {
    private Button mOptionA, mOptionB, mOptionC, mChoose;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private String uid;
    private static final String USER = "user";
    private User user;
    boolean updateDone = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        //set onlcicklistener here

        mOptionA = view.findViewById(R.id.subscriptionOptionA);
        mOptionB = view.findViewById(R.id.subscriptionOptionB);
        mOptionC = view.findViewById(R.id.subscriptionOptionC);
        mChoose = view.findViewById(R.id.subscriptionButton);

        mOptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                mDatabase = FirebaseDatabase.getInstance("https://safekeylogin-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();
                uid = mAuth.getCurrentUser().getUid().toString();
                //Get User email
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists() && !updateDone) {
                            String userEmail = snapshot.child(USER).child(uid).child("email").getValue().toString();
                            String subject = "SafeKey Subscription Invoice: Noob Plan";
                            String message = "Thank you for subscribing to SafeKey! Consider this as an invoice for\n" +
                                    "your Noob plan. \n" +
                                    "Month: April\n" +
                                    "Price: AUD $0.50\n" +
                                    "Account's Card: XXXX XXXX XXXX 1234";
                            sendMail(userEmail, subject, message);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        return view;
    }

    private void sendMail(String userEmail, String subject, String message) {
        JavaMailAPI javaMailAPI = new JavaMailAPI(getContext(), userEmail, subject, message);

        javaMailAPI.execute();

    }

}
