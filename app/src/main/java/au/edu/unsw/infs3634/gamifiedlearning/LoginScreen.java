package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class LoginScreen extends AppCompatActivity {

    EditText username;
    EditText password;

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        loginButton = (Button) findViewById(R.id.loginbutton);

        username.addTextChangedListener(inputTextWatcher);
        password.addTextChangedListener(inputTextWatcher);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Toast.makeText(LoginScreen.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(LoginScreen.this, "Login Failed", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(LoginScreen.this, MainActivity.class);

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
                String usernameInput = username.getText().toString().trim();
                String passwordInput = password.getText().toString().trim();
                //if all 2 user prompts are filled, button will be enabled
                loginButton.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };


}