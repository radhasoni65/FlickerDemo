package com.example.flickrdemo.ui.views;

public interface BaseView {

    public void enableLoadingBar(boolean enable);

    /*implemented in BaseActivity and BaseFragment*/
    public void onError(String reason);

    /*implemented in BaseActivity and BaseFragment*/
    public void onInfo(String message);


    /*implemented in BaseActivity and BaseFragment*/
    public void onTokenExpired();

    /*implemented in BaseActivity and BaseFragment*/
    public void onForceUpdate();

    /*implemented in BaseActivity and BaseFragment*/
    public void onSoftUpdate();

}
