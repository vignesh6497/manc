package com.example.xenderx.jsonvolley;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by vignesh on 09-Nov-16.
 */

public class Tab1 extends Fragment {
    private View view;
    private ListView listView1;
    private ArrayList<HashMap<String,String>> tab1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        if(view == null){
            view = inflater.inflate(R.layout.tab1,container,false);
        }
        else
        {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }

    /*    if(cursor.moveToFirst())
        {
            while (cursor.moveToNext()){
            }
        }*/

        return inflater.inflate(R.layout.tab1,container,false);



    }

}
