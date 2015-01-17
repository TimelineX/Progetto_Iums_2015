package it.maugra.utils;

import it.maugra.repmobile.My_MainActivity;

import java.util.Set;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;



public abstract class MySimpleFragment extends Fragment implements MyFragmentInterface {
	protected My_MainActivity mActivity;
	protected Resources resources;
	
	private boolean firstRun = true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mActivity = (My_MainActivity) getActivity();
		resources = getResources();
		////mActivity.setActionbarTitle(getTitleResId());
		// mActivity.reloadActionButtons(this);

	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (!firstRun) {
	//		mActivity.setActionbarTitle(getTitleResId());
	//		mActivity.reloadActionButtons(this);
		} else {
			firstRun = false;
		}
	}

	@Override
	public void actionRefresh() {
	}

	@Override
	public boolean goBack() {
		return true;
	}

	@Override
	public void actionAdd() {
	}

	@Override
	public void actionEdit() {
	}

	@Override
	public void actionAccept() {
	}
	
	@Override
	public void actionCancel() {
	}
	
	@Override
	public void actionTwitter() {
	}

	@Override
	public Set<Integer> getActionsToShow() {
		return null;
	}
	
	@Override
	public int getTitleResId() {
		return -1;
	}
	
	@Override
	public boolean executeSearch(String query) {
		return true;
	}
}