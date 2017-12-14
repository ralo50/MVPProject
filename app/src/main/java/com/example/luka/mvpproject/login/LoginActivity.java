package com.example.luka.mvpproject.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.luka.mvpproject.MainActivity;
import com.example.luka.mvpproject.R;

public class LoginActivity extends AppCompatActivity implements LoginView
{


    private EditText edUserName, edPassword;
    private Button button;
    private ProgressBar progressBar;

    private LoginPresenter mLogInPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogInPresenter = new LoginPresenterImpl(this);

        edUserName = findViewById(R.id.usernameEditText);
        edPassword = findViewById(R.id.passwordEditText);
        button = findViewById(R.id.buttonLogIn);
        progressBar = findViewById(R.id.progressBar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLogInPresenter.validateCred(edUserName.getText().toString().trim(), edPassword.getText().toString().trim());
            }
        });

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        edUserName.setError("Username empty");
    }

    @Override
    public void setPasswordError() {
        edPassword.setError("Password empty");
    }

    @Override
    public void navigateToMain() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLogInPresenter.onDestroy();
    }
}
