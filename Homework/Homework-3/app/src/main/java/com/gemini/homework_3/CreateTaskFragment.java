package com.gemini.homework_3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.gemini.homework_3.databinding.CreatetaskfragmentlayoutBinding;
import com.gemini.homework_3.databinding.ActivityMainBinding;
import com.gemini.homework_3.databinding.ListItemTaskBinding;



public class CreateTaskFragment extends Fragment {

  public static final Object RESULT_KEY = "result";
  private CreatetaskfragmentlayoutBinding binding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {


        binding = CreatetaskfragmentlayoutBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


      Button buttonCreateTaskSubmitButton = binding.buttonCreateTaskSubmitButton;
      buttonCreateTaskSubmitButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          FragmentManager fragmentManager = getFragmentManager();
          fragmentManager.popBackStack();


        }
      });

      Button SelectDateButton = binding.buttonSelectDate;
      SelectDateButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          FragmentManager fragmentManager = getFragmentManager();
          fragmentManager.beginTransaction()
                  .replace(R.id.fragmentContainerView, new SelectDateFragment())
                  .addToBackStack(null)
                  .commit();

        }
      });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

  public void show(FragmentManager fragmentManager) {
      fragmentManager.beginTransaction()
              .replace(R.id.fragmentContainerView, this)
              .addToBackStack(null)
              .commit();
  }




  }

//

