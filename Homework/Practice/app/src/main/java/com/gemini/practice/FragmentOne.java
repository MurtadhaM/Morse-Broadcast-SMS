package com.gemini.practice;

import android.nfc.Tag;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class FragmentOne extends Fragment {
   final String TAG = "FragmentOne";

  public int Color = 0;
SwitchMaterial switchMaterial;
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view =  inflater.inflate(R.layout.fragment_first, container, false);
    switchMaterial = view.findViewById(R.id.First_Fragment_Switch);
    switchMaterial.setOnCheckedChangeListener((buttonView, isChecked) -> {
        setEnabled(isChecked);

      }
    );

    return view;
  }

  public boolean isEnabled = false;
  public void setEnabled(boolean enabled) {
    isEnabled = enabled;
  }
  public boolean isEnabledSwitch()
  {
    return isEnabled;
  }

  public  void updateColor(int color) {
    if (getView() != null) {
      getView().setBackgroundColor(color);
    }
  }


    public FragmentOne() {
    }

    public FragmentOne(int color) {
        this.Color = color;
    }

  public static FragmentOne newInstance(int color , String tag) {


    return new FragmentOne(color);

  }
    @Override
    public void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);

    }


}
