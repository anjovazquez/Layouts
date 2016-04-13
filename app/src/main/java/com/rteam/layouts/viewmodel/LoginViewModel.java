package com.rteam.layouts.viewmodel;

import android.os.AsyncTask;

import com.rteam.layouts.RelativeLayoutActivity;

/**
 * Created by angel.vazquez on 13/04/2016.
 */
public class LoginViewModel {

    private Listener listener;

    public void setListener(RelativeLayoutActivity listener) {
        this.listener = listener;
    }

    public Listener getListener() {
        return listener;
    }

    public void doLogin(String user, String pass){
        performLogin(user, pass);
    }


    public interface Listener {

        void onLoginSuccess(final String message);

        void onLoginError(final String message);

        void onLoading(final boolean loading);
    }

    private void performLogin(String user, String pass){
        AsyncTask<String, Void, Boolean> doLoginTask = new AsyncTask<String, Void, Boolean>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                listener.onLoading(true);
            }
            @Override
            protected Boolean doInBackground(String... params) {
                Boolean result = false;
                String user = params[0];
                String password = params[1];
                try {
                    Thread.sleep(3000);
                    result = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return result;
            }
            @Override
            protected void onPostExecute(Boolean loginin) {
                super.onPostExecute(loginin);
                listener.onLoading(false);
                if(loginin){
                    listener.onLoginSuccess("Login OK!!");
                }
                else{
                    listener.onLoginError("Login KO!!");
                }
            }
        };
        doLoginTask.execute(user, pass);
    }
}
