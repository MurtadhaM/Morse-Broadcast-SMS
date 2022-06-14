package com.gemini.homework4;

import static android.content.ContentValues.TAG;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


public class SortAdapter extends RecyclerView.Adapter<SortAdapter.ViewHolder> {
  private final Sorter[] RowDataForSor;

  ISorterRecyclerViewListener mListener;
  // RecyclerView recyclerView;
  public SortAdapter(Sorter[] listdata, ISorterRecyclerViewListener listener) {
    this.mListener = listener;
    this.RowDataForSor = listdata;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View listItem = layoutInflater.inflate(R.layout.sort_row_layout, parent, false);
    return new ViewHolder(listItem, mListener);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final Sorter myListData = RowDataForSor[position];
    holder.textViewSortLabel.setText(RowDataForSor[position].getSortLabel());
    holder.imageViewASCENDING.setImageResource(RowDataForSor[position].getImageASC());
    holder.imageViewDESCENDING.setImageResource(RowDataForSor[position].getImageDESC());
// Setting The Variables


    holder.imageViewASCENDING.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {



        mListener.onSelectedSortRecyclerMethod(myListData.getSortLabel(), "ASC");
      }
    });
    holder.imageViewDESCENDING.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mListener.onSelectedSortRecyclerMethod(myListData.getSortLabel(), "DESC");
      }
    });


  }

  @Override
  public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
  }

  @Override
  public int getItemCount() {
    return RowDataForSor.length;
  }




  public static class ViewHolder extends RecyclerView.ViewHolder implements SortFragment.onSortFragmentListener {
    public ImageView imageViewASCENDING;
    public ImageView imageViewDESCENDING;
    public TextView textViewSortLabel;
    public ConstraintLayout relativeLayout;
    public ISorterRecyclerViewListener mlistener;
    public ViewHolder(View itemView, ISorterRecyclerViewListener listener) {
      super(itemView);
      this.mlistener = listener;
      this.imageViewASCENDING = (ImageView) itemView.findViewById(R.id.imageView_ascending);
      this.imageViewDESCENDING = (ImageView) itemView.findViewById(R.id.imageView_descending);
      this.textViewSortLabel = (TextView) itemView.findViewById(R.id.textView_sort_label);
    }


    @Override
    public void onSetSortMethodListener(String sortMethod, String sortOrder) {
      mlistener.onSelectedSortRecyclerMethod(sortMethod, sortOrder);
    }

    @Override
    public Sorter[] getSortList() {
      return new Sorter[0];
    }
  }

  interface ISorterRecyclerViewListener {
    void onSelectedSortRecyclerMethod(String sortMethod, String sortOrder);
  }


}  
