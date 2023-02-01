package com.pixel.spotifyapi.Objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Map;

/**
 * <a href="https://developer.spotify.com/web-api/object-model/#track-object-full">Track object model</a>
 */
public class RecentlyPlayedTrack implements Parcelable {
    public Track track;
    public String played_at;
    public Context context;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(track, 0);
        dest.writeString(played_at);
        dest.writeParcelable(context, 0);
    }

    public RecentlyPlayedTrack() {
    }

    protected RecentlyPlayedTrack(Parcel in) {
        track = in.readParcelable(Track.class.getClassLoader());
        played_at = in.readString();
        context = in.readParcelable(Context.class.getClassLoader());
    }

    public static final Creator<RecentlyPlayedTrack> CREATOR = new Creator<RecentlyPlayedTrack>() {
        public RecentlyPlayedTrack createFromParcel(Parcel source) {
            return new RecentlyPlayedTrack(source);
        }

        public RecentlyPlayedTrack[] newArray(int size) {
            return new RecentlyPlayedTrack[size];
        }
    };
}