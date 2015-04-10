package org.jderobot.androidcameraserver;

import java.util.List;

import org.jderobot.androidcameraserver.R;


import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.os.Bundle;

public class Preferences extends PreferenceActivity implements OnPreferenceChangeListener {

  ListPreference lp;
  static boolean modified = false;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.preference);
    lp = (ListPreference) findPreference("listpref");
    modified = false;

    List<List<Integer>> reslist = CameraPreview.getResList();
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
    modified = true;
    return false;
  }
}
