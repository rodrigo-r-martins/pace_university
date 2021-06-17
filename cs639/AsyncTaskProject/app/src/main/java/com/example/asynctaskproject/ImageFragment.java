package com.example.asynctaskproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ImageFragment extends Fragment {
    Button btnLoadImage;
    Button btnResetImage;
    ImageView imageView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLoadImage = view.findViewById(R.id.btn_load_image);
        btnResetImage = view.findViewById(R.id.btn_reset_image);
        imageView = view.findViewById(R.id.iv_image);

        btnLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String imageUrl = getString(R.string.img_url);
                ImageDownloader imageDownloader = new ImageDownloader(getActivity());
                imageDownloader.execute(imageUrl);
            }
        });

        btnResetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("ON RESET_BUTTON", "Image Erased");
                imageView.setImageBitmap(null);
            }
        });
    }
}