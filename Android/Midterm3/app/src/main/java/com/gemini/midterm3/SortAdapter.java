package com.gemini.midterm3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SortAdapter extends RecyclerView.Adapter<SortAdapter.ViewHolder> {

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    ViewHolder vh =  new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_buttons, parent, false));


    return vh;


  }

  @Override
  public void onBindViewHolder(@NonNull SortAdapter.ViewHolder holder, int position) {

  }

  public int getItemCount() {
    return 0;
  }


  static class ViewHolder extends RecyclerView.ViewHolder {
    Button mButtonSort;

    public ViewHolder(View itemView) {
      super(itemView);
      this.mButtonSort = itemView.findViewById(R.id.button_sort);
    }
  }
}
