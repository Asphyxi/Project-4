package groep2.project4;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startknop = (Button) findViewById(R.id.startknop);

        startknop.setText("Ga naar de app!");
        startknop.setWidth(400);

        final Intent toDrawer = new Intent(this, DrawerActivity.class);


        final Intent callCalendar = new Intent(Intent.ACTION_INSERT);


        startknop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(toDrawer);
            }
        });

        final int callbackId = 42;
        checkPermissions(callbackId, Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR);



    }
    private void checkPermissions(int callbackId, String... permissionsId) {
        boolean permissions = true;
        for (String p : permissionsId) {
            permissions = permissions && ContextCompat.checkSelfPermission(this, p) == 0;
        }

        if (!permissions)
            ActivityCompat.requestPermissions(this, permissionsId, callbackId);
    }

    @Override
    public void onRequestPermissionsResult(int callbackId, String permissions[], int[] grantResults) {


    }
}

//Color Green - Light   #7EC580
//      Green - Dark    #4faf52