package com.gemini.httpok;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ContactsFragment extends Fragment {

  RecyclerView MyListClickable;
  Button button_Delete_Selected,buttonCancelSelection;


    public ContactsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_contacts, container, false);

      MyListClickable = view.findViewById(R.id.RecycleViewList);
      buttonCancelSelection = view.findViewById(R.id.buttonCancelSelection);
      button_Delete_Selected = view.findViewById(R.id.buttonDeleteSelected);


      button_Delete_Selected.setOnClickListener(v -> {
         mlistener.onGetMeTheContacts();

      }
      );



      return view;
    }


  OnContactSelectedListener mlistener;

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    mlistener = (OnContactSelectedListener) context;
  }

  interface OnContactSelectedListener {
    void onGetMeTheContacts();
  }
}
