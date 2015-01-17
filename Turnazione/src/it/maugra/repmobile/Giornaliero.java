/**
 * 
 */
package it.maugra.repmobile;

import java.text.SimpleDateFormat;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.ViewFlipper;

/**
 * @author Mizio
 * Fragment : Giornaliero
 */
public class Giornaliero extends Fragment {
	
	 
	//UI References
    private TextView Data;
        
    private DatePickerDialog DatePickerDialog;
    
    private SimpleDateFormat dateFormatter;
    private View rootView;
    
	@Override  
    public void onAttach(Activity activity) {  
        super.onAttach(activity);  
        My_MainActivity main = (My_MainActivity) activity;  
        My_MainActivity listener = main;  
    }  
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.giornaliero_fragment, container,
				false);
		Data = (TextView) rootView.findViewById(R.id.txtDate);
		Data.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	DatePickerDialog.show();;
	        }

	    });
		return rootView;
	}
	
	private void findViewsById() {
		Data = (TextView) rootView.findViewById(R.id.txtDate);
		
	}
	
	private void setDateTimeField() {
	//	Data.setOnClickListener(rootView);
	}

	
		
	}
	

