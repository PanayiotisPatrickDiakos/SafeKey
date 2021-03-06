package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

/**
 * Responsible for generating random advert after login
 */
public class AdvertActivity extends AppCompatActivity {
    private ImageView mCancel;
    private ImageView mAdvert;
    SplashScreen splashScreen = new SplashScreen();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advert);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mCancel = findViewById(R.id.iv_cancel);
        mAdvert = findViewById(R.id.iv_ad);

        Random rand = new Random();
        int rand_int = rand.nextInt(4-1) + 1;
        switch(rand_int) {
            case 1:
                mAdvert.setImageResource(R.drawable.bitpay_ad);
                mAdvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://bitpay.com/"));
                        startActivity(intent);
                    }
                });
                break;
            case 2:
                mAdvert.setImageResource(R.drawable.nordvpn_ad);
                mAdvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nordvpn.com/"));
                        startActivity(intent);
                    }
                });
                break;
            case 3:
                mAdvert.setImageResource(R.drawable.unsw_ad);
                mAdvert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.unsw.edu.au/"));
                        startActivity(intent);
                    }
                });
                break;
        }

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AdvertActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}