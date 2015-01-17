package it.maugra.repmobile;



import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.webkit.WebView.FindListener;
import android.widget.GridView;
import android.widget.TabHost;
import android.widget.ViewFlipper;

/**
 * A placeholder fragment containing a simple view.
 */
public  class Main_Fragment extends Fragment {
	private GridView gridView;
	private GridViewAdapter customGridAdapter;
	private TabHost mTabHost;
	
	private static final int SWIPE_MIN_DISTANCE = 120;
	private static final int SWIPE_THRESHOLD_VELOCITY = 200;
	private ViewFlipper mViewFlipper;	
	private AnimationListener mAnimationListener;
	private Context mContext;
	
	@SuppressWarnings("deprecation")
	private final GestureDetector detector = new GestureDetector(new SwipeGestureDetector());
	

	public Main_Fragment() {
	}
	
	@Override  
	    public void onAttach(Activity activity) {  
	        super.onAttach(activity);  
	        My_MainActivity main=(My_MainActivity) activity;  
	        My_MainActivity listener = main;  
	    }  
	 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		View rootView = inflater.inflate(R.layout.princ_fragment_2, container,
				false);
		gridView = (GridView) rootView.findViewById(R.id.gridView);
		customGridAdapter = new GridViewAdapter(this.getActivity(), R.layout.row_grid, getData());
		gridView.setAdapter(customGridAdapter);
		
		//mTabHost = rootView.getTabHost();
		mTabHost = (TabHost)rootView.findViewById(R.id.tabhost);
		mTabHost.setup();
		mTabHost.addTab(mTabHost.newTabSpec("tab_test1").setIndicator("Turnario").setContent(R.id.gridView));
		mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("CarSharing").setContent(R.id.textview2));
		mTabHost.addTab(mTabHost.newTabSpec("tab_test3").setIndicator("Altro").setContent(R.id.textview3));
		mTabHost.setCurrentTab(0);
		
		
		mContext = this.getActivity();
		mViewFlipper = (ViewFlipper) rootView.findViewById(R.id.ViewFlipper01);
		mViewFlipper.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(final View view, final MotionEvent event) {
				detector.onTouchEvent(event);
				return true;
			}
		});
		
		/*tabHost = (TabHost) rootView.findViewById(R.id.tabhost);
		tabHost.setup();
		tabHost.addTab(tabHost.newTabSpec("Alice").setContent(R.id.gridView)
		.setIndicator("Turnario"));
		tabHost.addTab(tabHost.newTabSpec("Marta").setContent(R.id.gridView)
		.setIndicator("CarSharing"));*/

		return rootView;
	}
	
	
    private ArrayList<ImageItem> getData() {
		final ArrayList<ImageItem> imageItems = new ArrayList<ImageItem>();
		// retrieve String drawable array
		TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
		for (int i = 0; i < imgs.length(); i++) {
			Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
					imgs.getResourceId(i, -1));
			imageItems.add(new ImageItem(bitmap, "Image#" + i));
		}

		return imageItems;

	}

	

	class SwipeGestureDetector extends SimpleOnGestureListener {
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			try {
				// right to left swipe
				if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
					mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_in));
					mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_out));
					// controlling animation
					mViewFlipper.getInAnimation().setAnimationListener(mAnimationListener);
					mViewFlipper.showNext();
					return true;
				} else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
					mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.right_in));
					mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext,R.anim.right_out));
					// controlling animation
					mViewFlipper.getInAnimation().setAnimationListener(mAnimationListener);
					mViewFlipper.showPrevious();
					return true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			return false;
		}
	}
	
}
