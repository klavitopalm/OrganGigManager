package com.example.organgigmanager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.ViewGroup;

import com.example.organistendienstmanager.R;


public class MainActivity extends FragmentActivity implements OnMainNavigationItemClicked {
	private static final String TAG = "MainActivity";

	private ViewGroup mMainSelectedLayout, mChosenNavigationItemLayout;
	private boolean doesSecondFragmentExistInView = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(TAG, "onCreate: savedInstanceState " + (savedInstanceState == null ? "==" : "!=") + " null");

		setContentView(R.layout.activity_main);

		// Restore state
		if (savedInstanceState != null) {
			// The fragment manager will handle restoring them if we are being
			// restored from a saved state
		}
		// If this is the first creation of the activity, add fragments to it
		else {

			// If our layout has a container for the main_view fragment, add it
			mMainSelectedLayout = (ViewGroup) findViewById(R.id.activity_main_view_start_container);
			if (mMainSelectedLayout != null) {

				FragmentTransaction fragmentTransaction = addActivityMainViewStartContainerFragmentToContainerLayout();
				fragmentTransaction.commit();
			}

			mChosenNavigationItemLayout = (ViewGroup) findViewById(R.id.activity_main_selected_item_container);
			if (mChosenNavigationItemLayout != null) {
				Log.i(TAG, "onCreate: found second fragment");
				doesSecondFragmentExistInView = true;
			}

		}
	}

	private FragmentTransaction addActivityMainViewStartContainerFragmentToContainerLayout() {
		OverviewFragment overviewFragment = new OverviewFragment();
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(mMainSelectedLayout.getId(), overviewFragment,
				OverviewFragment.class.getName());
		return fragmentTransaction;
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
	public void onDestroy() {
		super.onDestroy();
		Log.v(TAG, "onDestroy");
	}

	@Override
	public void navigationItemClicked(MainNavigtationItems clickedItem) {
		Log.d(TAG, "navigationItemClicked: clickedItem = " + clickedItem);

		ViewGroup viewToDisplayClickedItem = mMainSelectedLayout;
		if(doesSecondFragmentExistInView) {
			viewToDisplayClickedItem = mChosenNavigationItemLayout;
		}

		if(clickedItem == MainNavigtationItems.EDIT_GIGS) {
			// Add activity_main_selected_item_container fragment to the activity's container layout
			EditGigFragment editGigFragment = new EditGigFragment();
			FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
			fragmentTransaction.replace(viewToDisplayClickedItem.getId(), editGigFragment,
					EditGigFragment.class.getName());

			addToBackStackIfOnlyOneFragmentIsDisplayed(fragmentTransaction);

			// Commit the transaction
			fragmentTransaction.commit();
		}
	}

	private void addToBackStackIfOnlyOneFragmentIsDisplayed(FragmentTransaction fragmentTransaction) {
		if(!doesSecondFragmentExistInView) {
			fragmentTransaction.addToBackStack("new_gig");
		}
	}

}
