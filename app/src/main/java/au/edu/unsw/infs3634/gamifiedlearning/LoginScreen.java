package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Utilise firebase to authenticate users with Name, email address and passwords. Dependant on user's
 * subscription status determines advert activity
 */
public class LoginScreen extends AppCompatActivity {

    private EditText email, password;
    private TextView register;
    private Button loginButton;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private String uid;
    private static final String USER = "user";
    private User user;
    boolean updateDone = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        mAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        register = (TextView) findViewById(R.id.register);

        loginButton = (Button) findViewById(R.id.loginbutton);

        email.addTextChangedListener(inputTextWatcher);
        password.addTextChangedListener(inputTextWatcher);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                mAuth.signInWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(LoginScreen.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            mDatabase = FirebaseDatabase.getInstance("https://safekeylogin-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();
                            uid = mAuth.getCurrentUser().getUid().toString();
                            mDatabase.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    if(snapshot.exists() && !updateDone) {
                                        String subscribeStatus = snapshot.child(USER).child(uid).child("subscribe").getValue().toString();
                                        if(subscribeStatus.equals("false")) {
                                            Intent intent = new Intent(LoginScreen.this, AdvertActivity.class);
                                            startActivity(intent);
                                        } else {
                                            Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                                            startActivity(intent);
                                        }
                                    }

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        }
                        else {
                            Toast.makeText(LoginScreen.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                            email.setBackgroundColor(getResources().getColor(R.color.pastel_red));
                            password.setBackgroundColor(getResources().getColor(R.color.pastel_red));
                        }
                    }
                });
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginScreen.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
        private TextWatcher inputTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String usernameInput = email.getText().toString().trim();
                String passwordInput = password.getText().toString().trim();
                //If all 2 user prompts are filled, button will be enabled
                loginButton.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };


}