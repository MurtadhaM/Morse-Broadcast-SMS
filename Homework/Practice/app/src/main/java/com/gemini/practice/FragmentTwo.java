package com.gemini.practice;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class FragmentTwo extends Fragment {
  public int Color = 0;

  public boolean isEnabled = false;
  public void setEnabled(boolean enabled) {
    isEnabled = enabled;
  }
  public boolean isEnabledSwitch()
  {
    return isEnabled;
  }
final String TAG = "FragmentTwo";
    public FragmentTwo() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
  public  void updateColor(int color) {
    if (getView() != null) {
      getView().setBackgroundColor(color);
    }
  }
  SwitchMaterial switchMaterial;
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view =  inflater.inflate(R.layout.fragment_second, container, false);
    switchMaterial = view.findViewById(R.id.Second_Fragment_Switch);
    switchMaterial.setOnCheckedChangeListener((buttonView, isChecked) -> {
        setEnabled(isChecked);

      }
    );

    return view;
  }
}
