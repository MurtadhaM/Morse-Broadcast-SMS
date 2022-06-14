package com.gemini.midterm3;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder> {


  @NonNull
  @Override
  public FilterAdapter.FilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull FilterAdapter.FilterViewHolder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return 0;
  }

  private class ViewHolder {
  }

  public class FilterViewHolder extends RecyclerView.ViewHolder {
    public FilterViewHolder(@NonNull View itemView) {
      super(itemView);
    }
  }
}




