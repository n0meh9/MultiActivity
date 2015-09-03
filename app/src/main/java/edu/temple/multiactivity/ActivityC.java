package edu.temple.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class ActivityC extends Activity {

    Button openActivityButton;
    Button openActivityButton2;
    TextView messageTextView;
    ArrayList<String> path = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  Associate activity with a layout
        setContentView(R.layout.activity_activity_c);

        /*
            Associate button object in out class with the layout widget.
            findViewById() returns a view so we must cast.
        */
        openActivityButton = (Button) findViewById(R.id.btnOneForC);

        messageTextView = (TextView) findViewById(R.id.txtForC);

        //  Retrieve the intent used to launch this instance of the activity
        Intent receivedIntent = getIntent();

        //  Grad the data that was passed.
        final ArrayList<String> path = receivedIntent.getStringArrayListExtra("Key");

        //  Display the received message in the text view
        String intentDataString = "";
        Iterator<String> it = path.iterator();
        if (path.size() == 1) {
            intentDataString = it.next();
        } else {
            intentDataString = it.next();
            while (it.hasNext()) {
                intentDataString = it.next() + ", which was " + intentDataString;
            }
        }

        messageTextView.setText(intentDataString);


        // Create listener for click event
        View.OnClickListener oc1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                    An intent to launch a speciific activity must be provided with
                    Context (Activity.this) and a Target (ActivityB.class). Context
                    is provided in many places in Android, including Activities.
                */
                Intent launchActivityIntent = new Intent(ActivityC.this, ActivityA.class);

                //  Some data we want to pass to the child activity
                String dataString = "opened by C";
                path.add(dataString);

                //  Place the data in the intent
                launchActivityIntent.putStringArrayListExtra("Key", path);

                //  Launch the activity using the created intent. Fire and Forget method.
                startActivity(launchActivityIntent);
            }
        };

        // Assign click listener to our button
        openActivityButton.setOnClickListener(oc1);

        /*
            Associate button object in out class with the layout widget.
            findViewById() returns a view so we must cast.
        */
        openActivityButton2 = (Button) findViewById(R.id.btnTwoForC);

        // Create listener for click event
        View.OnClickListener oc2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                    An intent to launch a speciific activity must be provided with
                    Context (Activity.this) and a Target (ActivityB.class). Context
                    is provided in many places in Android, including Activities.
                */
                Intent launchActivityIntent = new Intent(ActivityC.this, ActivityB.class);

                //  Some data we want to pass to the child activity
                String dataString = "opened by C";
                path.add(dataString);

                //  Place the data in the intent
                launchActivityIntent.putStringArrayListExtra("Key", path);

                //  Launch the activity using the created intent. Fire and Forget method.
                startActivity(launchActivityIntent);
            }
        };

        // Assign click listener to our button
        openActivityButton2.setOnClickListener(oc2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_c, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
