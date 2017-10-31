package cl.cutiko.coolmeetups.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by cutiko on 26-10-17.
 */

public class Nodes {

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference();


    public DatabaseReference fullEvents() {
        // FIXME: 31-10-17 this reference have to return a valid node
        return null;
    }

    public DatabaseReference reducedEvents() {
        return root.child("reduced_events");
    }

}
