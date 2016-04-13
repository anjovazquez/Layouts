package com.rteam.layouts.presenter;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.rteam.layouts.view.LoginView;

/**
 * Created by angelvazquez on 12/4/16.
 */
public class LoginPresenter {

    private LoginView loginView;

    public LoginPresenter(){}

    public void setView(@NonNull LoginView loginView) {
        this.loginView = loginView;
    }

    public void doLogin(String user, String pass){
        loginView.showProgress();
        performLogin(user, pass);
    }

    void onResume(){
        if (loginView != null) {
            loginView.showProgress();
        }
    }

    void onPause(){}

    void onDestroy(){
        loginView = null;
    }

    private void performLogin(String user, String pass){
        AsyncTask<String, Void, String> doLoginTask = new AsyncTask<String, Void, String>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loginView.showProgress();
            }
            @Override
            protected String doInBackground(String... params) {
                String user = params[0];
                String password = params[1];
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Login Ok!!!";
            }
            @Override
            protected void onPostExecute(String message) {
                super.onPostExecute(message);
                loginView.hideProgress();
                loginView.showMessage(message);
            }
        };
        doLoginTask.execute(user, pass);
    }


}
