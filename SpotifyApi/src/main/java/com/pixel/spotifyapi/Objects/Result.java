package com.pixel.spotifyapi.Objects;

import android.os.Parcel;
import android.os.Parcelable;

public class Result implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public Result() {
    }

    protected Result(Parcel in) {
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        public Result createFromParcel(Parcel source) {
            return new Result (source);
        }

        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
}
