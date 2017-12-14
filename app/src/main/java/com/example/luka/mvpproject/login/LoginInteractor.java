package com.example.luka.mvpproject.login;

/**
 * Created by Luka on 14.12.2017.
 */

public interface LoginInteractor {

    interface onLogInFinishedListener{

        void onUsernameError();
        void onPasswordError();
        void onSuccess();
        void onFailure(String message);

    }
    void login(String username, String password, onLogInFinishedListener listener);
}
