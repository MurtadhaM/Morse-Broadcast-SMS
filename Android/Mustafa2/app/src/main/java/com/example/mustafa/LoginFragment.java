package com.example.mustafa;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mustafa.databinding.FragmentLoginBinding;
import com.example.mustafa.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    Button LoginButton;
    Button RegisterButton;
    TextView textviewEmail;
    TextView textviewPassword;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View myview =  binding.getRoot();

        LoginButton = binding.ButtonLogin;





        return  myview;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LoginButton = binding.ButtonLogin;

        // Login Action
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.gotoHome();
            }
        });


    //Register Action
        binding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.gotoRegister();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    ILoginFragment mListener;
    @Override
    public void onAttach(@NonNull Context context) {

        if (context instanceof ILoginFragment) {
            mListener = (ILoginFragment) context;
        } else {


            // NOTING
        }
        super.onAttach(context);
    }

    public interface ILoginFragment{
        void gotoHome();
        void gotoRegister();
    }

}