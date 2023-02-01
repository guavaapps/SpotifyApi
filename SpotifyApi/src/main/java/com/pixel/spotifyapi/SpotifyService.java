package com.pixel.spotifyapi;

import com.pixel.spotifyapi.Objects.Albums;
import com.pixel.spotifyapi.Objects.AlbumsPager;
import com.pixel.spotifyapi.Objects.Artist;
import com.pixel.spotifyapi.Objects.Artists;
import com.pixel.spotifyapi.Objects.ArtistsCursorPager;
import com.pixel.spotifyapi.Objects.ArtistsPager;
import com.pixel.spotifyapi.Objects.AudioFeaturesTrack;
import com.pixel.spotifyapi.Objects.AudioFeaturesTracks;
import com.pixel.spotifyapi.Objects.CategoriesPager;
import com.pixel.spotifyapi.Objects.Category;
import com.pixel.spotifyapi.Objects.DELETEWITHBODY;
import com.pixel.spotifyapi.Objects.FeaturedPlaylists;
import com.pixel.spotifyapi.Objects.NewReleases;
import com.pixel.spotifyapi.Objects.Pager;
import com.pixel.spotifyapi.Objects.Playlist;
import com.pixel.spotifyapi.Objects.PlaylistFollowPrivacy;
import com.pixel.spotifyapi.Objects.PlaylistSimple;
import com.pixel.spotifyapi.Objects.PlaylistTrack;
import com.pixel.spotifyapi.Objects.PlaylistsPager;
import com.pixel.spotifyapi.Objects.RecentlyPlayedTrack;
import com.pixel.spotifyapi.Objects.Recommendations;
import com.pixel.spotifyapi.Objects.Result;
import com.pixel.spotifyapi.Objects.SavedAlbum;
import com.pixel.spotifyapi.Objects.SavedTrack;
import com.pixel.spotifyapi.Objects.SeedsGenres;
import com.pixel.spotifyapi.Objects.SnapshotId;
import com.pixel.spotifyapi.Objects.Track;
import com.pixel.spotifyapi.Objects.Tracks;
import com.pixel.spotifyapi.Objects.TracksPager;
import com.pixel.spotifyapi.Objects.TracksToRemove;
import com.pixel.spotifyapi.Objects.TracksToRemoveWithPosition;
import com.pixel.spotifyapi.Objects.UserPrivate;
import com.pixel.spotifyapi.Objects.UserPublic;
import com.pixel.spotifyapi.Objects.Album;

import java.io.Serializable;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;

public interface SpotifyService {
    String LIMIT = "limit";
    String OFFSET = "offset";
    String ALBUM_TYPE = "album_type";

    String MARKET = "market";

    String COUNTRY = "country";

    String LOCALE = "locale";

    String FIELDS = "fields";

    String TIMESTAMP = "timestamp";

    String TIME_RANGE = "time_range";

    @GET("/me")
    void getCurrentUser(Callback<UserPrivate> callback);

    @GET("/me")
    UserPrivate getCurrentUser();


    @GET("/users/{id}")
    void getUser(@Path("id") String userId, Callback<UserPublic> callback);


    @GET("/users/{id}")
    UserPublic getUser(@Path("id") String userId);


    @GET("/me/playlists")
    void getCurrentUserPlaylists(Callback<Pager<PlaylistSimple>> callback);


    @GET("/me/playlists")
    Pager<PlaylistSimple> getCurrentUserPlaylists();


    @GET("/me/playlists")
    void getCurrentUserPlaylists(@QueryMap Map<String, Object> options, Callback<Pager<PlaylistSimple>> callback);


    @GET("/me/playlists")
    Pager<PlaylistSimple> getCurrentUserPlaylists(@QueryMap Map<String, Object> options);


    @GET("/users/{id}/playlists")
    void getPlaylists(@Path("id") String userId, @QueryMap Map<String, Object> options, Callback<Pager<PlaylistSimple>> callback);


    @GET("/users/{id}/playlists")
    Pager<PlaylistSimple> getPlaylists(@Path("id") String userId, @QueryMap Map<String, Object> options);


