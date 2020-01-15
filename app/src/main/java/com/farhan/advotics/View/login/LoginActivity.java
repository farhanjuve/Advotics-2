package com.farhan.advotics.View.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.farhan.advotics.View.MainActivity;
import com.farhan.advotics.R;

public class LoginActivity extends Activity {

    EditText txtUsername, txtPassword;

    Button btnLogin;

    SessionManager session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManager(getApplicationContext());

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);

        Toast.makeText(getApplicationContext(), "Sudah Login? " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(view -> {
            String username = txtUsername.getText().toString();
            String password = txtPassword.getText().toString();

            if(username.trim().length() > 0 && password.trim().length() > 0){
                if(username.equals("advotics") && password.equals("advotics")){
                    session.createLoginSession("Rakka Purnama", "Male", "+6287692830");

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();

                }else{
                    Toast.makeText(getApplicationContext(), "Username/Password is incorrect",
                            Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(getApplicationContext(),
                        "Login failed.. Please enter username and password", Toast.LENGTH_LONG).show();
            }
        });
    }
}