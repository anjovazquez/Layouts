package com.rteam.layouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rteam.layouts.presenter.LoginPresenter;
import com.rteam.layouts.view.LoginView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LinearLayoutActivity extends AppCompatActivity implements LoginView{

    @Bind(R.id.login)
    Button bLogin;

    @Bind(R.id.user)
    EditText tUser;

    @Bind(R.id.password)
    EditText tPass;

    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter();
        loginPresenter.setView(this);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.doLogin(tUser.getText().toString(), tPass.getText().toString());
            }
        });
    }

    @Override
    public void showProgress() {
        if(progressBar!=null){
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        if(progressBar!=null){
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast toastMessage = Toast
                .makeText(this, message, Toast.LENGTH_LONG);

        toastMessage.show();
    }
}
