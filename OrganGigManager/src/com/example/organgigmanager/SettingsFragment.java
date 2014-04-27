package com.example.organgigmanager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.organistendienstmanager.R;

/**
 * Fragment to show the edit gig input mask. Serves as new gig input mask when there is no gig to edit.
 * 
 */
public class SettingsFragment extends Fragment {
	private static final String TAG = "SettingsFragment";

	private OnMainNavigationItemClicked mParentOnMainNavigationItemClicked;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.v(TAG, "onAttach");

		// Check if parent fragment (if there is one) implements the OnMainNavigationItemClicked interface
		Fragment parentFragment = getParentFragment();
		if ((parentFragment != null) && (parentFragment instanceof OnMainNavigationItemClicked)) {
			mParentOnMainNavigationItemClicked = (OnMainNavigationItemClicked) parentFragment;
		}
		// Otherwise, check if parent activity implements the OnMainNavigationItemClicked
		else if ((activity != null) && (activity instanceof OnMainNavigationItemClicked)) {
			mParentOnMainNavigationItemClicked = (OnMainNavigationItemClicked) activity;
		}
		// If neither implements the callback, warn that
		// selections are being missed
		else if (mParentOnMainNavigationItemClicked == null) {
			Log.w(TAG, "onAttach: neither the parent fragment or parent activity implement OnMainNavigationItemClicked!");
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(TAG, "onCreate: savedInstanceState " + (savedInstanceState == null ? "==" : "!=") + " null");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		Log.v(TAG, "onCreateView: savedInstanceState " + (savedInstanceState == null ? "==" : "!=") + " null");

		// Inflate the fragment main view in the container provided
		View v = inflater.inflate(R.layout.fragment_settings, container, false);


		return v;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Log.v(TAG, "onViewCreated");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.v(TAG, "onActivityCreated");
	}

	@Override
	public void onViewStateRestored(Bundle savedInstanceState) {
		super.onViewStateRestored(savedInstanceState);
		Log.v(TAG, "onViewStateRestored");
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.v(TAG, "onStart");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.v(TAG, "onResume");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.v(TAG, "onPause");
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.v(TAG, "onSaveInstanceState");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.v(TAG, "onStop");
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.v(TAG, "onDestroyView");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.v(TAG, "onDestroy");
	}


}
