/*
Authors: Murtadha Marzouq && Will Colvill
Assignment: In Class 5

 */
package com.gemini.in_class5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AppCatagoriesFragment.onItemFragmentListener, AppListFragment.onAppListFragmentListener, AppDetailsFragment.onAppDetailsFragmentListener {
  String selectedCatagory = "";
  DataServices.App selectedApp;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("App Catagories");
    setContentView(R.layout.activity_main);

    getSupportFragmentManager().beginTransaction()
      .replace(R.id.fragmentContainerView, new AppCatagoriesFragment())
      .addToBackStack("MainFragment")
      .commit();
  }

  /*
  TODO: Implement the Interfaces and setup the fragments
   */

  @Override
  public int getItemCount() {
    return 2;
  }

  @Override
  public void onSetAppCatagory(String catagory) {
    selectedCatagory = catagory;
    setTitle("Top 10 Paid Apps");
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.fragmentContainerView, new AppListFragment())

      .addToBackStack(null)
      .commit();

  }


  @Override
  public ArrayList<String> onGetAppNames() {
    if (selectedCatagory.equals("")) {
      return new ArrayList<String>();
    } else {
      ArrayList<DataServices.App> apps = DataServices.getAppsByCategory(selectedCatagory);
      ArrayList<String> appNames = new ArrayList<>();
      for (DataServices.App app : apps) {
        appNames.add(app.name);
      }
      return appNames;

    }

  }

  @Override
  public ArrayList<DataServices.App> onGetApps() {
    if (selectedCatagory.equals("")) {
      return null;
    } else {
      return DataServices.getAppsByCategory(selectedCatagory);
    }
  }

  @Override
  public void onsetSelectedApp(DataServices.App selectedApp) {
    this.selectedApp = selectedApp;
    setTitle("App Details");
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.fragmentContainerView, new AppDetailsFragment())
      .addToBackStack(null)
      .commit();

  }

  @Override
  public DataServices.App onGetApp() {
    if (selectedApp == null) {
      Log.d("LOG", "onGetApp: " + "null selected app");
      return null;
    } else {
      return selectedApp;
    }
  }
}
