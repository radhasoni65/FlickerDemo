package com.example.flickrdemo.ui.views;

import com.example.flickrdemo.model.ImagesModel;

import java.util.List;

public  interface ImagesView extends BaseView {

    public void onImagesFetchSuccess(List<ImagesModel.ItemModel> body);

    public void onImagesFetchFailure(String message);
}
