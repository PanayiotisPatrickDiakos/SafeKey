package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email, password, fName;
    private Button regButton;
    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private static final String USER = "user";
    private static final String TAG = "RegisterActivity";
    private User user;
    private String emailString;
    private String passString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        database = FirebaseDatabase.getInstance("https://safekeylogin-default-rtdb.asia-southeast1.firebasedatabase.app/");
        mDatabase = database.getReference(USER);
        mAuth = FirebaseAuth.getInstance();

        email = (EditText) findViewById(R.id.reg_email);
        password = (EditText) findViewById(R.id.reg_password);
        fName = (EditText) findViewById(R.id.reg_fName);
        regButton = findViewById(R.id.reg_loginbutton);




        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailString = email.getText().toString().trim();
                String passString = password.getText().toString().trim();

                if(TextUtils.isEmpty(emailString) || TextUtils.isEmpty(passString)) {
                    Toast.makeText(getApplicationContext(), "Please enter email and password",
                            Toast.LENGTH_LONG).show();
                } else {
                    Register();
                }
            }
        });


    }

    private void Register() {
        String emailString = email.getText().toString().trim();
        String passString = password.getText().toString().trim();
        String fullName = fName.getText().toString().trim();
            mAuth.createUserWithEmailAndPassword(emailString, passString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Log.d(TAG,"created user");
                        user = new User(fullName, null, null, emailString, passString);
                        database.getReference(USER).child(mAuth.getCurrentUser().getUid())
                                .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(RegisterActivity.this, "Sign up Successful", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
                    }
                    else {
                        Toast.makeText(RegisterActivity .this, "Register Failed", Toast.LENGTH_SHORT).show();
                        email.setBackgroundColor(getResources().getColor(R.color.pastel_red));
                        password.setBackgroundColor(getResources().getColor(R.color.pastel_red));
                    }
                }
            });
    }

    private void updateUI(FirebaseUser user) {
        String keyId = mDatabase.push().getKey();
        mDatabase.child(keyId).setValue(user);
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
            regButton.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}