package com.gemini.firebase_login;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class RegisterFragment extends Fragment {
Button RegisterButton;
TextView Name,Email,Password,ConfirmPassword;

FirebaseAuth mAuth;
    public RegisterFragment() {
        // Required empty public constructor
    }

    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void registerUser(User user) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", user.getName());
        userMap.put("email", user.getEmail());
        userMap.put("LastLogin", user.getLastLogin());

// Add a new document with a generated ID
      db.collection("users")
        .add(userMap)
        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
          @Override
          public void onSuccess(DocumentReference documentReference) {
            Toast.makeText(getContext(), "Registered Sucessfully", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
          }
        })
        .addOnFailureListener(new OnFailureListener() {
          @Override
          public void onFailure(@NonNull Exception e) {
            Toast.makeText(getContext(), "Registered Failed", Toast.LENGTH_SHORT).show();

            Log.w(TAG, "Error adding document", e);
          }


        });

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_register, container, false);

      FirebaseFirestore db = FirebaseFirestore.getInstance();
      RegisterButton = view.findViewById(R.id.buttonRegister);
      Name = view.findViewById(R.id.textViewName);
      Email = view.findViewById(R.id.textViewEmail);
      Password = view.findViewById(R.id.textViewPassword);
      ConfirmPassword = view.findViewById(R.id.textViewPasswordConfirm);

      RegisterButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          String name = Name.getText().toString();
          String email = Email.getText().toString();
          String password = Password.getText().toString();
          String confirmPassword = ConfirmPassword.getText().toString();
          if (password.equals(confirmPassword)) {
            User user = new User(name, email, password);
            RegisterUser(user);
          } else {
            Toast.makeText(getContext(), "Password does not match", Toast.LENGTH_SHORT).show();
          }
        }


      });


        return view;
    }
  private void reload() { }

  private void updateUI(FirebaseUser user) {

  }

  @Override
  public void onAttach(@NonNull Context context) {

    super.onAttach(context);
    mAuth = FirebaseAuth.getInstance();
  }


  void RegisterUser(User user) {
    if (user != null) {
      Toast.makeText(getContext(), "User Created", Toast.LENGTH_SHORT).show();

      mAuth.createUserWithEmailAndPassword(Objects.requireNonNull(user.getEmail()), user.getEmail())

        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
              // Sign in success, update UI with the signed-in user's information
              Log.d(TAG, "createUserWithEmail:success");
              mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getEmail());
              Toast.makeText(getActivity(), "Registeration Successful.",
                Toast.LENGTH_SHORT).show();

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

}
