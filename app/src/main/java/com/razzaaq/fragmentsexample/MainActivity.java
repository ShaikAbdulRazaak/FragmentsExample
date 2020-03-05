package com.razzaaq.fragmentsexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
public static final String LIST_FRAGMENT="list_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listfragment listFragmentSaved = (listfragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
        if (listFragmentSaved == null) {
            listfragment listFragment = new listfragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragmentsViewGroup,listFragment,LIST_FRAGMENT);
            fragmentTransaction.commit();
        }
    }
}
