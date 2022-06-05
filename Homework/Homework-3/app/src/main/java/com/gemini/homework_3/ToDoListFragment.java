package com.gemini.homework_3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ToDoListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToDoListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ToDoListFragment() {
        // Required empty public constructor
    }
    public static ToDoListFragment newInstance(String param1, String param2) {
        ToDoListFragment fragment = new ToDoListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    Button  buttonCreateTaskSubmitButton;

  public static Fragment newInstance() {
    return new ToDoListFragment();

  }

  @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_to_do_list, container, false);
      buttonCreateTaskSubmitButton = v.findViewById(R.id.button_add_task);
      buttonCreateTaskSubmitButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          Toast.makeText(getContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
          FragmentManager fragmentManager = getFragmentManager();
          fragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, new CreateTaskFragment())
            .addToBackStack(null)
            .commit();


        }
      });


        return v;

    }


}
