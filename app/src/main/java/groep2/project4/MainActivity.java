package groep2.project4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        startknop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(toDrawer);
            }
        });
    }


}
