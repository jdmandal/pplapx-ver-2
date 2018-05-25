package com.a5e.peopleapex;
import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.webkit.GeolocationPermissions;

import com.example.user.aaa.R;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import java.security.Permission;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CHECK_SETTINGS = 0x1;
    private static GoogleApiClient mGoogleApiClient;
    private static final int ACCESS_COARSE_LOCATION_INTENT_ID = 3;
    private static final String BROADCAST_ACTION = "android.location.PROVIDERS_CHANGED";
    private TextView gps_status;
    private WebView webView;
    ProgressBar bar;
EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          editText =(EditText) findViewById(R.id.oucode);
        Button button = findViewById(R.id.ouid);




        webView = (WebView) this.findViewById(R.id.webview);
        bar = (ProgressBar) findViewById(R.id.progressBar);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editText.getText().toString())) {
                    editText.setError("Please enter valid Ou Code");
                    return;
                }
                Intent intent=new Intent(MainActivity.this,webV.class);
               Intent intent1=new Intent(MainActivity.this,webAhecto.class);
                if(((Integer.valueOf( editText.getText().toString()) > 14900 ) || Integer.valueOf( editText.getText().toString()) == 10001 ))

                startActivity(intent);
                 if(Integer.valueOf(editText.getText().toString())<= 14900 ){

                    startActivity(intent1);

                }

                else{
                    editText.setError("Improper Ou Code");
                }



            }

        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
            System.exit(0);
        }
        return super.onKeyDown(keyCode, event);
    }

}












