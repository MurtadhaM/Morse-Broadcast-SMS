package com.gemini.homework_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import com.gemini.homework_3.databinding.DisplayTaskFragmentLayoutBinding;
import com.gemini.homework_3.databinding.ActivityMainBinding;
import com.gemini.homework_3.databinding.CreatetaskfragmentlayoutBinding;
import com.gemini.homework_3.databinding.ListItemTaskBinding;
public class DisplayTaskFragment extends Fragment {
  private CreatetaskfragmentlayoutBinding binding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View v = inflater.inflate(R.layout.display_task_fragment_layout, container, false);

        return v  ;

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.buttonCreateTaskSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              FragmentManager fragmentManager = getFragmentManager();
              fragmentManager.popBackStack();



            }
        });








    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
