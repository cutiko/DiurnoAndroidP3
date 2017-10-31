package cl.cutiko.coolmeetups.views.details;

import cl.cutiko.coolmeetups.models.Meetup;

/**
 * Created by cutiko on 26-10-17.
 */

public interface FetchCallback {

    void fetched(Meetup meetup);

}
