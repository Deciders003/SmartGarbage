package com.example.saravanan.tomtom.Admin;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.saravanan.tomtom.R;


import java.util.HashMap;
import java.util.Map;

public class AddDriver extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    EditText username, password, mobilno, license;
    Button bt;
String phoneNo,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driver);
        username = findViewById(R.id.driverusername);
        password = findViewById(R.id.driverpass);
        mobilno = findViewById(R.id.drivermobileno);
        license = findViewById(R.id.driverlicense);
        bt = findViewById(R.id.driversub);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1, password1, mobileno1, license1,message1;
                username1 = username.getText().toString();
                password1 = password.getText().toString();
                mobileno1 = mobilno.getText().toString();
                message1="your username is:"+username1+"and \n password is"+password1;
                license1 = license.getText().toString();
                String url = "http://192.168.138.1/php/driverregister.php";
                RequestQueue requestQueue = Volley.newRequestQueue(AddDriver.this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("Registered successfully")) {
                            Toast.makeText(AddDriver.this, response, Toast.LENGTH_SHORT).show();
sendSMS(mobileno1,message1);
                            Intent intent = new Intent(AddDriver.this, Admin.class);
                            startActivity(intent);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("username", username1);
                        params.put("password", password1);
                        params.put("mobile_no", mobileno1);
                        params.put("license_id", license1);
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });
    }

    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            Log.e("errr",ex.getMessage().toString());
            ex.printStackTrace();
        }
    }

}

