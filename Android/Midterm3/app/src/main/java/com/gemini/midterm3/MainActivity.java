package com.gemini.midterm3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.AttributeSet;
import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import com.gemini.midterm3.databinding.ActivityMainBinding;

import android.view.Menu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FilterFragment.OnFilterFragmentInteractionListener , UsersFragment.OnListFragmentInteractionListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    ArrayList<User> users = new ArrayList<>();
    String selectedFilter;
  {
    users.add(new User("John", "Texas", "Friend", 18, "f"));
    users.add(new User("ausan", "Arizona", "Family", 50, "M"));
    users.add(new User("bohn", "Texas", "Friend", 18, "f"));
    users.add(new User("Susan", "Arizona", "Family", 50, "M"));
    users.add(new User("cohn", "Texas", "Friend", 18, "f"));
    users.add(new User("Susan", "Arizona", "Family", 50, "M"));
    users.add(new User("John", "Texas", "Friend", 18, "f"));
    users.add(new User("dusan", "Arizona", "Family", 50, "M"));
    users.add(new User("John", "Texas", "Friend", 18, "f"));
    users.add(new User("Susan", "Arizona", "Family", 50, "M"));
    users.add(new User("eohn", "Texas", "Friend", 18, "f"));
    users.add(new User("Susan", "Arizona", "Family", 50, "M"));
    users.add(new User("fohn", "Texas", "Friend", 18, "f"));
    users.add(new User("Susan", "Arizona", "Family", 50, "M"));
    users.add(new User("Jack", "Michigan", "Family", 13, "f"));


  }


  @Nullable
  @Override
  public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
    return super.onCreateView(parent, name, context, attrs);
  }

  @Override
  public void setContentView(View view) {
    super.setContentView(view);
    getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainerViewFilter, new FilterFragment()).commit();
    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerViewSort, new SortFragment()).commit();
    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerViewUsers, new UsersFragment()).commit();
  }

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //setSupportActionBar(binding.toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


  @Override
  public void onSetFilter(Comparable<String> filter) {


  }


  @Override
  public ArrayList<User> onGetFilterList() {
    return users;
  }

  @Override
  public ArrayList<User> onGetUsersArrauList() {
    return users;
  }

  @Override
  public void onSetFilter(String filter) {
    this.selectedFilter = filter;

  }
}
