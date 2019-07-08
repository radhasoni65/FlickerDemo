package com.example.flickrdemo.ui.presenter;

import android.widget.Toast;

import com.example.flickrdemo.MyApplication;
import com.example.flickrdemo.model.ImagesModel;
import com.example.flickrdemo.ui.views.ImagesView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlickerImagesPresenter extends BasePresenter<ImagesView> {

    public void fetchFlickImages(String flowers, String json, String s) {
        getView().enableLoadingBar(true);
        MyApplication.getmAppInstance().getApiService().fetchImages(flowers, json, s).enqueue(new Callback<ImagesModel>() {
            @Override
            public void onResponse(Call<ImagesModel> call, Response<ImagesModel> response) {
                getView().enableLoadingBar(false);
                if (response.code() == 200) {
                    getView().onImagesFetchSuccess(response.body().getItems());
                }


            }

            @Override
            public void onFailure(Call<ImagesModel> call, Throwable t) {
                getView().enableLoadingBar(false);
                Toast.makeText(MyApplication.getmAppInstance(), "on failure", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
