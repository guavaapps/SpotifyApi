package com.pixel.spotifyapi;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.MainThreadExecutor;

public class SpotifyApi {
    private static final String SPOTIFY_API_CALL = "https://api.spotify.com/v1";

    private String accessToken;

    SpotifyService spotifyService;

    private class WebApiAuthenticator implements RequestInterceptor {
        @Override
        public void intercept(RequestFacade request) {
            if (accessToken != null) {
                request.addHeader("Authorization", "Bearer " + accessToken);
            }
        }
    }

    public SpotifyApi (Executor httpExecutor, Executor callbackExecutor) {
        spotifyService = init(httpExecutor, callbackExecutor);
    }

    private SpotifyService init(Executor httpExecutor, Executor callbackExecutor) {

        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.BASIC)
                .setExecutors(httpExecutor, callbackExecutor)
                .setEndpoint(SPOTIFY_API_CALL)
                .setRequestInterceptor(new WebApiAuthenticator())
                .build();

        return restAdapter.create(SpotifyService.class);
    }

    public SpotifyApi () {
        Executor httpExecutor = Executors.newSingleThreadExecutor();
        MainThreadExecutor callbackExecutor = new MainThreadExecutor();
        spotifyService = init(httpExecutor, callbackExecutor);
    }

    public void setAccessToken (String accessToken) {
        this.accessToken = accessToken;
    }

    public SpotifyService getService() {
        return spotifyService;
    }
}
