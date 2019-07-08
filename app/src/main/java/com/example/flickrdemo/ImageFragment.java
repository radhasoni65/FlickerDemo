package com.example.flickrdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageFragment  extends DialogFragment {

    private ImageView mImageView;

    public ImageFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static ImageFragment newInstance(String title) {
        ImageFragment frag = new ImageFragment();
        Bundle args = new Bundle();
        args.putString("link", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.image_fragment, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        mImageView =  view.findViewById(R.id.image);
        // Fetch arguments from bundle and set title
        String title = getArguments().getString("link", "Enter Name");

        Glide.with(this)
                .load(title)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
        .into(mImageView);


    }
}