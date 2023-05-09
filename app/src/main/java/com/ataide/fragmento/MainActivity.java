package com.ataide.fragmento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import com.ataide.fragmento.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        FragmentManager fragmentManager = getSupportFragmentManager();

        mainBinding.chatBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fragmentManager.beginTransaction().replace(R.id.fragmentContainerView, ChatsFragment.class, null )
                                .setReorderingAllowed(true)
                                .addToBackStack("chat")
                                .commit();

                    }
                }
        );

        mainBinding.userBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView,UsersFragment.class,null)
                                .setReorderingAllowed(true)
                                .addToBackStack("user")
                                .commit();
                    }
                }
        );

        mainBinding.settingsBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, SettingsFragment.class,null)
                                .setReorderingAllowed(true)
                                .addToBackStack("sett")
                                .commit();
                    }
                }
        );

    }
}