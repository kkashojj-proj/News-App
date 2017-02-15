package com.example.koushik.newsapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by KOUSHIK on 06-02-2017.
 */

public class DoWorkForImage extends AsyncTask<String,Void,Bitmap> {
    IData2 activity;
    public DoWorkForImage(IData2 activity){
        this.activity=activity;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        activity.setImage(bitmap);
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            URL url=new URL(strings[0]);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            Bitmap img= BitmapFactory.decodeStream(con.getInputStream());
            return img;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    static public interface IData2{
        public void setImage(Bitmap bitmap);
    }
}
