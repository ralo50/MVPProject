package com.example.luka.mvpproject.login;

/**
 * Created by Luka on 14.12.2017.
 */

public interface LoginPresenter {

    void validateCred(String username, String password);
    void onDestroy();
}
