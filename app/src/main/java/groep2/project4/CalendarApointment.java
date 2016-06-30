//package groep2.project4;
//
//import android.content.Intent;
//import android.icu.util.GregorianCalendar;
//import android.os.Bundle;
//import android.os.PersistableBundle;
//import android.provider.CalendarContract;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//
///**
// * Created by Gebruiker on 27-6-2016.
// */
//public class CalendarApointment extends AppCompatActivity {
//
//    @Override
//    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//
//        Button kalenderknop = (Button) findViewById(R.id.kalenderknop);
//        final Intent callCalendar = new Intent(Intent.ACTION_INSERT);
//
//        kalenderknop.setText("Make a reminder");
//
//        callCalendar.setType("vnd.android.cursor.item/event");
//        callCalendar.putExtra(CalendarContract.Events.TITLE, "Bike Reminder");
//        callCalendar.putExtra(CalendarContract.Events.EVENT_LOCATION, "Bike location");
//        callCalendar.putExtra(CalendarContract.Events.DESCRIPTION, "Pick up your bike!");
//
//        GregorianCalendar callDate = new GregorianCalendar(2016, 5, 27);
//        callCalendar.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);
//        callCalendar.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, callDate.getTimeInMillis());
//        callCalendar.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, callDate.getTimeInMillis());
//
//        kalenderknop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(callCalendar);
//            }
//        });
//    }
//}
