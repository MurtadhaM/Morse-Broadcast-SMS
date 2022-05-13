/*
  Author: Murtadha Marzouq
  Assignment: HW1
 */
package com.gemini.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.text.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {


  private int weight;
  private double gender = 0.55;
  private double bac = 0.0;
  private int saved = 0, added = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ((SeekBar) findViewById(R.id.seekAlcoholPercent)).setOnSeekBarChangeListener(this);


  }

  public boolean setError() {
    EditText a = (EditText) findViewById(R.id.txtEditWeight);

    if (TextUtils.isEmpty(a.getText())) {
      Toast.makeText(this, "Weight in Pounds.", Toast.LENGTH_SHORT).show();
      return false;
    } else if (!(Integer.parseInt(a.getText() + "") > 0)) {
      Toast.makeText(this, "Cannot be 0.", Toast.LENGTH_SHORT).show();
      ((EditText) findViewById(R.id.txtEditWeight)).setText("");
      return false;
    }
    return true;
  }


  public void onSaveButtonClick(View v) {

    EditText a = (EditText) findViewById(R.id.txtEditWeight);
    Switch x = (Switch) findViewById(R.id.switchChooseGender);
    double A = bac * weight * gender / 6.24;


    if (setError()) {
      weight = Integer.parseInt(a.getText() + "");
      gender = x.isChecked() ? 0.68 : 0.55;

      ((EditText) findViewById(R.id.txtEditWeight)).setText("" + weight);
      saved++;
    }

    if (added >= 1)
      calculateBAC(A);

  }

  public void onAddDrinkButtonClick(View v) {


    if (saved < 1) {
      Toast.makeText(this, "Save before proceeding ", Toast.LENGTH_SHORT).show();
    } else if (setError() && weight > 0) {

      calculateBAC();

    }

    int x = ((ProgressBar) findViewById(R.id.pbBACLevel)).getProgress();
    String output = x < 8 ? "You\'re safe & allowed to order more" : x < 20 ? "Slow down..." :  x <25 ?   "Last Warning!"  : "Over the limit!";
    int progressColor = x < 8 ? Color.GREEN : x < 20 ? Color.YELLOW : x < 25 ? 0XFFF44336 : Color.RED;

    ((ProgressBar) findViewById(R.id.pbBACLevel)).setBackgroundColor(progressColor);

    ((TextView) findViewById(R.id.txtResultStatus)).setText("" + output);

  }

  public void calculateBAC() {
    int ounces;
    int percent;


    RadioGroup rg = (RadioGroup) findViewById(R.id.radGroupDrinkSize);
    if (rg.getCheckedRadioButtonId() == R.id.radOne) {
      ounces = 1;
    } else if (rg.getCheckedRadioButtonId() == R.id.radFive) {
      ounces = 5;
    } else {
      ounces = 12;
    }


    SeekBar sb = (SeekBar) findViewById(R.id.seekAlcoholPercent);
    percent = sb.getProgress();


    double currentBAC = (((ounces * percent) * 6.24) / (weight * gender)) / 100;


    bac += currentBAC;


    NumberFormat numberFormat = new DecimalFormat("0.##");
    ((TextView) findViewById(R.id.txtBACLevel)).setText("BAC Level: " + numberFormat.format(bac));


    ((ProgressBar) findViewById(R.id.pbBACLevel)).setProgress((int) Math.round(bac * 100));
    added++;
    if (bac >= 0.25) {

      findViewById(R.id.btnSave).setEnabled(false);
      findViewById(R.id.btnAddDrink).setEnabled(false);
      Toast.makeText(this, "Have Mercy on your liver!.", Toast.LENGTH_SHORT).show();
    }
  }


  public void onResetButtonClick(View v) {
    weight = 0;
    gender = .55;
    bac = 0;
    saved = 0;
    added = 0;
    findViewById(R.id.btnSave).setEnabled(true);
    findViewById(R.id.btnAddDrink).setEnabled(true);
    ((EditText) findViewById(R.id.txtEditWeight)).setText("");
    ((Switch) findViewById(R.id.switchChooseGender)).setChecked(false);
    ((RadioButton) findViewById(R.id.radOne)).setChecked(true);
    ((SeekBar) findViewById(R.id.seekAlcoholPercent)).setProgress(5);
    ((TextView) findViewById(R.id.txtResultStatus)).setText("You're safe");
    ((TextView) findViewById(R.id.txtBACLevel)).setText("BAC Level : 0.00");
    ((ProgressBar) findViewById(R.id.pbBACLevel)).setProgress(0);
  }

  public void calculateBAC(double A) {

    bac = (A * 6.24) / (weight * gender);


    NumberFormat numberFormat = new DecimalFormat("0.##");
    ((TextView) findViewById(R.id.txtBACLevel)).setText("BAC Level: " + numberFormat.format(bac));


    ((ProgressBar) findViewById(R.id.pbBACLevel)).setProgress((int) Math.round(bac * 100));
    added++;
    String output = bac < 0.8 ? "You\'re safe" : bac < 0.20 ? "Be Careful..." : "Over the limit!";
    ((TextView) findViewById(R.id.txtResultStatus)).setText("" + output);
    if (bac >= 0.25) {

      findViewById(R.id.btnSave).setEnabled(false);
      findViewById(R.id.btnAddDrink).setEnabled(false);
      Toast.makeText(this, "No more drinks for you.", Toast.LENGTH_SHORT).show();
    }
  }

  @Override
  public void onClick(View v) {

  }


  @Override
  public void onStartTrackingTouch(SeekBar seekBar) {
    SeekBar one = (SeekBar) findViewById(R.id.seekAlcoholPercent);
    int p = one.getProgress();
    ((TextView) findViewById(R.id.txtAlcoholPercent)).setText(p + "%");
  }

  @Override
  public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
    SeekBar one = (SeekBar) findViewById(R.id.seekAlcoholPercent);
    int p = one.getProgress();
    ((TextView) findViewById(R.id.txtAlcoholPercent)).setText(p + "%");
  }

  @Override
  public void onStopTrackingTouch(SeekBar seekBar) {
    SeekBar one = (SeekBar) findViewById(R.id.seekAlcoholPercent);
    int p = one.getProgress();
    ((TextView) findViewById(R.id.txtAlcoholPercent)).setText(p + "%");
  }

}
