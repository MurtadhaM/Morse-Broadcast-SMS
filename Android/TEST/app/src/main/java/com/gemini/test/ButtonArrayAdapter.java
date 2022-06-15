package com.gemini.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ButtonArrayAdapter extends RecyclerView.Adapter<ButtonArrayAdapter.ViewHolder> {

    private ArrayList<String> mData;

  public ButtonArrayAdapter(ArrayList<String> data) {
        mData = data;
    }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row_layout, parent, false);
  return new ViewHolder(viewHolder);}

  @Override
  public void onBindViewHolder(@NonNull ButtonArrayAdapter.ViewHolder holder, int position) {
    holder.mButtonRowButton.setText(mData.get(position));

  }

  public int getItemCount() {
    return mData.size();
  }


  static class ViewHolder extends RecyclerView.ViewHolder {
    Button mButtonRowButton;

    public ViewHolder(View itemView) {
      super(itemView);
      this.mButtonRowButton = itemView.findViewById(R.id.button_row_button);
    }
  }
}
