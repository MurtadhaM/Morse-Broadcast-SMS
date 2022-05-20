package com.gemini.midterm;

import androidx.recyclerview.widget.RecyclerView;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gemini.midterm.placeholder.PlaceholderContent.PlaceholderItem;
import com.gemini.midterm.databinding.FirstLetterFragmentItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyFirstLetterRecyclerViewAdapter extends RecyclerView.Adapter<MyFirstLetterRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderItem> mValues;

    public MyFirstLetterRecyclerViewAdapter(List<PlaceholderItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FirstLetterFragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
      // The button text
        holder.mIdView.setText(mValues.get(position).id);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final Button mIdView;
        public PlaceholderItem mItem;

        public ViewHolder(FirstLetterFragmentItemBinding binding) {
            super(binding.getRoot());
            mIdView = binding.FirstLetterFilterButton;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mIdView.getText() + "'";
        }
    }
}
