package cl.cutiko.coolmeetups.views.login;

import cl.cutiko.coolmeetups.data.CurrentUser;

/**
 * Created by cutiko on 26-10-17.
 */

public class LoginValidation {

    private LoginCallback callback;

    public LoginValidation(LoginCallback callback) {
        this.callback = callback;
    }

    public void isLogged() {
        if (new CurrentUser().isLogged()) {
            callback.logged();
        } else {
            callback.signUp();
        }
    }

}
