package com.gemini.hw3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gemini.hw3.databinding.FragmentDialogBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DialogFragment extends Fragment    {

    private  static int num;
    private static int len;
    private static  ArrayList<String> passwords = new ArrayList<>();


    public DialogFragment() {
    }
    public static ArrayList<String> newInstance(int numberofPasswords, int lengthofPasswords) {
        DialogFragment fragment = new DialogFragment();
        num =  numberofPasswords;
        len = lengthofPasswords;


        Bundle args = new Bundle();
        return passwords;
    }


    public  void updateView(int count) {

      if(this.getView() != null) {
        TextView textView = (TextView) this.getView().findViewById(R.id.password_count);
        textView.setText(count);
      }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      {



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }
}
