package com.example.luka.mvpproject.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Luka on 14.12.2017.
 */

public class LoginInteractorImpl implements LoginInteractor {



    @Override
    public void login(String username, String password, final onLogInFinishedListener listener) {

        if (TextUtils.isEmpty(username)){
            listener.onUsernameError();
        }
        else if (TextUtils.isEmpty(password)){
            listener.onPasswordError();
        }
        else if (username.equals("admin") && password.equals("admin")){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    listener.onSuccess();
                }
            },1000);
        }
        else {
            listener.onFailure("Invalid");
        }

    }
}
