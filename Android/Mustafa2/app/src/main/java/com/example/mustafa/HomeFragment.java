package com.example.mustafa;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    // Creating the buttons
    Button HomeButton;
    Button NotificationButton;

    public HomeFragment() {
    }
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);


        // binding the layout

        HomeButton = view.findViewById(R.id.Home_Back_Button);



        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onBackButtonPressed();
            }
        });




        // Setting the onclick listener for the button
        NotificationButton = view.findViewById(R.id.home_Notification_Button);
        NotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onNotificationButtonPressed();
            }
        });

        return  view;

    }
    HomeFragment.IHomeFragment mListener;
    @Override
    public void onAttach(@NonNull Context context) {

        if (context instanceof HomeFragment.IHomeFragment) {
            mListener = (HomeFragment.IHomeFragment) context;
        } else {


            // NOTING
        }
        super.onAttach(context);
    }

    public interface IHomeFragment{
        void onBackButtonPressed();
        void onNotificationButtonPressed();
    }


}