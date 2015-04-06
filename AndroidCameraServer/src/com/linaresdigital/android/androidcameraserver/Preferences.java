package com.linaresdigital.android.androidcameraserver;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;

public class Preferences extends PreferenceActivity implements OnPreferenceChangeListener {

  ListPreference lp;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.preference);
    lp = (ListPreference) findPreference("listpref");
    
   
    List<List<Integer>> reslist = CameraPreview.getResList() ;
    CharSequence[] entries = new CharSequence[reslist.size()];
    CharSequence[] values = new CharSequence[reslist.size()];
    for (int a = 0; a < reslist.size(); a++) {
      entries[a] = reslist.get(a).get(0) + "x" + reslist.get(a).get(1);
      values[a] = reslist.get(a).get(0) + " " + reslist.get(a).get(1);
    }
    lp.setEntries(entries);
    lp.setEntryValues(values);
    lp.setOnPreferenceChangeListener(this);
  }

  @Override
  public boolean onPreferenceChange(Preference preference, Object newValue) {
    lp.setValue(newValue.toString());
    return false;
  }
}
