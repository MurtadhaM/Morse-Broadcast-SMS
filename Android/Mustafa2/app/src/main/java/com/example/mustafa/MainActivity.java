package com.example.mustafa;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mustafa.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LoginFragment.ILoginFragment , RegisterFragment.IRegisterFragment , HomeFragment.IHomeFragment{

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
        View view = super.onCreateView(name, context, attrs);
        createNotificationChannel();

            return view;
    }


    @Override
    public void gotoHome() {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,
                new HomeFragment()).addToBackStack(null).commit();

    }


    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = ("Something");
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("1", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }



    @Override
    public void gotoRegister() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,
                new RegisterFragment()).addToBackStack(null).commit();

    }

    @Override
    public void completeRegistration(String Username, String Password) {
        Toast.makeText(this, "User Registered!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackButtonPressed() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,
                new RegisterFragment()).addToBackStack(null).commit();
    }

    @Override
    public void onNotificationButtonPressed() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.drawable.lgoo)
                .setContentTitle("My notification")
                .setContentText("Hello Cool Kids from Basheer")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        // Set the intent that will fire when the user taps the notification
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(1, builder.build());

        Toast.makeText(this, "Notification Received!", Toast.LENGTH_SHORT).show();

    }
}