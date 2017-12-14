package com.example.luka.mvpproject.login;

/**
 * Created by Luka on 14.12.2017.
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUsernameError();
    void setPasswordError();
    void navigateToMain();
    void showAlert(String message);
}
