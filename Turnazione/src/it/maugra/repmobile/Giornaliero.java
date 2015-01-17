/**
 *
 */
package it.maugra.repmobile;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;


/**
 * @author Mizio
 * Fragment : Giornaliero
 */
public class Giornaliero extends Fragment  {

    Calendar myCalendar = Calendar.getInstance();

    //UI References
    //private TextView Data;
    private EditText editText;
    private DatePickerDialog datePicker;
    private SimpleDateFormat dateFormatter;
    private View rootView;
    private Calendar newCalendar = Calendar.getInstance();
    
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };



	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.giornaliero_fragment, container,
				false);

        findViewsById();
       // setDateTimeField();



        return rootView;

	}

        private void findViewsById() {
            editText = (EditText) rootView.findViewById(R.id.txtDate);
            editText.requestFocus();
            editText.setOnClickListener(new View.OnClickListener() {

            	@Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    new DatePickerDialog(rootView.getContext(), date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            });

        }

        
        




            private void updateLabel() {

                String myFormat = "dd/MM/yyyy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ITALIAN);

                editText.setText(sdf.format(myCalendar.getTime()));
                }
  }
   





