package com.example.flickrdemo;

import android.app.Application;

import com.example.flickrdemo.api.ApiService;
import com.example.flickrdemo.ui.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {

    static MyApplication mAppInstance;

    public static MyApplication getmAppInstance() {
        return mAppInstance;
    }

    public static void setmAppInstance(MyApplication mAppInstance) {
        MyApplication.mAppInstance = mAppInstance;
    }

    ApiService apiService;


    public ApiService getApiService() {
        return apiService;
    }

    public void setApiService(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override

    public void onCreate() {
        super.onCreate();
        mAppInstance = this;
        createNewApiService();
    }

    private ApiService createNewApiService() {

        Gson gson = new GsonBuilder().create();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .connectionPool(new ConnectionPool(0, 5 * 60 * 1000, TimeUnit.SECONDS))
                .build();

        //init retrofit
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient)
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiService = retrofit.create(ApiService.class);
        return apiService;
    }


    private String getAppVersion() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "2.0";
        }
    }

}