    @GET("/users/{id}/playlists")
    void getPlaylists(@Path("id") String userId, Callback<Pager<PlaylistSimple>> callback);


    @GET("/users/{id}/playlists")
    Pager<PlaylistSimple> getPlaylists(@Path("id") String userId);


    @GET("/users/{user_id}/playlists/{playlist_id}")
    void getPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @QueryMap Map<String, Object> options, Callback<Playlist> callback);


    @GET("/users/{user_id}/playlists/{playlist_id}")
    Playlist getPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @QueryMap Map<String, Object> options);


    @GET("/users/{user_id}/playlists/{playlist_id}")
    void getPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, Callback<Playlist> callback);


    @GET("/users/{user_id}/playlists/{playlist_id}")
    Playlist getPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId);


    @GET("/users/{user_id}/playlists/{playlist_id}/tracks")
    void getPlaylistTracks(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @QueryMap Map<String, Object> options, Callback<Pager<PlaylistTrack>> callback);


    @GET("/users/{user_id}/playlists/{playlist_id}/tracks")
    default Pager<PlaylistTrack> getPlaylistTracks(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @QueryMap Map<String, Object> options) {
        return null;
    }


    @GET("/users/{user_id}/playlists/{playlist_id}/tracks")
    void getPlaylistTracks(@Path("user_id") String userId, @Path("playlist_id") String playlistId, Callback<Pager<PlaylistTrack>> callback);


    @GET("/users/{user_id}/playlists/{playlist_id}/tracks")
    Pager<PlaylistTrack> getPlaylistTracks(@Path("user_id") String userId, @Path("playlist_id") String playlistId);


    @POST("/users/{user_id}/playlists")
    void createPlaylist(@Path("user_id") String userId, @Body Map<String, Object> body, Callback<Playlist> callback);


    @POST("/users/{user_id}/playlists")
    Playlist createPlaylist(@Path("user_id") String userId, @Body Map<String, Object> options);


    @POST("/users/{user_id}/playlists/{playlist_id}/tracks")
    SnapshotId addTracksToPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @QueryMap Map<String, Object> queryParameters, @Body Map<String, Object> body);


    @POST("/users/{user_id}/playlists/{playlist_id}/tracks")
    void addTracksToPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @QueryMap Map<String, Object> queryParameters, @Body Map<String, Object> body, Callback<Pager<PlaylistTrack>> callback);


    @DELETEWITHBODY("/users/{user_id}/playlists/{playlist_id}/tracks")
    void removeTracksFromPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body TracksToRemove tracksToRemove, Callback<SnapshotId> callback);


    @DELETEWITHBODY("/users/{user_id}/playlists/{playlist_id}/tracks")
    SnapshotId removeTracksFromPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body TracksToRemove tracksToRemove);


    @DELETEWITHBODY("/users/{user_id}/playlists/{playlist_id}/tracks")
    void removeTracksFromPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body TracksToRemoveWithPosition tracksToRemoveWithPosition, Callback<SnapshotId> callback);


    @DELETEWITHBODY("/users/{user_id}/playlists/{playlist_id}/tracks")
    SnapshotId removeTracksFromPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body TracksToRemoveWithPosition tracksToRemoveWithPosition);


    @PUT("/users/{user_id}/playlists/{playlist_id}/tracks")
    void replaceTracksInPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Query("uris") String trackUris, @Body Object body, Callback<Result> callback);


    @PUT("/users/{user_id}/playlists/{playlist_id}/tracks")
    Result replaceTracksInPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Query("uris") String trackUris, @Body Object body);


    @PUT("/users/{user_id}/playlists/{playlist_id}")
    Result changePlaylistDetails(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body Map<String, Object> body);


    @PUT("/users/{user_id}/playlists/{playlist_id}")
    void changePlaylistDetails(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body Map<String, Object> body, Callback<Result> callback);


    @PUT("/users/{user_id}/playlists/{playlist_id}/followers")
    void followPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, Callback<Result> callback);


    @PUT("/users/{user_id}/playlists/{playlist_id}/followers")
    Result followPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId);


    @PUT("/users/{user_id}/playlists/{playlist_id}/followers")
    void followPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body PlaylistFollowPrivacy playlistFollowPrivacy, Callback<Result> callback);


    @PUT("/users/{user_id}/playlists/{playlist_id}/followers")
    Result followPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body PlaylistFollowPrivacy playlistFollowPrivacy);


    @DELETE("/users/{user_id}/playlists/{playlist_id}/followers")
    void unfollowPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, Callback<Result> callback);


    @DELETE("/users/{user_id}/playlists/{playlist_id}/followers")
    Result unfollowPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId);


    @PUT("/users/{user_id}/playlists/{playlist_id}/tracks")
    SnapshotId reorderPlaylistTracks(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body Map<String, Object> body);


    @PUT("/users/{user_id}/playlists/{playlist_id}/tracks")
    void reorderPlaylistTracks(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Body Map<String, Object> body, Callback<SnapshotId> callback);


    @GET("/albums/{id}")
    void getAlbum(@Path("id") String albumId, Callback<Album> callback);


    @GET("/albums/{id}")
    Album getAlbum(@Path("id") String albumId);


    @GET("/albums/{id}")
    void getAlbum(@Path("id") String albumId, @QueryMap Map<String, Object> options, Callback<Album> callback);


    @GET("/albums/{id}")
    Album getAlbum(@Path("id") String albumId, @QueryMap Map<String, Object> options);


    @GET("/albums")
    void getAlbums(@Query("ids") String albumIds, Callback<Albums> callback);


    @GET("/albums")
    Albums getAlbums(@Query("ids") String albumIds);


    @GET("/albums")
    void getAlbums(@Query("ids") String albumIds, @QueryMap Map<String, Object> options, Callback<Albums> callback);


    @GET("/albums")
    Albums getAlbums(@Query("ids") String albumIds, @QueryMap Map<String, Object> options);


    @GET("/albums/{id}/tracks")
    Pager<Track> getAlbumTracks(@Path("id") String albumId);


    @GET("/albums/{id}/tracks")
    void getAlbumTracks(@Path("id") String albumId, Callback<Pager<Track>> callback);


    @GET("/albums/{id}/tracks")
    void getAlbumTracks(@Path("id") String albumId, @QueryMap Map<String, Object> options, Callback<Pager<Track>> callback);


    @GET("/albums/{id}/tracks")
    Pager<Track> getAlbumTracks(@Path("id") String albumId, @QueryMap Map<String, Object> options);


    @GET("/artists/{id}")
    void getArtist(@Path("id") String artistId, Callback<Artist> callback);


    @GET("/artists/{id}")
    Artist getArtist(@Path("id") String artistId);


    @GET("/artists")
    void getArtists(@Query("ids") String artistIds, Callback<Artists> callback);


    @GET("/artists")
    Artists getArtists(@Query("ids") String artistIds);


    @GET("/artists/{id}/albums")
    void getArtistAlbums(@Path("id") String artistId, Callback<Pager<Album>> callback);


    @GET("/artists/{id}/albums")
    Pager<Album> getArtistAlbums(@Path("id") String artistId);


    @GET("/artists/{id}/albums")
    void getArtistAlbums(@Path("id") String artistId, @QueryMap Map<String, Object> options, Callback<Pager<Album>> callback);


    @GET("/artists/{id}/albums")
    Pager<Album> getArtistAlbums(@Path("id") String artistId, @QueryMap Map<String, Object> options);


    @GET("/artists/{id}/top-tracks")
    void getArtistTopTrack(@Path("id") String artistId, @Query("country") String country, Callback<Tracks> callback);


    @GET("/artists/{id}/top-tracks")
    Tracks getArtistTopTrack(@Path("id") String artistId, @Query("country") String country);


    @GET("/artists/{id}/related-artists")
    void getRelatedArtists(@Path("id") String artistId, Callback<Artists> callback);


    @GET("/artists/{id}/related-artists")
    Artists getRelatedArtists(@Path("id") String artistId);


    @GET("/tracks/{id}")
    void getTrack(@Path("id") String trackId, Callback<Track> callback);


    @GET("/tracks/{id}")
    Track getTrack(@Path("id") String trackId);


    @GET("/tracks/{id}")
    void getTrack(@Path("id") String trackId, @QueryMap Map<String, Object> options, Callback<Track> callback);


    @GET("/tracks/{id}")
    Track getTrack(@Path("id") String trackId, @QueryMap Map<String, Object> options);


    @GET("/tracks")
    void getTracks(@Query("ids") String trackIds, Callback<Tracks> callback);


    @GET("/tracks")
    Tracks getTracks(@Query("ids") String trackIds);


    @GET("/tracks")
    void getTracks(@Query("ids") String trackIds, @QueryMap Map<String, Object> options, Callback<Tracks> callback);


    @GET("/tracks")
    Tracks getTracks(@Query("ids") String trackIds, @QueryMap Map<String, Object> options);


    @GET("/browse/featured-playlists")
    void getFeaturedPlaylists(Callback<FeaturedPlaylists> callback);


    @GET("/browse/featured-playlists")
    FeaturedPlaylists getFeaturedPlaylists();


    @GET("/browse/featured-playlists")
    void getFeaturedPlaylists(@QueryMap Map<String, Object> options, Callback<FeaturedPlaylists> callback);


    @GET("/browse/featured-playlists")
    FeaturedPlaylists getFeaturedPlaylists(@QueryMap Map<String, Object> options);


    @GET("/browse/new-releases")
    void getNewReleases(Callback<NewReleases> callback);


    @GET("/browse/new-releases")
    NewReleases getNewReleases();


    @GET("/browse/new-releases")
    void getNewReleases(@QueryMap Map<String, Object> options, Callback<NewReleases> callback);


    @GET("/browse/new-releases")
    NewReleases getNewReleases(@QueryMap Map<String, Object> options);


    @GET("/browse/categories")
    void getCategories(@QueryMap Map<String, Object> options, Callback<CategoriesPager> callback);


    @GET("/browse/categories")
    CategoriesPager getCategories(@QueryMap Map<String, Object> options);


    @GET("/browse/categories/{category_id}")
    void getCategory(@Path("category_id") String categoryId, @QueryMap Map<String, Object> options, Callback<Category> callback);


    @GET("/browse/categories/{category_id}")
    Category getCategory(@Path("category_id") String categoryId, @QueryMap Map<String, Object> options);


    @GET("/browse/categories/{category_id}/playlists")
    void getPlaylistsForCategory(@Path("category_id") String categoryId, @QueryMap Map<String, Object> options, Callback<PlaylistsPager> callback);


    @GET("/browse/categories/{category_id}/playlists")
    PlaylistsPager getPlaylistsForCategory(@Path("category_id") String categoryId, @QueryMap Map<String, Object> options);


    @GET("/me/tracks")
    void getCurrentUserSavedTracks(Callback<Pager<SavedTrack>> callback);


    @GET("/me/tracks")
    Pager<SavedTrack> getCurrentUserSavedTracks();


    @GET("/me/tracks")
    void getCurrentUserSavedTracks(@QueryMap Map<String, Object> options, Callback<Pager<SavedTrack>> callback);


    @GET("/me/tracks")
    Pager<SavedTrack> getCurrentUserSavedTracks(@QueryMap Map<String, Object> options);


    @GET("/me/tracks/contains")
    void containsCurrentUserSavedTracks(@Query("ids") String ids, Callback<boolean[]> callback);


    @GET("/me/tracks/contains")
    Boolean[] containsCurrentUserSavedTracks(@Query("ids") String ids);


    @PUT("/me/tracks")
    void addToCurrentUserSavedTracks(@Query("ids") String ids, Callback<Object> callback);


    @PUT("/me/tracks")
    Result addToCurrentUserSavedTracks(@Query("ids") String ids);


    @DELETE("/me/tracks")
    void removeFromCurrentUserSavedTracks(@Query("ids") String ids, Callback<Object> callback);


    @DELETE("/me/tracks")
    Result removeFromCurrentUserSavedTracks(@Query("ids") String ids);


    @GET("/me/albums")
    void getCurrentUserSavedAlbums(Callback<Pager<SavedAlbum>> callback);


    @GET("/me/albums")
    Pager<SavedAlbum> getCurrentUserSavedAlbums();


    @GET("/me/albums")
    void getCurrentUserSavedAlbums(@QueryMap Map<String, Object> options, Callback<Pager<SavedAlbum>> callback);


    @GET("/me/albums")
    Pager<SavedAlbum> getCurrentUserSavedAlbums(@QueryMap Map<String, Object> options);


    @GET("/me/albums/contains")
    void containsCurrentUserSavedAlbums(@Query("ids") String ids, Callback<boolean[]> callback);


    @GET("/me/albums/contains")
    Boolean[] containsCurrentUserSavedAlbums(@Query("ids") String ids);


    @PUT("/me/albums")
    void addToCurrentUserSavedAlbums(@Query("ids") String ids, Callback<Object> callback);


    @PUT("/me/albums")
    Result addToCurrentUserSavedAlbums(@Query("ids") String ids);


    @DELETE("/me/albums")
    void removeFromCurrentUserSavedAlbums(@Query("ids") String ids, Callback<Object> callback);


    @DELETE("/me/albums")
    Result removeFromCurrentUserSavedAlbums(@Query("ids") String ids);


    @PUT("/me/following?type=user")
    void followUsers(@Query("ids") String ids, Callback<Object> callback);


    @PUT("/me/following?type=user")
    Result followUsers(@Query("ids") String ids);


    @PUT("/me/following?type=artist")
    void followArtists(@Query("ids") String ids, Callback<Object> callback);


    @PUT("/me/following?type=artist")
    Result followArtists(@Query("ids") String ids);


    @DELETE("/me/following?type=user")
    void unfollowUsers(@Query("ids") String ids, Callback<Object> callback);


    @DELETE("/me/following?type=user")
    Result unfollowUsers(@Query("ids") String ids);


    @DELETE("/me/following?type=artist")
    void unfollowArtists(@Query("ids") String ids, Callback<Object> callback);


    @DELETE("/me/following?type=artist")
    Result unfollowArtists(@Query("ids") String ids);


    @GET("/me/following/contains?type=user")
    void isFollowingUsers(@Query("ids") String ids, Callback<boolean[]> callback);


    @GET("/me/following/contains?type=user")
    Boolean[] isFollowingUsers(@Query("ids") String ids);


    @GET("/me/following/contains?type=artist")
    void isFollowingArtists(@Query("ids") String ids, Callback<boolean[]> callback);


    @GET("/me/following/contains?type=artist")
    Boolean[] isFollowingArtists(@Query("ids") String ids);


    @GET("/users/{user_id}/playlists/{playlist_id}/followers/contains")
    Boolean[] areFollowingPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Query("ids") String ids);


    @GET("/users/{user_id}/playlists/{playlist_id}/followers/contains")
    void areFollowingPlaylist(@Path("user_id") String userId, @Path("playlist_id") String playlistId, @Query("ids") String ids, Callback<boolean[]> callback);


    @GET("/me/following?type=artist")
    ArtistsCursorPager getFollowedArtists();


    @GET("/me/following?type=artist")
    void getFollowedArtists(Callback<ArtistsCursorPager> callback);


    @GET("/me/following?type=artist")
    ArtistsCursorPager getFollowedArtists(@QueryMap Map<String, Object> options);


    @GET("/me/following?type=artist")
    void getFollowedArtists(@QueryMap Map<String, Object> options, Callback<ArtistsCursorPager> callback);


    @GET("/search?type=track")
    void searchTracks(@Query("q") String q, Callback<TracksPager> callback);


    @GET("/search?type=track")
    TracksPager searchTracks(@Query("q") String q);


    @GET("/search?type=track")
    void searchTracks(@Query("q") String q, @QueryMap Map<String, Object> options, Callback<TracksPager> callback);


    @GET("/search?type=track")
    TracksPager searchTracks(@Query("q") String q, @QueryMap Map<String, Object> options);


    @GET("/search?type=artist")
    void searchArtists(@Query("q") String q, Callback<ArtistsPager> callback);


    @GET("/search?type=artist")
    ArtistsPager searchArtists(@Query("q") String q);


    @GET("/search?type=artist")
    void searchArtists(@Query("q") String q, @QueryMap Map<String, Object> options, Callback<ArtistsPager> callback);


    @GET("/search?type=artist")
    ArtistsPager searchArtists(@Query("q") String q, @QueryMap Map<String, Object> options);


    @GET("/search?type=album")
    void searchAlbums(@Query("q") String q, Callback<AlbumsPager> callback);


    @GET("/search?type=album")
    AlbumsPager searchAlbums(@Query("q") String q);


    @GET("/search?type=album")
    void searchAlbums(@Query("q") String q, @QueryMap Map<String, Object> options, Callback<AlbumsPager> callback);


    @GET("/search?type=album")
    AlbumsPager searchAlbums(@Query("q") String q, @QueryMap Map<String, Object> options);


    @GET("/search?type=playlist")
    void searchPlaylists(@Query("q") String q, Callback<PlaylistsPager> callback);


    @GET("/search?type=playlist")
    PlaylistsPager searchPlaylists(@Query("q") String q);


    @GET("/search?type=playlist")
    void searchPlaylists(@Query("q") String q, @QueryMap Map<String, Object> options, Callback<PlaylistsPager> callback);


    @GET("/search?type=playlist")
    PlaylistsPager searchPlaylists(@Query("q") String q, @QueryMap Map<String, Object> options);


    @GET("/audio-features")
    void getTracksAudioFeatures(@Query("ids") String ids, Callback<AudioFeaturesTracks> callback);


    @GET("/audio-features")
    AudioFeaturesTracks getTracksAudioFeatures(@Query("ids") String ids);


    @GET("/audio-features/{id}")
    void getTrackAudioFeatures(@Path("id") String id, Callback<AudioFeaturesTrack> callback);


    @GET("/audio-features/{id}")
    AudioFeaturesTrack getTrackAudioFeatures(@Path("id") String id);


    @GET("/recommendations")
    Recommendations getRecommendations(@QueryMap Map<String, Object> options);


    @GET("/recommendations")
    void getRecommendations(@QueryMap Map<String, Object> options, Callback<Recommendations> callback);


    @GET("/recommendations/available-genre-seeds")
    SeedsGenres getSeedsGenres();


    @GET("/recommendations/available-genre-seeds")
    void getSeedsGenres(Callback<SeedsGenres> callback);


    @GET("/me/top/artists")
    Pager<Artist> getTopArtists();


    @GET("/me/top/artists")
    void getTopArtists(Callback<Pager<Artist>> callback);


    @GET("/me/top/artists")
    Pager<Artist> getTopArtists(@QueryMap Map<String, Object> options);


    @GET("/me/top/artists")
    void getTopArtists(@QueryMap Map<String, Object> options, Callback<Pager<Artist>> callback);


    @GET("/me/top/tracks")
    Pager<Track> getTopTracks();


    @GET("/me/top/tracks")
    void getTopTracks(Callback<Pager<Track>> callback);


    @GET("/me/top/tracks")
    Pager<Track> getTopTracks(@QueryMap Map<String, Object> options);


    @GET("/me/top/tracks")
    void getTopTracks(@QueryMap Map<String, Object> options, Callback<Pager<Track>> callback);

    @GET("/me/player/recently-played")
    Pager<RecentlyPlayedTrack> getRecentlyPlayedTracks (@QueryMap Map<String, Object> options);

    @GET("/me/player/recently-played")
    void getRecentlyPlayedTracks (@QueryMap Map<String, Object> options, Callback<Pager<RecentlyPlayedTrack>> callback);
}