package com.gemini.midterm2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.gemini.midterm2.databinding.ActivityMainBinding;
import com.gemini.midterm2.databinding.FilterFragmentLayoutBinding;

public class FilterFragment extends Fragment {

    private FilterFragmentLayoutBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {



      View view = inflater.inflate(R.layout.filter_fragment_layout, container, false);
      binding = FilterFragmentLayoutBinding.inflate(inflater, container, false);
      return view;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
