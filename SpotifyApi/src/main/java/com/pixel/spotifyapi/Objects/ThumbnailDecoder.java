package com.pixel.spotifyapi.Objects;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ThumbnailDecoder {
    public static void decodeFromUrl (String url, Callback callback) {
        try {
            URL bitmapUrl = new URL (url);

            new Thread (new decodeThread (bitmapUrl, callback)).start ();
        } catch (MalformedURLException e) {
            e.printStackTrace ();
        }
    }

    static class decodeThread extends Thread {
        private URL url;
        private Callback callback;
        Bitmap bitmap;

        public decodeThread (URL url, Callback callback) {
            this.url = url;
            this.callback = callback;
        }

        @Override
        public void run () {
            super.run ();

            try {
                URLConnection urlConnection = url.openConnection ();

                bitmap = BitmapFactory.decodeStream (urlConnection.getInputStream ());

                callback.onBitmapDecoded (bitmap);
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
    };

    public interface Callback {
        void onBitmapDecoded (Bitmap bitmap);
    }
}
