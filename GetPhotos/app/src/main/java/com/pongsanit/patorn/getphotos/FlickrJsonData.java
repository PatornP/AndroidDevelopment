package com.pongsanit.patorn.getphotos;

import android.net.Uri;
import android.util.Log;

import org.json.JSONException;

import java.util.List;

/**
 * Created by Patorn on 7/30/16.
 */
public class FlickrJsonData extends GetRawData{
    private String LOG_TAG = GetRawData.class.getSimpleName();
    private List<Photo> mPhotos;
    private Uri mDestinationUri;

    public FlickrJsonData(String searchCriteria, boolean matchAll){
        super(null);
        createAndUpdateUri(searchCriteria, matchAll);
    }
    //Uri = uniform resource indentifier;
    //creating the specified URL to pull the correct json data in from FLICKR.
    public boolean createAndUpdateUri(String searchCriteria, boolean matchAll){
        final String FLICKR_API_BASE_URL = "https://api.flickr.com/services/feeds/photos_public.gne";
        final String TAGMODE_PARAM = "tagmode";
        final String FORMAT_PARAM = "format";
        final String TAGS_PARAM = "tags";
        final String NO_JSON_CALLBACK_PARAM = "nojsoncallback";

        mDestinationUri = Uri.parse(FLICKR_API_BASE_URL).buildUpon().appendQueryParameter(TAGS_PARAM, searchCriteria)
                                                                    .appendQueryParameter(TAGMODE_PARAM, matchAll ? "ALL" : "ANY")
                                                                    .appendQueryParameter(FORMAT_PARAM, "json")
                                                                    .appendQueryParameter(NO_JSON_CALLBACK_PARAM, "1").build();
        return mDestinationUri != null;
    }

    public void processResult() {
        if(getmDownloadStatus() != DownloadStatus.OK){
            Log.e(LOG_TAG, "Error downloading file");
        }
        final String FLICKR_ITEMS = "items";
        final String FLICKR_TITLE = "title";
        final String FLICKR_MEDIA = "media";
        final String FLICKR_PHOTO_URL = "m";
        final String FLICKR_AUTHOR = "author";
        final String FLICK_AUTHOR_ID ="author_id";
        final String FLICKR_LINK = "link";
        final String FLICKR_TAGS = "tags";

        try {

        } catch(JSONException e) {
            e.printStackTrace();
            Log.e(LOG_TAG, "Error processing json Data");

        }
    }
    public class DownloadJsonData  extends DownloadRawData {
        protected void onPostExecute(String webData){
            super.onPostExecute(webData);
            processResult();
        }

        protected String doInBackground(String... params) {
            return super.doInBackground(params);
        }

    }
}
