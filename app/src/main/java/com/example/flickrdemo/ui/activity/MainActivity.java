package com.example.flickrdemo.ui.activity;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.flickrdemo.ImageFragment;
import com.example.flickrdemo.R;
import com.example.flickrdemo.databinding.ActivityMainBinding;
import com.example.flickrdemo.model.ImagesModel;
import com.example.flickrdemo.ui.adapter.RecyclerViewArrayAdapter;
import com.example.flickrdemo.ui.presenter.FlickerImagesPresenter;
import com.example.flickrdemo.ui.utils.Utility;
import com.example.flickrdemo.ui.views.ImagesView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ImagesView, RecyclerViewArrayAdapter.OnItemClickListener<ImagesModel.ItemModel> {


    ActivityMainBinding mainBinding;
    FlickerImagesPresenter mPresenter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        mainBinding.recycleImage.setLayoutManager(new GridLayoutManager(this, 2));
        mainBinding.recycleImage.setItemAnimator(new DefaultItemAnimator());
        mPresenter = new FlickerImagesPresenter();
        mPresenter.setView(this);
        if (Utility.isInternetAvailable(this)) {
            mPresenter.fetchFlickImages("flowers", "json", "1");
        } else {
            Utility.showNetworkFailureAlert(this);
        }

    }


    @Override
    public void onImagesFetchSuccess(List<ImagesModel.ItemModel> body) {
        if (body != null && body.size() > 0) {
            mainBinding.recycleImage.setAdapter(new RecyclerViewArrayAdapter(body, this));

        }

    }

    @Override
    public void onImagesFetchFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void enableLoadingBar(boolean enable) {
        if (!isFinishing()) {
            if (enable) {
                loadProgressBar(null, getString(R.string.loading), false);
            } else {
                dismissProgressBar();
            }
        }
    }

    @Override
    public void onError(String reason) {

    }

    @Override
    public void onInfo(String message) {

    }

    @Override
    public void onTokenExpired() {

    }

    @Override
    public void onForceUpdate() {

    }

    @Override
    public void onSoftUpdate() {

    }


    @Override
    public void onItemClick(View view, int position, ImagesModel.ItemModel object) {
        showEditDialog(object.getMedia().getM());
    }
    private void showEditDialog(String link) {
        FragmentManager fm = getSupportFragmentManager();
        ImageFragment editNameDialogFragment = ImageFragment.newInstance(link);
        editNameDialogFragment.show(fm, "fragment_image");
    }
    public void loadProgressBar(String title, String message, boolean cancellable) {
        if (!isFinishing()) {
            if (progressDialog == null)
                progressDialog = ProgressDialog.show(this, title, message, false, cancellable);
        }

    }

    public void dismissProgressBar() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog = null;
    }



}
