package groep2.project4;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.model.Marker;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import groep2.project4.Fragments.LocationFragment;

public class AgendaActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    private static final int MY_PERMISSIONS_REQUEST_WRITE_CALENDAR = 0;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    Marker selectedmarker = LocationFragment.getSelectedMarker();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_CALENDAR)
                    != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_CALENDAR)) {
                } else {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.WRITE_CALENDAR},
                            MY_PERMISSIONS_REQUEST_WRITE_CALENDAR);
                }
        } else {
            Button setcustom = (Button) findViewById(R.id.button);
            Button submit = (Button) findViewById(R.id.button2);

            final Spinner spinner = (Spinner) findViewById(R.id.spinner);
            ArrayList<String> items = new ArrayList<>();


            //ITERATOR
            Cursor cursor = getContentResolver().query(Uri.parse("content://com.android.calendar/calendars"), new String[]{"_id", "name"}, null, null, null);
            cursor.moveToFirst();
            final ArrayList<String> CNames = new ArrayList<>();
            final ArrayList<Integer> CId = new ArrayList<>();
            for (int i = 0; i < cursor.getCount(); i++) {
                CId.add(cursor.getInt(0));
                CNames.add(cursor.getString(1));
                items.add(cursor.getString(1));
                cursor.moveToNext();
            }
            System.out.println(CNames);
            System.out.println(items);

            cursor.close();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
            spinner.setAdapter(adapter);

            if (setcustom != null) {
                setcustom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar now = Calendar.getInstance();
                        DatePickerDialog dpd = DatePickerDialog.newInstance(
                                AgendaActivity.this,
                                now.get(Calendar.YEAR),
                                now.get(Calendar.MONTH),
                                now.get(Calendar.DAY_OF_MONTH)
                        );
                        dpd.show(getFragmentManager(), "Datepickerdialog");
                    }
                });
            }

            if (submit != null) {
                submit.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        RadioGroup keuzes = (RadioGroup) findViewById(R.id.tijdkeuze);
                        try {
                            RadioButton clicked = null;
                            if (keuzes != null) {
                                clicked = (RadioButton) findViewById(keuzes.getCheckedRadioButtonId());
                            }

                            ContentResolver cr = getContentResolver();
                            ContentValues values = new ContentValues();
                            TimeZone timeZone = TimeZone.getDefault();
                            if (getResources().getResourceEntryName(clicked.getId()).equalsIgnoreCase("radiobutton5")) {
                                Calendar beginTime = Calendar.getInstance();
                                long startMillis = 0;
                                long endMillis = 0;
                                beginTime.set(year, month, day, hour, minute);
                                startMillis = beginTime.getTimeInMillis();
                                Calendar endTime = Calendar.getInstance();
                                endTime.set(year, month, day, hour, minute);
                                endMillis = endTime.getTimeInMillis();
                                values.put(CalendarContract.Events.DTSTART, startMillis);
                                values.put(CalendarContract.Events.DTEND, endMillis);
                                values.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone.getID());
                                values.put(CalendarContract.Events.TITLE, "Fiets ophalen");
                                values.put(CalendarContract.Events.DESCRIPTION, selectedmarker.getTitle());
                                System.out.println(CId);
                                System.out.println(CNames);
                                System.out.println(spinner.getSelectedItem().toString());
                                values.put(CalendarContract.Events.CALENDAR_ID, CId.get(CNames.indexOf(spinner.getSelectedItem().toString())));
                                //noinspection MissingPermission
                                cr.insert(CalendarContract.Events.CONTENT_URI, values);

                                Context context = getApplicationContext();
                                CharSequence text = "Afspraak succesvol";
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                                toast.setGravity(4, 1, 1);
                            } else {
                                Calendar newtime = addTime(getResources().getResourceEntryName(clicked.getId()));
                                Calendar beginTime = Calendar.getInstance();
                                long startMillis;
                                long endMillis;
                                beginTime.set(newtime.get(Calendar.YEAR), newtime.get(Calendar.MONTH), newtime.get(Calendar.DAY_OF_MONTH), newtime.get(Calendar.HOUR_OF_DAY), newtime.get(Calendar.MINUTE));
                                startMillis = beginTime.getTimeInMillis();
                                Calendar endTime = Calendar.getInstance();
                                endTime.set(newtime.get(Calendar.YEAR), newtime.get(Calendar.MONTH), newtime.get(Calendar.DAY_OF_MONTH), newtime.get(Calendar.HOUR_OF_DAY), newtime.get(Calendar.MINUTE));
                                endMillis = endTime.getTimeInMillis();

                                values.put(CalendarContract.Events.DTSTART, startMillis);
                                values.put(CalendarContract.Events.DTEND, endMillis);
                                values.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone.getID());
                                values.put(CalendarContract.Events.TITLE, "Fiets ophalen");
                                values.put(CalendarContract.Events.DESCRIPTION, selectedmarker.getTitle());
                                values.put(CalendarContract.Events.CALENDAR_ID, CId.get(CNames.indexOf(spinner.getSelectedItem().toString())));
                                //noinspection MissingPermission
                                cr.insert(CalendarContract.Events.CONTENT_URI, values);

                                Context context = getApplicationContext();
                                CharSequence text = "Afspraak succesvol";
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                                toast.setGravity(4, 1, 1);
                            }
                        } catch (NullPointerException e) {
                            Context context = getApplicationContext();
                            CharSequence text = "Geen tijd geselecteerd";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            toast.setGravity(4, 1, 1);
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        this.year = year;
        this.month = monthOfYear;
        this.day = dayOfMonth;

        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(
                AgendaActivity.this,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                true
        );
        tpd.show(getFragmentManager(), "Timepickerdialog");
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        this.hour = hourOfDay;
        this.minute = minute;
    }

    public Calendar addTime(String Button) {
        Calendar now = Calendar.getInstance();
        if (Button.equalsIgnoreCase("radiobutton")) {
            now.add(Calendar.MINUTE, 30);
        } else if (Button.equalsIgnoreCase("radiobutton2")) {
            now.add(Calendar.MINUTE, 60);
        } else if (Button.equalsIgnoreCase("radiobutton3")) {
            now.add(Calendar.HOUR, 3);
        } else if (Button.equalsIgnoreCase("radiobutton4")) {
            now.add(Calendar.HOUR, 24);
        } else {
            System.out.println("Woopsie");
        }
        return now;
    }


}