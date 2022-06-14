package com.gemini.practice;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ListViewFragment extends Fragment {
  final static String TAG = "ListViewFragment";

  Button button_submit;
  TextView textView_output;
  EditText url_input;
  RecyclerView recyclerView;
  Adapter adapter;
  TextView TextView_Output;
  onUserSelectedListener mListener;
ArrayList<String> Responseslist = new ArrayList<>();
  public ListViewFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_list_view, container, false);
    // binding my list view object to the xml file
    TextView_Output = view.findViewById(R.id.textView_Output);

    url_input = view.findViewById(R.id.textView_url_input);
    button_submit = view.findViewById(R.id.button_submit);


    button_submit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String url = url_input.getText().toString();

        mListener.onMakeRequest(url);
      }
    });
    return view;
  }




  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    if (context instanceof onUserSelectedListener) {
      mListener = (onUserSelectedListener) context;
    } else {
      throw new RuntimeException(context.toString()
        + " must implement OnFragmentInteractionListener");
    }
  }

  interface onUserSelectedListener {
    void   setTextViewOutput();
    void onMakeRequest(String url);
    ArrayList<String> getListofRequests();
  }
}
