package com.rteam.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rteam.layouts.viewmodel.LoginViewModel;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RelativeLayoutActivity extends AppCompatActivity implements LoginViewModel.Listener {

    @Bind(R.id.login)
    Button bLogin;

    @Bind(R.id.user)
    EditText tUser;

    @Bind(R.id.password)
    EditText tPass;

    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        ButterKnife.bind(this);

        loginViewModel = new LoginViewModel();
        loginViewModel.setListener(this);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.doLogin(tUser.getText().toString(), tPass.getText().toString());
            }
        });

    }

    @Override
    public void onLoginSuccess(String message) {
        Toast toastMessage = Toast
                .makeText(this, message, Toast.LENGTH_LONG);

        toastMessage.show();
        //New Intent
    }

    @Override
    public void onLoginError(String message) {
        Toast toastMessage = Toast
                .makeText(this, message, Toast.LENGTH_LONG);

        toastMessage.show();
    }

    @Override
    public void onLoading(boolean loading) {
        progressBar.setVisibility(loading ? View.VISIBLE : View.GONE);
    }
}
