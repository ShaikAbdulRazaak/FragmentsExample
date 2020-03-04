package com.razzaaq.fragmentsexample;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // ListFragment saved=(ListFragment) getFragmentManager().findFragmentById(R.id.fragmentsViewGroup);
        if(savedInstanceState==null){
            ListFragment listFragment=new ListFragment();
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragmentsViewGroup,listFragment);
            fragmentTransaction.commit();
        }
    }
}
