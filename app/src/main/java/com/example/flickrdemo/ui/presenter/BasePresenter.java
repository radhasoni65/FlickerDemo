package com.example.flickrdemo.ui.presenter;

import com.example.flickrdemo.api.BaseResponse;
import com.example.flickrdemo.ui.views.BaseView;
import com.google.gson.Gson;


import retrofit2.Response;

public abstract class BasePresenter<I extends BaseView> {

    I iView;

    public BasePresenter() {
    }

    public I getView() {
        return iView;
    }

    public void setView(I iView) {
        this.iView = iView;
    }


    public boolean handleError(Response response) {
        if (response.code() == 203) {
            return handleError(((BaseResponse) response.body()), false);

        } else if (response.code() == 401) {
            ///call the refreshToken APi on this error code
            getView().onTokenExpired();
            return true;
        } else if (response.errorBody() != null) {
            try {
                String error = response.errorBody().string();
                BaseResponse errorResponse = new Gson().fromJson(error, BaseResponse.class);
                return handleError(errorResponse, false);
            } catch (Exception e) {
                e.printStackTrace();
                getView().onError(null);
                return true;
            }
        } else {
            return handleError(((BaseResponse) response.body()), response.code() == 200);
        }
    }

    public boolean handleError(BaseResponse response, boolean success) {

        if (success) {
            return false;
        } else {
            getView().onError(response != null ? response.message : null);
            return true;
        }

    }


}
