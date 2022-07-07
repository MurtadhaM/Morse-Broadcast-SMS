package com.gemini.firebase_login;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.gemini.firebase_login.databinding.ActivityLoginBinding;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;
import java.util.concurrent.Executor;

public class LoginFragment extends Fragment {

  Button Register;
    private ActivityLoginBinding binding;
  private FirebaseAuth mAuth;

    @Override
    public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
    ) {

        binding = ActivityLoginBinding.inflate(inflater, container, false);
        View view =  binding.getRoot();


        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.editTextTextEmailAddress.getText().toString();
                String password = binding.editTextTextPassword.getText().toString();
                signIn(email, password);
            }
        });

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if (getActivity() != null) {
                getActivity().getSupportFragmentManager()
                  .beginTransaction()
                  .replace(R.id.fragmentContainerView, new RegisterFragment())
                  .commit();
              }
            }
        });
        return view;

    }

  private void signIn(String email, String password) {
    // [START sign_in_with_email]

    mAuth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
              // Sign in success, update UI with the signed-in user's information
              Log.d(TAG, "signInWithEmail:success");
              FirebaseUser user = mAuth.getCurrentUser();
              Toast.makeText(getActivity(), "Authentication Successful.",
                Toast.LENGTH_SHORT).show();

              updateUI(user);
            } else {
              // If sign in fails, display a message to the user.
              Log.w(TAG, "signInWithEmail:failure", task.getException());
              Toast.makeText(getActivity(), "Authentication failed.",
                  Toast.LENGTH_SHORT).show();
              updateUI(null);
            }

            // [START_EXCLUDE]
            if (!task.isSuccessful()) {
              Toast.makeText(getContext(), "secus", Toast.LENGTH_SHORT).show();
            }
            // [END_EXCLUDE]
          }
        });
    // [END sign_in_with_email]
  }

  private void reload() { }

  private void updateUI(FirebaseUser user) {

  }


  void RegisterUser(FirebaseUser user) {
    if (user != null) {
      Toast.makeText(getContext(), "User Created", Toast.LENGTH_SHORT).show();

      mAuth.createUserWithEmailAndPassword(Objects.requireNonNull(user.getEmail()), user.getEmail())

        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
              // Sign in success, update UI with the signed-in user's information
              Log.d(TAG, "createUserWithEmail:success");
              FirebaseUser user = mAuth.getCurrentUser();
              Toast.makeText(getActivity(), "Registeration Successful.",
                Toast.LENGTH_SHORT).show();

              updateUI(user);
            } else {
              // If sign in fails, display a message to the user.
              Log.w(TAG, "createUserWithEmail:failure", task.getException());
              Toast.makeText(getActivity(), "Registeration failed.",
                Toast.LENGTH_SHORT).show();
              updateUI(null);
            }

            // [START_EXCLUDE]
            if (!task.isSuccessful()) {
              Toast.makeText(getContext(), "secus", Toast.LENGTH_SHORT).show();
            }
            // [END_EXCLUDE]
          }
        });
    } else {
      Toast.makeText(getContext(), "User not Created", Toast.LENGTH_SHORT).show();
    }
  }


@Override
public void onAttach(Context context) {
  super.onAttach(context);
  mAuth = FirebaseAuth.getInstance();
 }

  @Override
  public void onStart() {
    super.onStart();
    mAuth = FirebaseAuth.getInstance();
    // Check if user is signed in (non-null) and update UI accordingly.
    FirebaseUser currentUser = mAuth.getCurrentUser();
    if(currentUser != null){
      reload();
    }
  }


}
