package cl.cutiko.coolmeetups.data;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by cutiko on 26-10-17.
 */

public class CurrentUser {

    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    public boolean isLogged() {
        return user != null;
    }

    public String getUid() {
        return user.getUid();
    }
}
