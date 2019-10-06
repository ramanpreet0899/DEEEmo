package com.example.testlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

    TextView TextStatus;
    LoginButton login_button;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(getApplicationContext());
        Login_fb();
        CallBack();


    }

    private void Login_fb(){
        TextStatus=(TextView)findViewById(R.id.TextStatus);
        login_button=(LoginButton)findViewById(R.id.login_button);
        callbackManager=CallbackManager.Factory.create();
    }
    private void CallBack(){
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                TextStatus.setText("Login Sucessful");
            }

            @Override
            public void onCancel() {
                TextStatus.setText("Login Cancelled");

            }

            @Override
            public void onError(FacebookException error) {
                TextStatus.setText("Login error");

            }

        });
    }
    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
