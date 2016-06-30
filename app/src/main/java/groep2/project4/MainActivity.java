package groep2.project4;

import android.content.Context;
import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;

import android.net.Uri;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import groep2.project4.Data.LocalDB;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startknop = (Button) findViewById(R.id.startknop);

        startknop.setText("Ga naar de app!");
        startknop.setWidth(400);

        final Intent toDrawer = new Intent(this, DrawerActivity.class);

        Button kalenderknop = (Button) findViewById(R.id.kalenderknop);
        final Intent callCalendar = new Intent(Intent.ACTION_INSERT);

        kalenderknop.setText("Make a reminder");

        callCalendar.setType("vnd.android.cursor.item/event");
        callCalendar.putExtra(CalendarContract.Events.TITLE, "Bike Reminder");
        callCalendar.putExtra(CalendarContract.Events.EVENT_LOCATION, "Bike location");
        callCalendar.putExtra(CalendarContract.Events.DESCRIPTION, "Pick up your bike!");

        GregorianCalendar callDate = new GregorianCalendar(2016, 5, 27);
        callCalendar.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, callDate.getTimeInMillis());
        callCalendar.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, callDate.getTimeInMillis());
        callCalendar.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, callDate.getTimeInMillis());


        startknop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(toDrawer);
            }
        });

        kalenderknop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(callCalendar);

            }
        });

    }
}

//Color Green - Light   #7EC580
//      Green - Dark    #4faf52