package com.example.xenderx.jsonvolley;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by vignesh on 05-Nov-16.
 */

public class CustomList extends ArrayAdapter<String> {
    private String[] title;
    private String[] description;
    private String[] urlToImage;
    //private String[] url;
    private Activity context;

    public CustomList(Activity context, String[] title, String[] description, String[] urlToImage){

        super(context, R.layout.list_view_layout, title);
        this.context = context;
        this.title = title;
        this.description = description;
        this.urlToImage = urlToImage;
        //this.url  = url;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_layout,null,true);
        TextView textViewTitle = (TextView) listViewItem.findViewById(R.id.title);
        TextView textViewDescription = (TextView) listViewItem.findViewById(R.id.description);
        ImageView myImageView  = (ImageView) listViewItem.findViewById(R.id.imageView) ;

        textViewTitle.setText(title[position]);
        textViewDescription.setText(description[position]);

        Picasso.with(getContext()).load(urlToImage[position]).fit().into(myImageView);

        return listViewItem;
    }
    public void onClick(){
        Toast.makeText(this.context,"Pressed!", Toast.LENGTH_LONG).show();
    }
}
