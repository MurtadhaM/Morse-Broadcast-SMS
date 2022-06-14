package com.gemini.practice;

import static androidx.constraintlayout.widget.Constraints.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class MainActivity extends AppCompatActivity implements ListViewFragment.onUserSelectedListener {
   String responseData = "";

   ArrayList<String> Responseslist = new ArrayList<>();



  void   makeRequest(@NonNull String url) {
    HttpUrl urlOBJ = HttpUrl.parse(url).newBuilder().build();
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder().url(urlOBJ).build();


    client.newCall(request).enqueue(new okhttp3.Callback() {
      @Override
      public void onFailure(@NonNull Call call, IOException e) {
        e.printStackTrace();
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
          //responseData = response.body().string();
          if (response.isSuccessful()) {
            ResponseBody responseBody = response.body();
            Log.d(TAG, "onResponse: " + "Recieved response" );
          runOnUiThread(new Runnable() {
            @Override
            public void run() {
              try {
                Responseslist.add(responseBody != null ? responseBody.string() : null) ;
                ListViewFragment listViewFragment = (ListViewFragment) getSupportFragmentManager().findFragmentByTag("ListViewFragment");
                if (listViewFragment != null) {
                  listViewFragment.recyclerView = listViewFragment.getView().findViewById(R.id.recyclerView_HTTP_Responses);
                }
                ArrayAdapter adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, Responseslist);

                listViewFragment.recyclerView.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, Responseslist));

              } catch (IOException e) {
                e.printStackTrace();
              }
              getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView ,
                  new ListViewFragment() , "ListViewFragment")
                .addToBackStack("ListViewFragment").commit();

            }
          });
          }
      }

    });

  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView ,
      new ListViewFragment() , "ListViewFragment")
    .addToBackStack("ListViewFragment").commit();


  }


  @Override
  public void setTextViewOutput() {
  }

  @Override
  public void onMakeRequest(String url) {
    Toast.makeText(this, "onMakeRequest", Toast.LENGTH_SHORT).show();
    makeRequest(url);
  }

  @Override
  public ArrayList<String> getListofRequests() {
    return  Responseslist;
  }


}



