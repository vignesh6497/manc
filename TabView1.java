package com.example.xenderx.jsonvolley;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static com.example.xenderx.jsonvolley.ParseJSON.description;
import static com.example.xenderx.jsonvolley.ParseJSON.title;
import static com.example.xenderx.jsonvolley.ParseJSON.url;
import static com.example.xenderx.jsonvolley.ParseJSON.urlToImage;

/**
 * Created by vignesh on 09-Nov-16.
 */

public class TabView1 extends Fragment {

    private ListView listView1;
    public static final String JSON_URL = "https://newsapi.org/v1/articles?source=the-times-of-india&sortBy=latest&apiKey=08e331f30a134116b033aa419878ca63";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1,container,false);
        listView1 = (ListView) view.findViewById(R.id.listView1);
        sendRequest(JSON_URL);
        addClickListner();

        return view;

    }
    private void sendRequest(String url){

        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }
    private void showJSON(String json){
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();

        if(getActivity() != null) {
            CustomList cl = new CustomList(getActivity(), title, description, urlToImage);
            listView1.setAdapter(cl);
        }

    }
    private void addClickListner() {
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url[position]));
                startActivity(i);
            }
        });
    }
}
