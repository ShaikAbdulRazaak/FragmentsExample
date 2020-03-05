package com.razzaaq.fragmentsexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listfragment listFragmentSaved = (listfragment) getSupportFragmentManager().findFragmentById(R.id.fragmentsViewGroup);
        if (listFragmentSaved == null) {
            listfragment listFragment = new listfragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragmentsViewGroup, listFragment);
            fragmentTransaction.commit();
        }
    }
}
