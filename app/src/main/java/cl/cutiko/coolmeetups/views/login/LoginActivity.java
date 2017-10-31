package cl.cutiko.coolmeetups.views.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;

import cl.cutiko.coolmeetups.R;
import cl.cutiko.coolmeetups.views.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginCallback {

    private static final int RC_SIGN_IN = 343;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        new LoginValidation(this).isLogged();
    }

    @Override
    public void logged() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void signUp() {
        //TODO login the user here
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //TODO compare the result, if the user successfully login move to main if didn't send them to login again
    }
}
