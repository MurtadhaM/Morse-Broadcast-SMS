package com.gemini.homework4;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.gemini.homework4.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements UsersFragment.onUsersFragmentListener, FilterByStateFragment.onFilterByStateFragmentListener ,SortFragment.onSortFragmentListener {

  ArrayList<DataServices.User> users = (ArrayList<DataServices.User>) DataServices.getAllUsers().clone();

  String selectedState = "";

  // get the unique states from the users
  ArrayList<String> getUniqueStates() {
    ArrayList<String> uniqueStates = new ArrayList<>();
    for (DataServices.User user : DataServices.getAllUsers()) {
      if (!uniqueStates.contains(user.state)) {
        uniqueStates.add(user.state);
      }
    }
    return uniqueStates;
  }

  // get the Set Title from the fragment
  public  void  setActionBarTitle(String title) {
    getSupportActionBar().setTitle(title);
  }


  // Defining Sort Methods
  // TODO : Sort By Name
  public void sortByName(String sortOrder) {
      Comparator<DataServices.User> comparator = new Comparator<DataServices.User>() {
        @Override
        public int compare(DataServices.User o1, DataServices.User o2) {
          return o2.name.compareTo(o1.name);
        }
      };
      Collections.sort(users, comparator);


  }


  // TODO : Sort By State
  public void sortByState(String sortOrder) {
    Comparator<DataServices.User> comparator = new Comparator<DataServices.User>() {
      @Override
      public int compare(DataServices.User o1, DataServices.User o2) {
        return o1.state.compareTo(o2.state);
      }
    };
    Collections.sort(users, comparator);
  }

  // TODO : Sort By Age
  public void sortByAge(String sortOrder) {
    Comparator<DataServices.User> comparator = new Comparator<DataServices.User>() {
      @Override
      public int compare(DataServices.User o1, DataServices.User o2) {
        return o1.age - o2.age;
      }
    };
    Collections.sort(users, comparator);
  }

  // TODO : Filter By State
  public void filterByState(String state) {
    if (state.equals("All States")) {
      users = DataServices.getAllUsers();
    } else {
      users = new ArrayList<>();
      for (DataServices.User user : DataServices.getAllUsers()) {
        if (user.state.equals(state)) {
          users.add(user);
        }
      }
    }
  }


  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    appBarLayout = findViewById(R.id.appBarLayout);

    // Add The User Fragment
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.fragmentContainerView, new UsersFragment())
      .commit();
  }


  @Nullable
  @Override
  public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {


    return super.onCreateView(name, context, attrs);


  }

  @Override
  public void setTitle(CharSequence title) {
    appBarLayout.setTitle(title);
    super.setTitle(title);
  }

  com.google.android.material.appbar.MaterialToolbar appBarLayout;



  /*
        TODO: IMPLEMENT THE INTERFACES METHODS
       */
  @Override
  public void onSortButtonClicked() {
    Log.d(TAG, "onSortButtonClicked: ");
    // TODO : Set Title of the Sort Fragment
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.fragmentContainerView, new SortFragment())
      .addToBackStack(null)
      .commit();
  }

  @Override
  public void onFilterButtonClicked() {
    // TODO : Refresh the Fragment and Set Tile Title

    Log.d(TAG, "Filter Button Clicked: ");
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.fragmentContainerView, new FilterByStateFragment())
      .addToBackStack(null)
      .commit();

  }

  @Override
  public ArrayList<DataServices.User> onGetUsers() {
    Log.d(TAG, "Getting Users: and they are  " + users.size());
    return users;
  }


  @Override
  public void onSelectState(String state) {
    Log.d(TAG, "onSelectState: " + state);
    // TODO : Refresh the Fragment and Set Tile Title
    selectedState = state;
    filterByState(selectedState);
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.fragmentContainerView, new UsersFragment())
      .addToBackStack(null)
      .commit();
  }

  @Override
  public ArrayList<String> onGetUniqStates() {
    //get UNIQUE states

    return getUniqueStates();
  }

  @Override
  public void onSetSortMethodListener(String sortMethod, String sortOrder) {
    Log.d(TAG, "MAIN ACTIVITY CALLER: " + sortMethod + " " + sortOrder);

    if (sortMethod.contains("Name")) {
      if (sortOrder.equals("ASC")) {
        sortByName("Ascending");
      } else {
        sortByName("Descending");
        Collections.reverse(users);
      }
    } else if (sortMethod.equals("State")) {
      if (sortOrder.equals("ASC")) {
        sortByState("Ascending");
      } else {
        sortByState("Descending");
        Collections.reverse(users);
      }
    } else if (sortMethod.equals("Age")) {
      if (sortOrder.equals("ASC")) {
        sortByAge("Ascending");
      } else {
        sortByAge("Descending");
        Collections.reverse(users);
      }
    }

    // TODO : Refresh the Fragment and Set Tile Title
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.fragmentContainerView, new UsersFragment())
      .addToBackStack(null)
      .commit();

  }

  /*
  *  TODO: Starter Interface Methods
  * */
  @Override
  public Sorter[] getSortList() {
    // Here we Define The Elements of the Sort List

    return new Sorter[]{
      new Sorter("Name", R.drawable.ic_sort_descending, R.drawable.ic_sort_ascending),
      new Sorter("State", R.drawable.ic_sort_descending, R.drawable.ic_sort_ascending),
      new Sorter("Age", R.drawable.ic_sort_descending, R.drawable.ic_sort_ascending),
    };
  }


}

