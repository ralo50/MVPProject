package com.example.luka.mvpproject.login;

/**
 * Created by Luka on 14.12.2017.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.onLogInFinishedListener{

    LoginView mLogInView;
    LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView mLogInView){
        this.mLogInView = mLogInView;
        mLoginInteractor = new LoginInteractorImpl();


    }
    @Override
    public void validateCred(String username, String password) {
        mLoginInteractor.login(username, password, this);
        if (mLogInView != null){
            mLogInView.showProgress();
            mLoginInteractor.login(username, password, this);
        }
    }

    @Override
    public void onDestroy() {
        if (mLogInView != null){
            mLogInView = null;

        }
    }

    @Override
    public void onUsernameError() {
        if (mLogInView != null){
            mLogInView.hideProgress();
            mLogInView.setUsernameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (mLogInView != null){
            mLogInView.hideProgress();
            mLogInView.setPasswordError();
        }
    }

    @Override
    public void onSuccess() {
        if (mLogInView != null){
            mLogInView.hideProgress();
            mLogInView.navigateToMain();
        }
    }

    @Override
    public void onFailure(String message) {
        if (mLogInView != null){
            mLogInView.hideProgress();
            mLogInView.showAlert(message);
        }
    }
}
