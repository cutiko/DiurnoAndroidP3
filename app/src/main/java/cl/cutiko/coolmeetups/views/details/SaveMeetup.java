package cl.cutiko.coolmeetups.views.details;

import com.google.firebase.database.DatabaseReference;

import cl.cutiko.coolmeetups.data.CurrentUser;
import cl.cutiko.coolmeetups.data.Nodes;
import cl.cutiko.coolmeetups.models.Meetup;

/**
 * Created by cutiko on 26-10-17.
 */

public class SaveMeetup {

    private MeetupCallback callback;

    public SaveMeetup(MeetupCallback callback) {
        this.callback = callback;
    }

    public void toDb(String title, String day, String location, String start, String end, String description) {
        //If the user fill every field then we can upload the data, otherwise we have to tell the user what to do
        if (title.trim().length() > 0 && day.trim().length() > 0 && location.trim().length() > 0 && start.trim().length() > 0 && end.trim().length() > 0 && description.trim().length() > 0) {

            //We need 2 database references, because we have to denormalize the data
            DatabaseReference reducedEvents = new Nodes().reducedEvents();
            // FIXME: 31-10-17 full events is returning null go there and fix it
            DatabaseReference fullEvent = new Nodes().fullEvents();
            // FIXME: 31-10-17 you have to get the gey use the reference the push method and then get key
            String key = null;

            Meetup meetup = new Meetup();
            meetup.setKey(key);
            meetup.setTitle(title);
            meetup.setDay(day);
            reducedEvents.child(key).setValue(meetup);

            meetup.setLocation(location);
            meetup.setStart(start);
            meetup.setEnd(end);
            meetup.setDescription(description);
            meetup.setUid(/*FIXME: 31-10-17 read the String to fix this*/ "here you should have the user UID so in the future you can validate if the user is the owner or not");

            fullEvent.child(key).setValue(meetup);

            callback.done();
        } else {
            callback.missingField();
        }
    }
}
