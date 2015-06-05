package com.test.helloglass;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by matthewross on 03/06/2015.
 */
public class DataManager
{
    private Context context;
    private static final String StoredStringsKey = "com.test.helloglass.storedstringskey";
    private static final String PreferencesLocation = "com.test.helloglass";

    public DataManager(Context passedContext)
    {
        context = passedContext;
    }

    public ArrayList<String> getStoredStrings()
    {
        SharedPreferences preferences = context.getSharedPreferences(PreferencesLocation,Context.MODE_PRIVATE);
        Set<String> stringSet = preferences.getStringSet(StoredStringsKey, Collections.<String>emptySet());
        return new ArrayList<>(stringSet);
    }

    public void setStoredStrings(ArrayList<String> strings)
    {
        SharedPreferences preferences = context.getSharedPreferences(PreferencesLocation,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Set<String> stringSet = new HashSet<>(strings);
        editor.putStringSet(StoredStringsKey,stringSet);
        editor.apply();
    }
}
