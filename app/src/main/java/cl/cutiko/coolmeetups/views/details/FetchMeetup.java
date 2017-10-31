package cl.cutiko.coolmeetups.views.details;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import cl.cutiko.coolmeetups.data.Nodes;
import cl.cutiko.coolmeetups.models.Meetup;

/**
 * Created by cutiko on 26-10-17.
 */

public class FetchMeetup {

    private FetchCallback callback;

    public FetchMeetup(FetchCallback callback) {
        this.callback = callback;
    }

    public void byKey(String key){
        // FIXME: 31-10-17 add a listener for the event and use the callback so you can pass the data back
        new Nodes().fullEvents().child(key).addListenerForSingleValueEvent(null);
    }

}
