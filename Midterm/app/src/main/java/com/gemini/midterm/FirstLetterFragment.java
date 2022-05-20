package com.gemini.midterm;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gemini.midterm.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
public class FirstLetterFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FirstLetterFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FirstLetterFragment newInstance(int columnCount) {
        FirstLetterFragment fragment = new FirstLetterFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_letter_fragment_layout, container, false);
        View view2 = inflater.inflate(R.layout.fragment_user_list, container, false);


      // Set the adapter
        if (view.findViewById(R.id.button_list) instanceof RecyclerView) {
            Context context = getContext();
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.button_list);
          LinearLayoutManager layoutManager
            = new LinearLayoutManager(requireContext(),   LinearLayoutManager.HORIZONTAL , false);

            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager( layoutManager);
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyFirstLetterRecyclerViewAdapter(PlaceholderContent.ITEMS));
        }
        return view;
    }
}
