package au.edu.unsw.infs3634.gamifiedlearning;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonFragment extends Fragment implements Callback<NewsResponse> {
    private ImageView mBadge;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private boolean updateDone = false;
    private String uid;
    private static final String USER = "user";
    private User user;
    private static final String TAG = "PersonFragment";
    private TextView badgeScore, badgeText;
    private RecyclerView newsRecycleView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);

        mBadge = view.findViewById(R.id.iv_badge);
        badgeScore = view.findViewById(R.id.badge_score);
        badgeText = view.findViewById(R.id.badge_text);
        newsRecycleView = view.findViewById(R.id.news_recycleview);

        getNews();

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

                    badgeScore.setText(String.valueOf(currentXPInt));

                    if(currentXPInt < 100) {
                        mBadge.setImageResource(R.drawable.bronze);
                        badgeText.append(" Bronze");
                        mDatabase.child(USER).child(uid).child("badge").setValue(String.valueOf(currentBadge));
                    }else if(currentXPInt < 200) {
                        mBadge.setImageResource(R.drawable.silver);
                        badgeText.append(" Silver");
                        mDatabase.child(USER).child(uid).child("badge").setValue(String.valueOf(currentBadge));
                    }else if(currentXPInt < 300) {
                        mBadge.setImageResource(R.drawable.gold);
                        badgeText.append(" Gold");
                        mDatabase.child(USER).child(uid).child("badge").setValue(String.valueOf(currentBadge));
                    }else if(currentXPInt < 400) {
                        mBadge.setImageResource(R.drawable.platinum);
                        badgeText.append(" Platinum");
                        mDatabase.child(USER).child(uid).child("badge").setValue(String.valueOf(currentBadge));
                    }else if(currentXPInt < 500) {
                        mBadge.setImageResource(R.drawable.ruby);
                        badgeText.append(" Ruby");
                        mDatabase.child(USER).child(uid).child("badge").setValue(String.valueOf(currentBadge));
                    }else if(currentXPInt < 600) {
                        mBadge.setImageResource(R.drawable.champion);
                        badgeText.append(" Champion");
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

    private void getNews() {
        new RetrofitClient().start("bbc-news","d3eb336558804795b8a7d6cc9fc86484",this);
    }


    @Override
    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        if(response.isSuccessful() && response.body() != null) {
            List<Article> articleList = response.body().getArticles();
           NewsAdapter adapter = new NewsAdapter(articleList);
           newsRecycleView.setAdapter(adapter);
        } else {
            Log.i("Error: ",response.errorBody().source().toString());
        }
    }

    @Override
    public void onFailure(Call<NewsResponse> call, Throwable t) {
        t.printStackTrace();
    }
}
