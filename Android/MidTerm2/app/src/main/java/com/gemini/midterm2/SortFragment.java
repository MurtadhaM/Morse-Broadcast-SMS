package com.gemini.midterm2;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gemini.midterm2.databinding.SortFragmentViewBinding;

import java.util.Comparator;

public class SortFragment extends Fragment {

    private SortFragmentViewBinding binding;
    public static SortFragment newInstance() {
        return new SortFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_sort, container, false);

        binding = SortFragmentViewBinding.bind(view);
      Button sortByName = view.findViewById(R.id.sortByNameButton);

      sortByName.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Comparator<User> sorterByName = new Comparator<User>() {

                @Override
                public int compare(User o1, User o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            };

            mListener.onSortByName(sorterByName);
          }
      });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    onSortFragmentListener mListener;
  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    try {
      mListener = (onSortFragmentListener) context;
    } catch (ClassCastException e) {
      throw new ClassCastException(context.toString()
          + " must implement OnHeadlineSelectedListener");
    }
    onSortFragmentListener mListener = (onSortFragmentListener) context;

  }



  interface onSortFragmentListener{
        void onSortByName(Comparator<User> comparator);

    }

}
