package com.razzaaq.fragmentsexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class IngredientsFragment extends Fragment {
    private static final String KEY_BOOLEAN_CHECKBOXES ="key_boolean_checkboxes" ;
    private CheckBox[] checkBoxes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_ingredients, container, false);
        assert getArguments() != null;
        int position = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        LinearLayout linearLayout = view.findViewById(R.id.ingredients_Layout);
        String[] Ingredients = recipes.ingredients[position].split("`");
        checkBoxes = new CheckBox[recipes.ingredients.length];
        boolean[] checkedBoxes= new boolean[checkBoxes.length];
        if(savedInstanceState!=null && savedInstanceState.getBooleanArray(KEY_BOOLEAN_CHECKBOXES)!=null){
            checkedBoxes=savedInstanceState.getBooleanArray(KEY_BOOLEAN_CHECKBOXES);
        }
        setUpCheckBoxes(Ingredients, linearLayout,checkedBoxes);
        return view;
    }

    private void setUpCheckBoxes(String[] ingredients, ViewGroup container, boolean[] checkedBoxes) {
        int i = 0;
        for (String ingredient : ingredients) {
            checkBoxes[i] = new CheckBox(getContext());
            checkBoxes[i].setPadding(8, 16, 8, 16);
            checkBoxes[i].setTextSize(20f);
            checkBoxes[i].setText(ingredient);
            container.addView(checkBoxes[i]);
            i++;
            if(checkedBoxes[i]){
                checkBoxes[i].toggle();
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        boolean[] saveStateOfCheckBoxes = new boolean[checkBoxes.length];
        int i=0;
        for(CheckBox checkBox:checkBoxes){
            saveStateOfCheckBoxes[i]=checkBox.isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_BOOLEAN_CHECKBOXES,saveStateOfCheckBoxes);
        super.onSaveInstanceState(outState);
    }
}
