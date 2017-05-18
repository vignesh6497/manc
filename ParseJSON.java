package com.example.xenderx.jsonvolley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by vignesh on 06-Nov-16.
 */

public class ParseJSON {
    public static String[] title;
    public static String[] description;
    public static String[] url;
    public static String[] urlToImage;


    public final static String JSON_ARRAY = "articles";
    public final static String KEY_TITLE = "title";
    public final static String KEY_DESCRIPTION = "description";
    public final static String KEY_URL = "url";
    public final static String KEY_IMAGE = "urlToImage";

    public JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            title = new String[users.length()];
            description = new String[users.length()];
            url = new String[users.length()];
            urlToImage = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                title[i] = jo.getString(KEY_TITLE);
                description[i] = jo.getString(KEY_DESCRIPTION);
                url[i] = jo.getString(KEY_URL);
                urlToImage[i] = jo.getString(KEY_IMAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
