package com.gemini.in_class5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/*
THIS SAVED MY LIFE
 */

public class AppAdapter extends ArrayAdapter {

  private final Activity context;
  List<DataServices.App> AppSList;

  public AppAdapter(Activity context, List<DataServices.App> AppSList) {
    super(context, R.layout.app_list_layout);
    super.addAll(AppSList);


    this.context = context;
    this.AppSList = AppSList;
  }

  public View getView(int position, View view, ViewGroup parent) {
    LayoutInflater inflater = context.getLayoutInflater();
    View rowView = inflater.inflate(R.layout.fragment_app_list, parent, false);
    // SETTING UP THE ELEMENTS
    TextView Name = rowView.findViewById(R.id.app_name_value);
    TextView Artist = rowView.findViewById(R.id.app_artist_name_value);
    TextView ReleaseDate = rowView.findViewById(R.id.app_release_date_value);
    AppSList.get(position);
    Name.setText(AppSList.get(position).name);
    Artist.setText(AppSList.get(position).artistName);
    ReleaseDate.setText(AppSList.get(position).releaseDate);
    return rowView;
  }
}
