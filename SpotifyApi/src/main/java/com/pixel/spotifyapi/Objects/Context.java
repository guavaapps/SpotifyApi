package com.pixel.spotifyapi.Objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Map;

public class Context implements Parcelable {
    public String type;
    public Map <String, String> external_urls;
    public String href;
    public String uri;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeMap(external_urls);
        dest.writeString(href);
        dest.writeString(uri);
    }

    public Context() {
    }

    protected Context(Parcel in) {
        type = in.readString();
        external_urls = in.readHashMap(ClassLoader.getSystemClassLoader());
        href = in.readString();
        uri = in.readString();
    }

    public static final Creator<Context> CREATOR = new Creator<Context>() {
        public Context createFromParcel(Parcel source) {
            return new Context(source);
        }

        public Context[] newArray(int size) {
            return new Context[size];
        }
    };
}