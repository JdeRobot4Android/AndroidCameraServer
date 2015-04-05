package com.linaresdigital.android.androidcameraserver;

import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.os.Bundle;

public class Preferences extends PreferenceActivity implements
		OnPreferenceChangeListener {

	ListPreference lp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preference);
		lp = (ListPreference) findPreference("listpref");
		Bundle b = getIntent().getExtras();
		int[][] resolution = (int[][]) b.getSerializable("Array");

		CharSequence[] entries = new CharSequence[resolution.length];
		CharSequence[] values = new CharSequence[resolution.length];
		for (int a = 0; a < resolution.length; a++) {
			entries[a] = resolution[a][0] + "x" + resolution[a][1];
			values[a] = resolution[a][0] + " " + resolution[a][1];
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