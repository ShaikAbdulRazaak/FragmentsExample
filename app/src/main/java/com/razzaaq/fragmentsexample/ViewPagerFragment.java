package com.razzaaq.fragmentsexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class ViewPagerFragment extends Fragment {
    public static final String KEY_RECIPE_INDEX="recipe_index";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        assert getArguments() != null;
        int position=getArguments().getInt(KEY_RECIPE_INDEX);
        Objects.requireNonNull(getActivity()).setTitle(recipes.names[position]);
        View view= LayoutInflater.from(getContext()).inflate(R.layout.fragment_view_pager,container,false);
        return view;
    }
}
