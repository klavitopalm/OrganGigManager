package com.example.organgigmanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.organgigmanager.gigs.GeneralGigData;
import com.example.organgigmanager.gigs.GigData;
import com.example.organistendienstmanager.R;

/**
 * Fragment to show the edit gig input mask. Serves as new gig input mask when there is no gig to edit.
 * 
 */
public class EditGigFragment extends Fragment {
	private static final String TAG = "EditGigFragment";

	private OnMainNavigationItemClicked mParentOnMainNavigationItemClicked;
	private DatePicker mDateContent;
	private Spinner mLocationContent;
	private EditText mIssueContent;
	private CheckBox mInvoiceRequiredContent;
	private CheckBox mBillMetContent;

	private final GigData gig = new GeneralGigData();


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
		View v = inflater.inflate(R.layout.fragment_edit_gig, container, false);


		mDateContent = (DatePicker) v.findViewById(R.id.gig_date_content);
		if(mDateContent != null) {
			mDateContent.init(2014, 3, 15, new OnDateChangedListener() {

				@Override
				public void onDateChanged(DatePicker view, int year, int monthOfYear,
						int dayOfMonth) {

					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date date = null;
					try {
						String parseString = String.valueOf(dayOfMonth) + "/" + String.valueOf(monthOfYear) + "/" + String.valueOf(year);
						date = sdf.parse(parseString);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					gig.setDate(date);
				}
			});
		}

		mLocationContent = (Spinner) v.findViewById(R.id.gig_location_content);
		if(mLocationContent == null) {
			Log.e(TAG, "No locationspinner found");
		}

		mIssueContent = (EditText) v.findViewById(R.id.gig_issue_content);
		if(mIssueContent != null) {
			mIssueContent.addTextChangedListener(new TextWatcher() {

				@Override
				public void onTextChanged(CharSequence s, int start, int before, int count) {

				}

				@Override
				public void beforeTextChanged(CharSequence s, int start, int count,
						int after) {

				}

				@Override
				public void afterTextChanged(Editable s) {
					gig.setIssue(s.toString());

				}
			});
		}

		mInvoiceRequiredContent = (CheckBox) v.findViewById(R.id.gig_invoice_required_content);
		if(mInvoiceRequiredContent != null) {

		}

		mBillMetContent = (CheckBox) v.findViewById(R.id.gig_bill_met_content);
		if(mBillMetContent == null) {
			Log.e(TAG, "No bill checkbox found");
		}

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
