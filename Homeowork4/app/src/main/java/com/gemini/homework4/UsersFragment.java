package com.gemini.homework4;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gemini.homework4.databinding.*;

import java.util.ArrayList;
import java.util.Comparator;

public class UsersFragment extends Fragment {

    private UsersFragmentBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = UsersFragmentBinding.inflate(inflater, container, false);



        return binding.getRoot();



    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      if (getActivity() != null) {
        getActivity().setTitle("Users");
      }

      Log.d("LOG", "onViewCreated: Welcome to the UsersFragment");



      ArrayList<DataServices.User> users = mListener.onGetUsers();

      ListView listView = view.findViewById(R.id.Users_RecyclerView);

      UserAdapter adapter = new UserAdapter(this.getContext(), R.layout.users_template_layout,users);

      listView.setAdapter(adapter);






      // Get a reference to the ViewModel for this fragment.



        // TODO: Action when sort by name button is clicked
        binding.SortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mListener.onSortButtonClicked();
            }
        });






      // TODO: Action when Filter button is clicked
        binding.FilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mListener.onFilterButtonClicked();
            }
        });





    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    onUsersFragmentListener mListener;

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);


    try {
      mListener = (onUsersFragmentListener) context;

    } catch (ClassCastException e) {
      throw new ClassCastException(context.toString() + " must implement onAppListFragmentListener");
    }
  }

  interface onUsersFragmentListener {
    void onSortButtonClicked();
    void onFilterButtonClicked();
    ArrayList<DataServices.User> onGetUsers();
  }
}
