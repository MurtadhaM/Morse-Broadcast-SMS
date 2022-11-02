package com.example.mustafa;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.AttributeSet;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mustafa.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LoginFragment.ILoginFragment , RegisterFragment.IRegisterFragment{

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





    }


    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        View view =  super.onCreateView(name, context, attrs);


        return view;
    }

    @Override
    public void gotoHome() {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,
                new HomeFragment()).addToBackStack(null).commit();

    }

    @Override
    public void gotoRegister() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,
                new RegisterFragment()).addToBackStack(null).commit();

    }

    @Override
    public void completeRegistration(String Username, String Password) {

    }
}