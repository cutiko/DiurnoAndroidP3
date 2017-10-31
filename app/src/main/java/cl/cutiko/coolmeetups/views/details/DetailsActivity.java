package cl.cutiko.coolmeetups.views.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cl.cutiko.coolmeetups.R;
import cl.cutiko.coolmeetups.data.CurrentUser;
import cl.cutiko.coolmeetups.models.Meetup;

public class DetailsActivity extends AppCompatActivity implements MeetupCallback {

    public static final String MEETUP_KEY = "cl.cutiko.coolmeetups.views.details.DetailsActivity.key.MEETUP_KEY";
    private EditText title, day, location, start, end, description;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        title = findViewById(R.id.titleEt);
        day = findViewById(R.id.dayEt);
        location = findViewById(R.id.locationEt);
        start = findViewById(R.id.startEt);
        end = findViewById(R.id.endEt);
        description = findViewById(R.id.descriptionEt);
        button = findViewById(R.id.saveBtn);

        // FIXME: 31-10-17 you have to get the key from the intent, the constant is created in the top of this file
        String meetupKey = null;

        if (meetupKey != null) {
            //If meetup is not null then we are receiving it from the list, therefore someone clicked the list and want to look at the details
            //then we have to get the meetup, since the data in the list was just a reduced duplicate
            // FIXME: 31-10-17 you have to implement an interface in this file so this presenter can have its callback
            //new FetchMeetup(this).byKey(meetupKey);
        }
        //we don't need an else condition because by default the view allow the user to edit and save

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO call the presenter so you can save the data to the firebase database
                //new SaveMeetup(DetailsActivity.this).toDb(title.getText().toString(), // FIXME: 31-10-17 you should pass more arguments here);
            }
        });
    }

    @Override
    public void missingField() {
        Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void done() {
        finish();
    }

    // FIXME: 31-10-17 this will have to be overriden then the interface is implemented
    //@Override
    public void fetched(Meetup meetup) {
        //TODO this is an example how to set the the data in the view if the user clicked the list, do the rest
        title.setText(meetup.getTitle());


        //if the user is not the owner then we don't allow them to edit
        if (!new CurrentUser().getUid().equals(/*FIXME: 31-10-17 read the String*/ "REPLACE THIS TO FIX THE CONDITION")) {
            //The user is not allow to edit
            title.setEnabled(false);
            //TODO here you have an example of how disable input fields if the user is not the owner
            button.setVisibility(View.GONE);
        }
    }
}
