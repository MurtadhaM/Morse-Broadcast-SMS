package com.gemini.httpok;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements ContactsFragment.OnContactSelectedListener {

  private final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new ContactsFragment()).commit();


    }

  @Override
  public void onGetMeTheContacts() {
    Toast.makeText(this, "Hi ali from mainacitivity", Toast.LENGTH_SHORT).show();

  }

  void GetContacts() {
    // Get the contacts from the server
    // ...
    // Create a new adapter for that data

    Request request = new Request.Builder()
      .url("https://theappsdr.com/contacts/json")
      .build();
    client.newCall(request).enqueue(new okhttp3.Callback() {
      @Override
      public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
        if (response.isSuccessful()) {
          // Get the response body as a string
          String json = response.body().string();
          // Create a new adapter for that data
          // ...
          // Set the adapter on the RecyclerView
          // ...
        }
      }

      @Override
      public void onFailure(okhttp3.Call call, IOException e) {
        e.printStackTrace();


      }
    });

  }
}
