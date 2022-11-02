package com.example.mustafa;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    TextView TextViewEmail;
    TextView TextViewPassword;
    TextView TextViewPasswordRepeat;
    Button ButtonRegister;
    public RegisterFragment() {
    }

    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_register, container, false);


        // Attaching the Objects to Layout
        TextViewEmail = view.findViewById(R.id.editTextTextEmailAddress);
        TextViewPassword = view.findViewById(R.id.editTextTextPassword);
        TextViewPasswordRepeat = view.findViewById(R.id.editTextTextPassword_Repeat);
        ButtonRegister = view.findViewById(R.id.button_Register);
        // Storing the entered Values
        String UsernameValue = TextViewEmail.getText().toString();
        String PasswordValue = TextViewPassword.getText().toString();
        String PasswordRepeatValue = TextViewPasswordRepeat.getText().toString();



        //Input Validation
        if(TextViewEmail.getText().toString().isEmpty() || !TextViewPassword.getText().toString().equals(TextViewPasswordRepeat.getText().toString()) ){

            Toast.makeText(getContext(), "Check your Input", Toast.LENGTH_SHORT).show();
        }
        else {

            // Click Handlers
            ButtonRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.completeRegistration(UsernameValue,PasswordValue);
                }
            });


        }
        return  view;
    }






    RegisterFragment.IRegisterFragment mListener;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof RegisterFragment.IRegisterFragment) {
            mListener = (RegisterFragment.IRegisterFragment) context;
        } else {
            Toast.makeText(context, "Interface Not Implemented", Toast.LENGTH_SHORT).show();

        }

    }

    public interface IRegisterFragment{
        void completeRegistration(String Username, String Password);
    }
}