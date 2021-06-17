package com.example.asynctaskproject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cscharff.
 */

public class ImageDownloader extends AsyncTask<String, Integer, Bitmap> {

    private Activity activity;

    public ImageDownloader(FragmentActivity myActivity) {
        activity = myActivity;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Log.i("ON DO_IN_BACKGROUND", "Starting...");
        publishProgress(1);
        try {
            URL url = new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new Exception("Failed to connect");
            }
            InputStream is = con.getInputStream();
            publishProgress(0);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            is.close();
            return bitmap;
        } catch (Exception e) {
            Log.e("Image", "Failed to load image", e);
            Log.e("error", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        TextView tv = activity.findViewById(R.id.tv_url);
        if (values[0] == 1) {
            tv.setText(R.string.tv_url_loading);
        } else {
            tv.setText("");
        }
    }

    @Override
    protected void onPostExecute(Bitmap img) {
        Log.i("ON POST_EXECUTE", "Starting...");
        ImageView iv = activity.findViewById(R.id.iv_image);
        Log.i("ON POST_EXECUTE", "Grab Image View");
        if (iv != null && img != null) {
            Log.i("ON POST_EXECUTE", "Set up Image");
            iv.setImageBitmap(img);
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}

