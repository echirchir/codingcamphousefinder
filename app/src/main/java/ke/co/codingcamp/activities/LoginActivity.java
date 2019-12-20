package ke.co.codingcamp.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ke.co.codingcamp.R;
import ke.co.codingcamp.ui.House;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.logo)
    ImageView logo;

    @BindView(R.id.login_button)
    Button loginButton;

    @BindView(R.id.user_name)
    EditText userName;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.login_title)
    TextView loginTitle;

    @BindView(R.id.forgot_password)
    TextView forgotPassword;

    @BindView(R.id.register_now)
    TextView registerNow;

    private static final boolean AUTO_HIDE = true;

    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;

    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        mVisible = true;

        mContentView = findViewById(R.id.content_view);

        ButterKnife.bind(this);

        House plazaHouse = new House();

        plazaHouse.setId(1);
        plazaHouse.setDescription("Description");
        plazaHouse.setLocation("Karen");
        plazaHouse.setFloor(3);
        plazaHouse.setIs_deposit_required(true);
        plazaHouse.setPrice(300000);
        plazaHouse.setProperty_owner("Elisha Chirchir");
        plazaHouse.setPhone_number("0717121909");
        plazaHouse.setSize_in_square_feet(5000);
        plazaHouse.setType_of_house("Bungalow");
        plazaHouse.setNumber_of_rooms(8);

    }

    @OnClick(R.id.login_button)
    public void onLogin(){

        //Validate input values from user;
        String user_name = userName.getText().toString().trim();
        String user_password = password.getText().toString().trim();

        if (user_name.length() < 5){

            //warning to the user
            userName.setError("Please enter a valid user name");
        }else if (user_password.length() < 8){

            //warning to the user (at least 8 characters);
            password.setError("Password must be at least 8 characters long.");
        }else{

            login(user_name, user_password);
        }
    }

    private void login(String username, String password){

        //if user exists, then go to house list activity
        //else show warning message
        boolean userExists = true;
        if (userExists){
            //go to next activity
            Intent intent = new Intent(this, SignUpActivity.class);
            finish();
        }else{
            //warn and ask to register;
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    @Override
    public void onClick(View v) {

    }

    private void doLogin(){
    }

    private void doLogout(){

        //remove from login table and go to Home screen;

    }
}
