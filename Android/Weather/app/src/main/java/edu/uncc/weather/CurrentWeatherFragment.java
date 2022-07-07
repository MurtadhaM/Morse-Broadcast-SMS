package edu.uncc.weather;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;

import edu.uncc.weather.databinding.FragmentCurrentWeatherBinding;
import okhttp3.OkHttpClient;

public class CurrentWeatherFragment extends Fragment {
    FragmentCurrentWeatherBinding binding;
String city;
String country;
String tempMax;
String humidity;
String tempMin;


    OkHttpClient httpClient = new OkHttpClient();



    public void getCurrentWeather(String city) {
        String url = "https://samples.openweathermap.org/data/2.5/weather?q="+ city +  "&appid=b1b15e88fa797225412429c1c50c122a1";
        httpClient.newCall(new okhttp3.Request.Builder().url(url).build()).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
              if (response.isSuccessful()) {
                String json = response.body().string();

                System.out.println(json);
                Log.d(TAG, "onResponse: " + json);
              }
              else {
                Log.d(TAG, "onResponse: " + response.body().string());
                Toast.makeText(getContext(), "Api Error", Toast.LENGTH_SHORT).show();

              }

            }


        });



    }







    public CurrentWeatherFragment() {
        // Required empty public constructor
    }

    public static CurrentWeatherFragment newInstance(String city) {
        CurrentWeatherFragment fragment = new CurrentWeatherFragment();
        fragment.getCurrentWeather(city);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCurrentWeatherBinding.inflate(inflater, container, false);
        View view =  binding.getRoot();



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Current Weather");
    }
}
